//Establecimiento de la conexion con la base de datos 

package Modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
   
    String usuario = "root";
    //Pones la clave de tu base de datos
    String clave = "Alejandro123!";
    //reto5bd fue como llamé la base de datos con la tabla comandante
    String url = "jdbc:mysql://localhost:3306/reto5bd";
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url,this.usuario,this.clave);
            
        } catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public Connection getCon() {
        return con;
    }
    
    
    
    
    
    
    
}
