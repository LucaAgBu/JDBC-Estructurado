package tienda.persistencias;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public final class FabricanteDao extends Dao{
    
    public void insertarFabricante (Fabricante fabricante) throws Exception{
        
        try {
            if (fabricante == null) {
                throw new Exception("No hay ningun fabricante cargado");
            }
            
            String sql = "INSERT INTO fabricante(codigo,nombre)"
                    + "VALUES ("+fabricante.getNombre()+");";
            
            InsertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        
        try {
            if(fabricante == null){
                throw new Exception("No hay ningun producto cargado");
            }
            
            String sql = "UPDATE fabricante SET nombre ="+fabricante.getNombre()
                    +"WHERE codigo ="+fabricante.getCodigo()+";";
            
            InsertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminarFabricante(int codigo) throws Exception{
        try {
            /*if(producto == null){
                throw new Exception("No hay ningun producto cargado");
            }*/
            
            String sql = "DELETE FROM fabricante WHERE"+codigo+";";
            
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Fabricante> listarFabricantes() throws Exception{
        
        try {
            
            String sql = "SELECT * FROM fabricante;";
            
            consultarBD(sql);
            
            Fabricante fabricante = null;
            ArrayList<Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {                
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
                fabricantes.add(fabricante);
            }
            desconectarBD();
            return fabricantes;
            
        } catch (Exception e) {
            desconectarBD();
            throw e;
        }
        
    }
    
    public Fabricante buscarProducto(int codigo) throws Exception{
        
        try {
            
            String sql = "SELECT * FROM fabricante WHERE codigo="+codigo+";";
            
            consultarBD(sql);
            
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {                
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
            }
            desconectarBD();
            return fabricante;
            
        } catch (Exception e) {
            desconectarBD();
            throw e;
        }
        
    }
    
}
