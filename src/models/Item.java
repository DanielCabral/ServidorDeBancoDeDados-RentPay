package models;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String descricao;
	private String foto;
	private long idCategoria;
	private String cep;
	private String tipoDeProduto;
	private String tipoDeEntrega;
	private double preco;
	
	public Item() {
		
	}
	
	public Item(long id, String descricao, String foto, long idCategoria, String cep, String tipoDeProduto,
			String tipoDeEntrega, double preco) {
		this.id = id;
		this.descricao = descricao;
		this.foto = foto;
		this.idCategoria = idCategoria;
		this.cep = cep;
		this.tipoDeProduto = tipoDeProduto;
		this.tipoDeEntrega = tipoDeEntrega;
		this.preco = preco;
	}
	
	public long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getFoto() {
		return foto;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public String getCep() {
		return cep;
	}
	public String getTipoDeProduto() {
		return tipoDeProduto;
	}
	public String getTipoDeEntrega() {
		return tipoDeEntrega;
	}
	public double getPreco() {
		return preco;
	}
	
	
}
