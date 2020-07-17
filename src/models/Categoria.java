package models;

import java.io.Serializable;

public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String descricao;
	
	public Categoria() {
		super();
	}
	
	public Categoria(long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
