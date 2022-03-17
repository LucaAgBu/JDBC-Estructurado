package tienda.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencias.FabricanteDao;
import tienda.persistencias.ProductoDao;


public class ProductoService {
    
    private ProductoDao dao;
    private FabricanteDao dao2;
    
    public ProductoService(){
        this.dao= new ProductoDao();
        this.dao2= new FabricanteDao();
    }
    
    public void listarNombres() throws Exception{
        
        try {
            
            for (int i = 0; i < dao.listarProductos().size(); i++) {
                  System.out.println("producto: "+dao.listarProductos().get(i).getNombre());
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
     public void listarNombresyPrecio() throws Exception{
        
        try {
            
            for (int i = 0; i < dao.listarProductos().size(); i++) {
                  System.out.println("producto: "+dao.listarProductos().get(i).getNombre()
                  +"precio"+dao.listarProductos().get(i).getPrecio());
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
     
    public void listarPrecio() throws Exception{
        
        try {
            
            for (int i = 0; i < dao.listarProductos().size(); i++) {
                
                if(dao.listarProductos().get(i).getPrecio()<120 && dao.listarProductos().get(i).getPrecio()>202){
                    System.out.println(dao.listarProductos().get(i));
                }
                
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void portatiles() throws Exception{
        
        try {
            
            for (int i = 0; i < dao.listarProductos().size(); i++) {

                if(dao.listarProductos().get(i).getNombre().contains("Portátil")){
                       System.out.println(dao.listarProductos().get(i));
                }
                
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void masBarato() throws Exception{
        
        dao.listarProductos();
        ArrayList<Producto> lista = dao.listarProductos();
        
        Collections.sort(lista, new Comparator<Producto>(){
            @Override
            public int compare (Producto p1, Producto p2){
                return new Integer ((int) p1.getPrecio()).compareTo((int) p2.getPrecio());
            }
        });
        try {
           
            System.out.println(lista.get(1));
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void crearProducto(String nombre, double precio, int cod_fab) throws Exception{
        
        try {
        
             Producto producto = new Producto(0,nombre,precio,cod_fab);
        
             dao.insertarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void actualizarProducto(int codigo, String nombre, double precio, int cod_fab) throws Exception{
        
        try {
        
             Producto producto = new Producto(0,nombre,precio,cod_fab);
        
             dao.modificarProducto(producto, codigo);
        
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
    
}



