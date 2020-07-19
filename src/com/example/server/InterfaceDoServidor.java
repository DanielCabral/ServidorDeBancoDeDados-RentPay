package com.example.server;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import models.Aluguel;
import models.Anuncio;
import models.Categoria;
import models.Endereco;
import models.Usuario;

public interface InterfaceDoServidor extends Remote{

	
	public boolean logar(String name, String password) throws RemoteException, SQLException;
	public int cadastrarUsuario(Usuario usuario) throws RemoteException, SQLException;
	public int cadastrarEndereco(Endereco usuario, int id_user) throws RemoteException, SQLException;
	public int cadastrarCategoria(Categoria usuario) throws RemoteException, SQLException;
	public int cadastrarAluguel(Aluguel usuario) throws RemoteException, SQLException;
	public int cadastrarAnuncio(Anuncio usuario) throws RemoteException, SQLException;
	public boolean atualizarUsuario(Usuario usuario) throws RemoteException, SQLException;
	boolean atualizarEndereco(Endereco endereco, int id_user) throws RemoteException, SQLException;
	public boolean atualizarCategoria(Categoria usuario) throws RemoteException, SQLException;
	public boolean atualizarAluguel(Aluguel usuario) throws RemoteException, SQLException;
	public boolean atualizarAnuncio(Anuncio usuario) throws RemoteException, SQLException;
	public boolean removerUsuario(int idUsuario) throws RemoteException, SQLException;
	public boolean removerCategoria(int idCategoria) throws RemoteException, SQLException;
	public boolean removerAluguel(int idAluguel) throws RemoteException, SQLException;
	public boolean removerAnuncio(int idAnuncio) throws RemoteException, SQLException;
	public Usuario dadosDoUsuario(int id) throws RemoteException, SQLException;
	public Endereco dadosDeEndereco(int id) throws RemoteException, SQLException;
	public Categoria dadosDeCategoria(int id) throws RemoteException, SQLException;
	public Aluguel dadosDeAluguel(int id) throws RemoteException, SQLException;
	public Anuncio dadosDoAnuncio(int id) throws RemoteException, SQLException;
}
