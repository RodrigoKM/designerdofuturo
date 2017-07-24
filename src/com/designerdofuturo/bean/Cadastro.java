package com.designerdofuturo.bean;

public class Cadastro {
	private String nomeCompleto;
	private String email;
	private String stack;
	private String ip;

	public Cadastro(String nomeCompleto, String email, String stack, String ip) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.stack = stack;
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

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}