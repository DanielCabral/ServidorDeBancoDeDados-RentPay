




import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stub {
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "Servidor";
	Registry registro;
	InterfaceDoServidor stub;
	
	public Stub() {
		try {
			
			//Politica de seguran�a
			System.setProperty("java.security.policy", "java.policy");
			if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager());
			}
			
			System.setProperty("java.security.policy","file:java.policy");
			
			
			// Obtendo refer^encia do servi¸co de registro
			registro = LocateRegistry.getRegistry(nomeServidor, porta);
			System.out.println("Conectado com servidor");
			// Procurando pelo objeto distribu´ıdo registrado previamente com o NOMEOBJDIST
			stub = (InterfaceDoServidor) registro.lookup(NOMEOBJDIST);
		} catch (RemoteException | NotBoundException ex) {
			Logger.getLogger(Stub.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public boolean logar(String name, String password) throws RemoteException, SQLException{
		return stub.logar(name, password);
	}
	
	public static void main(String [] args) throws RemoteException, SQLException {
		Stub s = new Stub();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.logar("Daniel", "123"));
	}
	
}
