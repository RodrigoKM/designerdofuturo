package com.designerdofuturo.bean;

public class Cadastro {
	private String nomeCompleto;
	private String email;
	private String area;
	private String ip;
	
	public Cadastro( String nomeCompleto, String email, String area, String ip) {
		
		super();
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.area = area;
		this.ip = ip;
		
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getIP() {
		return area;
	}
	public void setIP(String IP) {
		this.ip = IP;
	}

}
