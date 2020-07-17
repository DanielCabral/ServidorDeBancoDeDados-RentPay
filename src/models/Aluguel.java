package models;

import java.io.Serializable;
import java.util.Date;

public class Aluguel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long idItem;
	private long idLocatario;
	private String idLocador;
	private Date dataInicial;
	private String dataFinal;
	private String status;
	
	public Aluguel() {
		super();
	}
			
	public Aluguel(long id, long idItem, long idLocatario, String idLocador, Date dataInicial, String dataFinal,
			String status) {
		this.id = id;
		this.idItem = idItem;
		this.idLocatario = idLocatario;
		this.idLocador = idLocador;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public long getIdItem() {
		return idItem;
	}
	public long getIdLocatario() {
		return idLocatario;
	}
	public String getIdLocador() {
		return idLocador;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public String getStatus() {
		return status;
	}
	
	
	
}
