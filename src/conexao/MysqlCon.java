package conexao;
import java.sql.*;
import java.util.Properties;  
public class MysqlCon{  
	
	Connection conn = null;
	
	public MysqlCon() {
	    try {
//	        conn = DriverManager.getConnection(
//	                   "jdbc:mysql://localhost:3306/",
//	                   connectionProps);
	        conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/rentpay?useTimezone=true&serverTimezone=UTC","root","");
	    System.out.println("Connected to database");
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
	}
	
	public ResultSet executarQueryNoBanco(String query) throws SQLException {
		// create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      //st.close();
		return rs;		
	}
	public static void main(String args[]) throws SQLException{  
	 	String userName = "rentpay";
	 	String password = "1234";
	 	MysqlCon conexao=new MysqlCon();
	    
	 	try {
	 		String query = "SELECT count(*) as qtd FROM usuarios where name= \"daniel\" and password = \""+password+"\"";

	      ResultSet rs = conexao.executarQueryNoBanco(query);
	      rs.next();
	      
	      int count = rs.getInt("qtd");
	      System.out.println(count);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}  

}