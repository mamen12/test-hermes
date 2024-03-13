package com.example.test.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmployeeResponse {
	@JsonProperty(value = "id_employee")
	private Long id;
	
	@JsonProperty(value = "nama_employee")
	private String nama;
	
	@JsonProperty(value = "tanggal_lahir")
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern =  "dd-MM-yyyy" , timezone = "Asia/Jakarta")
	private Date tglLahir;

	@JsonProperty(value = "status_employee")
	private Integer status;

	@JsonProperty(value = "group_id")
	private Long groupId;
	
	@JsonProperty(value = "saldo_id")
	private Long saldoId;
	
	
	public EmployeeResponse() {
		super();
	}

	public EmployeeResponse(Long id, String nama, Date tglLahir, Integer status) {
		super();
		this.id = id;
		this.nama = nama;
		this.tglLahir = tglLahir;
		this.status = status;
	}

	public EmployeeResponse(Long id, String nama, Date tglLahir, Integer status, Long groupId, Long saldoId) {
		super();
		this.id = id;
		this.nama = nama;
		this.tglLahir = tglLahir;
		this.status = status;
		this.groupId = groupId;
		this.saldoId = saldoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getSaldoId() {
		return saldoId;
	}

	public void setSaldoId(Long saldoId) {
		this.saldoId = saldoId;
	}
	
	
}

