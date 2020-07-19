package com.example.server;




import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.MysqlCon;
import models.Aluguel;
import models.Anuncio;
import models.Categoria;
import models.Endereco;
import models.Usuario;


public class Servidor implements InterfaceDoServidor, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MysqlCon conexao=new MysqlCon();
	@Override
	public boolean logar(String email, String password) throws RemoteException, SQLException {
		try {
		String query = "SELECT count(*) as qtd FROM usuario where nome= \""+email+"\" and senha = \""+password+"\"";
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
	
	@Override
	public int cadastrarEndereco(Endereco endereco, int id_user) throws RemoteException, SQLException {
			String logradouro = endereco.getLogradouro();
			int numero = endereco.getNumero();
			String complemento = endereco.getComplemento();
			String bairro = endereco.getBairro();
			String cep = endereco.getCep();
			String cidade = endereco.getCidade();
			String uf = endereco.getUf();
			
			try {
				String query = " update usuario set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, uf  = ? where id="+id_user;
			System.out.println(query);
			  
			  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
		      preparedStmt.setString(1, logradouro);
		      preparedStmt.setInt(2, numero);
		      preparedStmt.setString(3, complemento);
		      preparedStmt.setString(4, bairro);
		      preparedStmt.setString(5, cep);
		      preparedStmt.setString(6, cidade);
		      preparedStmt.setString(7, uf);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      return 1;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return -1;
	}

	@Override
	public int cadastrarCategoria(Categoria categoria) throws RemoteException, SQLException {
		 int id=-1;
			String nome = categoria.getNome();
			String descricao = categoria.getDescricao(); 
			
			try {
				String query = " insert into categoria (nome, descricao)"
				        + " values (?, ?)";
			System.out.println(query);
			  
			  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		      preparedStmt.setString(1, nome);
		      preparedStmt.setString(2, descricao);
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
			return id;
	}

	@Override
	public int cadastrarAluguel(Aluguel aluguel) throws RemoteException, SQLException {
		 	int id=-1;
			int idItem = aluguel.getIdItem();
			int idLocatario = aluguel.getIdLocatario();
			int idLocador = aluguel.getIdLocador();
			String dataInicial = aluguel.getDataInicial();
			String dataFinal = aluguel.getDataFinal();
			String status = aluguel.getStatus();
			
			try {
				String query = " insert into aluguel (id_Item, id_Locatario, id_Locador, data_inicial, data_final, status, fk_Usuario_Endereco_id, fk_Anuncio_id)"
				        + " values (?, ? , ? , ?, ?)";
			System.out.println(query);
			  
			  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		      preparedStmt.setInt(1, idItem);
		      preparedStmt.setInt(2, idLocatario);
		      preparedStmt.setInt(3, idLocador);
		      preparedStmt.setString(4, dataInicial);
		      preparedStmt.setString(5, dataFinal);
		      preparedStmt.setString(6, status);
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
			return id;
	}

	@Override
	public int cadastrarAnuncio(Anuncio anuncio) throws RemoteException, SQLException {
		 int id=-1;
		 String nome = anuncio.getNome();
		 String descricao = anuncio.getDescricao();
		 String foto = anuncio.getFoto();
		 String cep = anuncio.getCep();
		 String tipoDeEntrega = anuncio.getTipoDeEntrega();
		 double preco = anuncio.getPreco();
		 String periodo = anuncio.getPeriodo();
		 int fk_Categoria_id = anuncio.getCategoria();
		 int fk_Usuario_Endereco_id = anuncio.getUsuario();
			
			try {
				String query = " insert into anuncio (nome, descricao, foto, cep, tipo_de_entrega, preco, periodo, fk_Categoria_id, fk_Usuario_Endereco_id)"
				        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			  
			  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		      preparedStmt.setString(1, nome);
		      preparedStmt.setString(2, descricao);
		      preparedStmt.setString(3, foto);
		      preparedStmt.setString(4, cep);
		      preparedStmt.setString(5, tipoDeEntrega);
		      preparedStmt.setDouble(6, preco);
		      preparedStmt.setString(7, periodo);
		      preparedStmt.setInt(8, fk_Categoria_id);
		      preparedStmt.setInt(9, fk_Usuario_Endereco_id);
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
			return id;
	}
	
	public static void main(String [] args) throws RemoteException, SQLException {
		Servidor s = new Servidor();
		s.cadastrarUsuario(new Usuario(0,"211221121","99999999", "nome", "dawd@adwd.com", "daad", "dadaw"));
	}

	public Usuario dadosDoUsuario(int id) throws RemoteException, SQLException {
		try {
		String query = "SELECT * FROM usuario where id="+id;
		System.out.println(query);
	      ResultSet rs = conexao.executarQueryNoBanco(query);
	      rs.next();
	      //pegar os dados do banco e salvar em variaveis
	      int id_user = rs.getInt("id");
	      String cpf = rs.getString("cpf");
	      String telefone = rs.getString("telefone");
	      String nome = rs.getString("nome");
	      String email = rs.getString("email");
	      String dataDeNascimento = rs.getString("data_de_nascimento");
	      String senha = rs.getString("senha");
	      Endereco endereco = dadosDeEndereco(id_user);
	      
	      Usuario user= new Usuario(id_user, cpf, telefone, nome, email, dataDeNascimento, senha, endereco);
	      return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@Override
	public Endereco dadosDeEndereco(int id) throws RemoteException, SQLException {
		try {
			String query = "SELECT * FROM usuario where id="+id;
			System.out.println(query);
		      ResultSet rs = conexao.executarQueryNoBanco(query);
		      rs.next();
		      
		      //pegar os dados do banco e salvar em variaveis
		      String logradouro = rs.getString("logradouro");
		      int numero = rs.getInt("numero");
		      String complemento = rs.getString("complemento");
		      String bairro = rs.getString("bairro");
		      String cep = rs.getString("cep");
		      String cidade = rs.getString("cidade");
		      String uf = rs.getString("uf");
		      
		      Endereco endereco = new Endereco(numero, logradouro, complemento, bairro, cep, cidade, uf);
		      return endereco;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Categoria dadosDeCategoria(int id) throws RemoteException, SQLException {
		try {
			String query = "SELECT * FROM categoria where id="+id;
			System.out.println(query);
		      ResultSet rs = conexao.executarQueryNoBanco(query);
		      rs.next();
		      
		      //pegar os dados do banco e salvar em variaveis
		      int id_end = rs.getInt("id");
		      String nome = rs.getString("nome");
		      String descricao = rs.getString("descricao");
		      
		     Categoria categoria =new Categoria(id_end, nome, descricao);
		      return categoria;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Aluguel dadosDeAluguel(int id) throws RemoteException, SQLException {
		try {
			String query = "SELECT * FROM aluguel where id="+id;
			System.out.println(query);
		      ResultSet rs = conexao.executarQueryNoBanco(query);
		      rs.next();
		      
		      //pegar os dados do banco e salvar em variaveis
		      int id_alu = rs.getInt("id");
		      int id_item = rs.getInt("id_item");
		      int id_locatario = rs.getInt("id_Locatario");
		      int id_locador = rs.getInt("id_Locador");
		      String dataInicial = rs.getString("data_inicial");
		      String datafinal = rs.getString("data_final");
		      String status = rs.getString("status");
		     
		      Aluguel aluguel = new Aluguel(id_alu, id_item, id_locatario, id_locador, dataInicial, datafinal, status);
		      return aluguel;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Anuncio dadosDoAnuncio(int id) throws RemoteException, SQLException {
		try {
			String query = "SELECT * FROM anuncio where id="+id;
			System.out.println(query);
		      ResultSet rs = conexao.executarQueryNoBanco(query);
		      rs.next();
		      
		      //pegar os dados do banco e salvar em variaveis
		      int id_anu = rs.getInt("id");
		      String nome = rs.getString("nome");
		      String descricao = rs.getString("descricao");
		      String foto = rs.getString("foto");
		      String cep = rs.getString("cep");
		      String tipo_de_entrega = rs.getString("tipo_de_entrega");
		      double preco = rs.getDouble("preco");
		      String periodo = rs.getString("periodo");
		      int categoria = rs.getInt("fk_Categoria_id");
		      int usuario = rs.getInt("fk_Usuario_Endereco_id");
		     
		      Anuncio anuncio = new Anuncio(id_anu, nome, descricao, foto, cep, tipo_de_entrega, preco, periodo, categoria, usuario);
		      
		      return anuncio;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}


	@Override
	public boolean atualizarUsuario(Usuario usuario) throws RemoteException, SQLException {
		int id = usuario.getId();
		String cpf = usuario.getCpf();
		String telefone = usuario.getTelefone(); 
		String nome = usuario.getNome();
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		
		try {
			String query = " update usuario set nome = ?,cpf = ?, telefone = ?, email = ?, senha = ? where id="+id;
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
	      preparedStmt.setString(1, nome);
	      preparedStmt.setString(2, cpf);
	      preparedStmt.setString(3, telefone);
	      preparedStmt.setString(4, email);
	      preparedStmt.setString(5, senha);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean atualizarEndereco(Endereco endereco,int id_user) throws RemoteException, SQLException {
		String logradouro = endereco.getLogradouro();
		int numero = endereco.getNumero();
		String complemento = endereco.getComplemento();
		String bairro = endereco.getBairro();
		String cep = endereco.getCep();
		String cidade = endereco.getCidade();
		String uf = endereco.getUf();
		
		try {
			String query = " update usuario set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, uf  = ? where id="+id_user;
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
	      preparedStmt.setString(1, logradouro);
	      preparedStmt.setInt(2, numero);
	      preparedStmt.setString(3, complemento);
	      preparedStmt.setString(4, bairro);
	      preparedStmt.setString(5, cep);
	      preparedStmt.setString(6, cidade);
	      preparedStmt.setString(7, uf);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean atualizarCategoria(Categoria categoria) throws RemoteException, SQLException {
		int id = categoria.getId();
		String nome = categoria.getNome();
		String descricao = categoria.getDescricao();
		
		try {
			String query = " update categoria set nome = ?, descricao = ? where id="+id;
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
	      preparedStmt.setString(1, nome);	 
	      preparedStmt.setString(2, descricao);

	      preparedStmt.execute();
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean atualizarAluguel(Aluguel aluguel) throws RemoteException, SQLException {
		int id = aluguel.getId();
		String status = aluguel.getStatus();
		
		try {
			String query = " update aluguel set status  = ? where id="+id;
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
	      preparedStmt.setString(1, status);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean atualizarAnuncio(Anuncio anuncio) throws RemoteException, SQLException {
		int id = anuncio.getId();
		String nome = anuncio.getNome();
		 String descricao = anuncio.getDescricao();
		 String foto = anuncio.getFoto();
		 String cep = anuncio.getCep();
		 String tipoDeEntrega = anuncio.getTipoDeEntrega();
		 double preco = anuncio.getPreco();
		 String periodo = anuncio.getPeriodo();
		 int fk_Categoria_id = anuncio.getCategoria();
		
		try {
			String query = " update usuario set nome = ?, descricao = ?, foto = ?, cep = ?, tipoDeEntrega = ?, preco  = ?, periodo = ?, fk_Categoria_id = ? where id="+id;
		System.out.println(query);
		  
		  PreparedStatement preparedStmt = conexao.getConexao().prepareStatement(query);
		   preparedStmt.setString(1, nome);
		      preparedStmt.setString(2, descricao);
		      preparedStmt.setString(3, foto);
		      preparedStmt.setString(4, cep);
		      preparedStmt.setString(5, tipoDeEntrega);
		      preparedStmt.setDouble(6, preco);
		      preparedStmt.setString(7, periodo);
		      preparedStmt.setInt(8, fk_Categoria_id);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean removerUsuario(int idUsuario) throws RemoteException, SQLException {
		String query = "delete from usuario where id="+idUsuario;
		System.out.println(query);
		try { 
		      Statement stmt = conexao.getConexao().createStatement();		      
		      stmt.executeUpdate(query);
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;
	}


	@Override
	public boolean removerCategoria(int idCategoria) throws RemoteException, SQLException {
		String query = "delete from categoria where id="+idCategoria;
		System.out.println(query);
		try { 
		      Statement stmt = conexao.getConexao().createStatement();		      
		      stmt.executeUpdate(query);
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;
	}


	@Override
	public boolean removerAluguel(int idAluguel) throws RemoteException, SQLException {
		String query = "delete from aluguel where id="+idAluguel;
		System.out.println(query);
		try { 
		      Statement stmt = conexao.getConexao().createStatement();		      
		      stmt.executeUpdate(query);
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;
	}


	@Override
	public boolean removerAnuncio(int idAnuncio) throws RemoteException, SQLException {
		String query = "delete from anuncio where id="+idAnuncio;
		System.out.println(query);
		try { 
		      Statement stmt = conexao.getConexao().createStatement();		      
		      stmt.executeUpdate(query);
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;
	}

	

	
}
