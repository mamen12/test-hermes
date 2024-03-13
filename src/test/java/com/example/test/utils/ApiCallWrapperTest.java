package com.example.test.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.test.beans.CandidateRequest;
import com.example.test.beans.EmployeeRequest;
import com.example.test.beans.EmployeeResponse;
import com.example.test.beans.Request;
import com.fasterxml.jackson.core.type.TypeReference;


@SpringBootTest
class ApiCallWrapperTest {
	// test
	@Value("${api.protocol}")
	private String protocol;
	
	@Value("${api.webservice.hookb.host}")
	private String host;
	
	@Value("${api.webservice.hookb.path.satu}")
	private String pathSatu;
	
	
	// check local
	@Value("${api.protocol.local}")
	private String protocolLocal;
	
	@Value("${api.webservice.employee.host}")
	private String hostEmployee;
	
	@Value("${api.webservice.employee.port}")
	private int portEmployee;
	
	@Value("${api.webservice.employee.path.detail}")
	private String pathDetailEmployee;
	
	@Autowired
	RestTemplate restTemplate;

	@Test
	void testLocal() throws Exception {
		// testing another local API with class created manualy
		String url = String.format("%s://%s:%d%s", protocolLocal, hostEmployee, portEmployee, pathDetailEmployee);
		
		Request<EmployeeRequest> rq = new Request<>();
		EmployeeRequest rqEmployee = new EmployeeRequest();
		rqEmployee.setId(12L);
		rq.setRequestPayload(rqEmployee);
		
		ApiCallWrapper api = new ApiCallWrapper();
		TypeReference<EmployeeResponse> type = new TypeReference<EmployeeResponse>() {
		};
		EmployeeResponse response = api.callExternalApi(url, "POST", type, rq);
		assertNotNull(response);
	}
	
	@Test
	void testLocalRestTemplate() {
		// testing another local with RestTemplate 
		String url = String.format("%s://%s:%d%s", protocolLocal, hostEmployee, portEmployee, pathDetailEmployee);
		
		Request<EmployeeRequest> rq = new Request<>();
		EmployeeRequest rqEmployee = new EmployeeRequest();
		rqEmployee.setId(12L);
		rq.setRequestPayload(rqEmployee);
		
		EmployeeResponse emplo = restTemplate.postForObject(url, rq, EmployeeResponse.class);
		assertNotNull(emplo);
	}
	
	@Test
	void testHookbNo2() throws Exception {
		// test ini masih gagal karena url not response, saya coba di postman juga sama gada response sama sekali
		// testing another API https://hookb.in with class created manualy
		String url = String.format("%s://%s%s%s", protocol, host, "", pathSatu);
		CandidateRequest rq = new CandidateRequest();
		rq.setName("nama_kandidat");
		rq.setAddress("address_kalimat");
		
		ApiCallWrapper api = new ApiCallWrapper();
		TypeReference<Object> type = new TypeReference<Object>() {
		};
		Object response = api.callExternalApi(url, "POST", type, rq);
		assertNull(response);
		
	}
	
	
	@Test
	void testHookbNo3() throws Exception {
		// test ini masih gagal karena url not response, saya coba di postman juga sama gada response sama sekali
		// testing another API https://hookb.in with class created manualy
		String url = String.format("%s://%s%s%s", protocol, host, "", pathSatu);
		CandidateRequest rq = new CandidateRequest();
		rq.setNid(10);
		rq.setOfficeId(3);
		
		ApiCallWrapper api = new ApiCallWrapper();
		TypeReference<Object> type = new TypeReference<Object>() {
		};
		Object response = api.callExternalApi(url, "POST", type, rq);
		assertNull(response);
	}

}
