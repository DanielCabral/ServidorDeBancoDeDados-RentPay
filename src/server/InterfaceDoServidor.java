package server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

//Criando a interface (Skeleton) do servidor
public interface InterfaceDoServidor extends Remote{

	
	public boolean logar(String name, String password) throws RemoteException, SQLException;
}
