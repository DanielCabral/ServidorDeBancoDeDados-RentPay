package com.example.server;




import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.MysqlCon;
import models.Usuario;


public class Servidor implements InterfaceDoServidor, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MysqlCon conexao=new MysqlCon();
	@Override
	public boolean logar(String name, String password) throws RemoteException, SQLException {
		try {
		String query = "SELECT count(*) as qtd FROM usuarios where name= \""+name+"\" and password = \""+password+"\"";
		System.out.println(query);
	      ResultSet rs = conexao.executarQueryNoBanco(query);
	      rs.next();
	      int count = rs.getInt("qtd");
	      System.out.println(count);
	      if(count > 0) 
	    	  return true;
	      return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	      return false;
    }
	
	@Override
	public int cadastrarUsuario(Usuario usuario) throws RemoteException, SQLException {
	    int id=-1;
		String cpf = usuario.getCpf();
		String telefone = usuario.getTelefone(); 
		String nome = usuario.getNome();
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		
		try {
			String query = " insert into usuario (cpf, telefone, nome, email, senha)"
			        + " values (?, ?, ?, ?, ?)";
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	      preparedStmt.setString(1, cpf);
	      preparedStmt.setString(2, telefone);
	      preparedStmt.setString(3, nome);
	      preparedStmt.setString(4, email);
	      preparedStmt.setString(5, senha);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      

	      ResultSet rs = preparedStmt.getGeneratedKeys();
          if(rs.next())
          {
              id = rs.getInt(1);
          }
          return id;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
    }
	
	public static void main(String [] args) throws RemoteException, SQLException {
		Servidor s = new Servidor();
		s.cadastrarUsuario(new Usuario(0,"211221121","99999999", "nome", "dawd@adwd.com", "daad", "dadaw"));
	}
	
}
