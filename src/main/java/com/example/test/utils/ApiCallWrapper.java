package com.example.test.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiCallWrapper {
	
	Logger logger = LoggerFactory.getLogger(ApiCallWrapper.class);
	
	private String method;
	private TypeReference<Object> rqBody;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public TypeReference<Object> getRqBody() {
		return rqBody;
	}
	public void setRqBody(TypeReference<Object> rqBody) {
		this.rqBody = rqBody;
	}
	
	
	public <T> T callExternalApi(String pathUrl, String method, TypeReference<T> responseRef, Object request) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(pathUrl);
		String requestBody = mapper.writeValueAsString(request); 
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(method);
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(requestBody);
		out.flush();
		out.close();
		
		int rsCode = con.getResponseCode();
		
		StringBuilder response = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine = "";
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        logger.info(pathUrl + " | response code : " + rsCode );
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		T responseObject = mapper.readValue(response.toString(), responseRef);
        
		return responseObject;
		
	}
	
	
	
}
