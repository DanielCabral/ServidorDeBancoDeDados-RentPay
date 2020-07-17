package models;

import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String cpf;
	private String telefone;
	private String nome;
	private String email;
	private String dataDeNascimento;
	private String senha;
	private Endereco endereco = null;
	
    //default constructor
    public Usuario()
    {
     super();
    }
	
	public Usuario(long id, String cpf, String telefone, String nome, String email, String dataDeNascimento,
			String senha, Endereco endereco) {
		this.endereco = endereco;
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.senha = senha;
	}
	
	public Usuario(long id, String cpf, String telefone, String nome, String email, String dataDeNascimento,
			String senha) {
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	
}
