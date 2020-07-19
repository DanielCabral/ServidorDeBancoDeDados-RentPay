package models;

import java.io.Serializable;

public class Anuncio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String descricao;
	private String foto;
	private int idCategoria;
	private String cep;
	private String tipoDeEntrega;
	private double preco;
	private String periodo;
	private int fk_Categoria_id;
	private int fk_Usuario_Endereco_id;
	
	public Anuncio() {
		
	}
	
	public Anuncio(int id, String nome, String descricao, String foto, String cep,
			String tipoDeEntrega, double preco, String periodo, int fk_Categoria_id, int fk_Usuario_Endereco_id) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.cep = cep;
		this.tipoDeEntrega = tipoDeEntrega;
		this.preco = preco;
		this.periodo = periodo;
		this.fk_Categoria_id = fk_Categoria_id;
		this.fk_Usuario_Endereco_id = fk_Usuario_Endereco_id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getFoto() {
		return foto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public String getCep() {
		return cep;
	}
	public String getTipoDeEntrega() {
		return tipoDeEntrega;
	}
	public double getPreco() {
		return preco;
	}

	public int getCategoria() {
		return fk_Categoria_id;
	}

	public int getUsuario() {
		return fk_Usuario_Endereco_id;
	}
	
	public String getPeriodo() {
		return periodo;
	}
}
