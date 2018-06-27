package model;

import java.util.Date;

import exceptions.EmptyRAException;

public class Aluno {
	
	private String ra;
	private String nome;
	private Date nascimento;
	
	public Aluno (String ra)
	throws EmptyRAException {
		this.setRa(ra);
	}
	
	public Aluno (String ra, String nome, Date nascimento) 
	throws EmptyRAException {
		this.setRa(ra);
		this.setNome(nome);
		this.setNascimento(nascimento);
	}
	
	public String getRa() {
		return this.ra;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getNascimento() {
		return this.nascimento;
	}

	public void setRa(String ra) 
	throws EmptyRAException {
		if (ra.isEmpty())
			throw new EmptyRAException();
		this.ra = ra;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String toString() {
		return this.nome;
	}

}
