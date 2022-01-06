//Establecimiento de las funciones CRUD 

package Modelo;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;


public class Consultastabla extends Conexion {
    
    public boolean registrar(Comandante com){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO comandante(cod_comandante, nombre, apellidos, anio_servicio, escuela, fecha_ingreso) VALUES (?,?,?,?,?,?)";
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, com.getCod_comandante());
            ps.setString(2, com.getNombre());
            ps.setString(3, com.getApellidos());
            ps.setInt(4, com.getAnio_servicio());
            ps.setString(5, com.getEscuela());
            String Fecha_ingreso=null;
            java.util.Date fecha = com.getFecha_ingreso();
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            Fecha_ingreso = f.format(fecha);
            ps.setString(6, Fecha_ingreso);
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }       
    }
    public boolean modificar(Comandante com){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE comandante SET cod_comandante=?, nombre=?, apellidos=?, anio_servicio=?, escuela=?, fecha_ingreso=?"
                + "WHERE cod_comandante=?";
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, com.getCod_comandante());
            ps.setString(2, com.getNombre());
            ps.setString(3, com.getApellidos());
            ps.setInt(4, com.getAnio_servicio());
            ps.setString(5, com.getEscuela());
            String Fecha_ingreso=null;
            java.util.Date fecha = com.getFecha_ingreso();
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            Fecha_ingreso = f.format(fecha);
            ps.setString(6, Fecha_ingreso);
            ps.setInt(7, com.getCod_comandante());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }       
    }
    public boolean eliminar(Comandante com){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM comandante WHERE cod_comandante=?";
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, com.getCod_comandante());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }       
    }
    public boolean buscar(Comandante com){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM comandante WHERE cod_comandante=?";
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, com.getCod_comandante());
            rs = (ResultSet) ps.executeQuery();           
            
            if(rs.next()){
                com.setCod_comandante(Integer.parseInt(rs.getString("cod_comandante")));
                com.setNombre(rs.getString("nombre"));
                com.setApellidos(rs.getString("apellidos"));
                com.setAnio_servicio(Integer.parseInt(rs.getString("anio_servicio")));
                com.setEscuela(rs.getString("escuela"));
                com.setFecha_ingreso(rs.getDate("fecha_ingreso"));//OJO !!!
                return true;                
            }
            return false;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }       
    }
}
