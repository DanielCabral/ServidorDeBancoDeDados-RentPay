package server;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.MysqlCon;


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

	      ResultSet rs = conexao.executarQueryNoBanco(query);
	      rs.next();
	      int count = rs.getInt("qtd");
	      if(count > 0) 
	    	  return true;
	      return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	      return false;
	    }

	}
