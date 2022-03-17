/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencias;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

/**
 *
 * @author Los ninios
 */
public final class ProductoDao extends Dao{
    
    public void insertarProducto (Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("No hay ningun producto cargado");
            }
            
            String sql = "INSERT INTO producto(nombre,precio,codigo_fabricante) "
                    + "VALUES ("+producto.getNombre()+","+producto.getPrecio()
                    +","+producto.getCodigo_fabricante()+");";
            
            InsertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarProducto(Producto producto, int codigo) throws Exception{
        
        try {
            if(producto == null){
                throw new Exception("No hay ningun producto cargado");
            }
            
            String sql = "UPDATE producto SET nombre ="+producto.getNombre()+", precio ="+producto.getPrecio()
                    +"WHERE codigo ="+codigo+";";
            
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminarProducto(int codigo) throws Exception{
        try {
            /*if(producto == null){
                throw new Exception("No hay ningun producto cargado");
            }*/
            
            String sql = "DELETE FROM producto WHERE"+codigo+";";
            
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Producto> listarProductos() throws Exception{
        
        try {
            
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM tienda.producto;";
            
            consultarBD(sql);
            
            Producto producto = null;
            ArrayList<Producto> productos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setCodigo((int) resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBD();
            return productos;
            
        } catch (Exception e) {
            desconectarBD();
            throw e;
        }
        
    }
    
    public Producto buscarProducto(int codigo) throws Exception{
        
        try {
            
            String sql = "SELECT * FROM producto WHERE codigo="+codigo+";";
            
            consultarBD(sql);
            
            Producto producto = null;
            
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setCodigo((int) resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
            }
            
            desconectarBD();
            return producto;
            
        } catch (Exception e) {
            desconectarBD();
            throw e;
        }
        
    }
    
}
