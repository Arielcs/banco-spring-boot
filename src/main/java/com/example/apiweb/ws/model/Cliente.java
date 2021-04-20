package com.example.apiweb.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
	//Gera id altomaticamente
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Float saldoConta;
	
	public Integer getId() {
		return id; 
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Float getSaldoConta() {
		return saldoConta;
	}
	
	public void setSaldoConta(Float saldoConta) {
		this.saldoConta = saldoConta;
	}
	
}
