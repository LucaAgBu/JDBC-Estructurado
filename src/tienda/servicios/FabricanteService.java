package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencias.FabricanteDao;

public class FabricanteService {
    
    private FabricanteDao dao;
    
    public FabricanteService(){
        this.dao= new FabricanteDao();
    }
    
    public void insertarFabricante(String nombre){
        
        try {
            Fabricante fabricante = new Fabricante(0, nombre);
            
            dao.insertarFabricante(fabricante);
        } catch (Exception e) {
        }
        
    }
    
    public void listarFabricante() throws Exception{
        
        try {
            
            for (int i = 0; i < dao.listarFabricantes().size(); i++) {
                  System.out.println("producto: "+dao.listarFabricantes().get(i));
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
