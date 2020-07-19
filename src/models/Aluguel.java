package models;

import java.io.Serializable;

public class Aluguel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int idItem;
	private int idLocatario;
	private int idLocador;
	private String dataInicial;
	private String dataFinal;
	private String status;
	
	
	public Aluguel() {
		super();
	}
			
	public Aluguel(int id, int idItem, int idLocatario, int idLocador, String dataInicial, String dataFinal,
			String status) {
		this.id = id;
		this.idItem = idItem;
		this.idLocatario = idLocatario;
		this.idLocador = idLocador;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public int getIdItem() {
		return idItem;
	}
	public int getIdLocatario() {
		return idLocatario;
	}
	public int getIdLocador() {
		return idLocador;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public String getStatus() {
		return status;
	}
	
	
	
}
