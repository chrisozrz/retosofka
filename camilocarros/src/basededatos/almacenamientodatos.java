package basededatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import datosdecarrera.carrertera;
import datosdecarrera.dado;

public class almacenamientodatos {

	private Statement statement;
	private Connection cnn;	
	private String driverODBC;
	private String rutadelaBD;
	private String user;
	private String pass;

	public almacenamientodatos(){
		this.cnn = null;
		this.statement = null;
		this.driverODBC = "com.mysql.jdbc.Driver";
		this.rutadelaBD = "jdbc:mysql://localhost/camilocarreraautos";
		this.user = "root";
		this.pass = "";
	}
	
	
    public void insert(dado dados, carrertera pista){
    	 int j;
    	 for (int i = 0; i < 7; i++){
    		 j = i+1;
    		 int idJuego = 1;
    		 DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    		 ejecutar("INSERT INTO ganadores VALUES('" + idJuego + "', '"+ dados.getubicaciones()[i][0] + "', '" + j + "','" + dtf4.format(LocalDateTime.now()) + "')");
         }
	}
    
    public String ejecutar(String sentencia){
    	try	{
			Class.forName(this.driverODBC);
			this.cnn = DriverManager.getConnection(this.rutadelaBD, this.user, this.pass);
			this.statement = this.cnn.createStatement();
			this.statement.executeUpdate(sentencia);
			return "Registro Realizado =)";
		}	 
		catch (SQLException e){
			e.printStackTrace();	
			if (e.getErrorCode()==1062)
				return "El registro ya existe =(";
			else
				return e.toString();
		}
		catch (ClassNotFoundException e){
                   e.printStackTrace();
                   return e.toString();
               }
	}
       
       public void cerrarconexion(){
   		try	{
   			this.cnn.close();
   		} 
   		catch (SQLException e){
   			e.printStackTrace();
   		}
   	}
}

