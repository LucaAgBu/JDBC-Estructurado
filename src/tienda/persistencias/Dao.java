/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencias;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Los ninios
 */
public abstract class Dao {
   
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement stmt = null;
    
    private final String User = "root";
    private final String Password = "root";
    private final String Db = "tienda";
    private final String Driver = "com.mysql.jdbc.Driver";
    
    protected void conectarBD() throws ClassNotFoundException, SQLException{
        
        try {
            
            Class.forName(Driver);
            String url = "jdbc:mysql://localhost:3306/"+Db+"?useSSL=false";
            conexion = DriverManager.getConnection(url,User,Password);
            
        } catch (ClassNotFoundException | SQLException  ex) {
            
            throw ex;
            
        }
        
    }
    
    protected void desconectarBD() throws Exception{
        
        try {
            
            if (resultado != null) {
                resultado.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    protected void InsertarModificarEliminar(String sql) throws Exception{
        
        try {
            
            conectarBD();
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }finally{
            desconectarBD();
        }
        
    }
    
    protected void consultarBD(String sql) throws Exception{
        
        try {
            conectarBD();
            stmt = conexion.createStatement();
            resultado = stmt.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
}
