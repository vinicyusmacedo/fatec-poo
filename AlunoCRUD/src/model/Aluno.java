package model;

import java.util.Date;

public class Aluno {
	
	private String ra;
	private String nome;
	private Date nascimento;
	
	public String getRa() {
		return this.ra;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getNascimento() {
		return this.nascimento;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
