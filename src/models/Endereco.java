package models;

import java.io.Serializable;

public class Endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	
	public Endereco() {
		
	}
	
	public Endereco(long id, String logradouro, int numero, String complemento, String bairro, String cep,
			String cidade, String uf) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}
	
	
}
