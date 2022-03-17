package principal;

import java.util.Scanner;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;


public class principal {

    public static void main(String[] args) throws Exception {
        
        ProductoService service1 = new ProductoService();
        FabricanteService service2 = new FabricanteService();
        
        
        
        Scanner leer = new Scanner(System.in);
        
        
        
        boolean s = true;
        
        while(s){
            System.out.println("-- Administrador de la Tienda --");
        System.out.println("--- Menu ---");
        
        System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.\n" +
"2) Lista los nombres y los precios de todos los productos de la tabla producto.\n" +
"3) Listar aquellos productos que su precio esté entre 120 y 202.\n" +
"4) Buscar y listar todos los Portátiles de la tabla producto.\n" +
"5) Listar el nombre y el precio del producto más barato.\n" +
"6) Ingresar un producto a la base de datos.\n" +
"7) Ingresar un fabricante a la base de datos\n" +
"8) Editar un producto con datos a elección.");
            int n = leer.nextInt();
            switch (n) {
            case 1:
                service1.listarNombres();
                break;
            case 2:
                service1.listarNombresyPrecio();
                break;
            case 3:
                service1.listarPrecio();
                break;
            case 4:
                service1.portatiles();
                break;
            case 5:
                service1.masBarato();
                break;
            case 6:
                System.out.println("Ingrese el nombre del producto");
                String nombre = leer.next();
                System.out.println("Ingrese el precio del producto");
                int precio = leer.nextInt();
                System.out.println("Ingrese el codigo del fabricante correspondiente");
                service2.listarFabricante();
                int codfab = leer.nextInt();
                service1.crearProducto(nombre, precio, codfab);
                break;
            case 7:
                System.out.println("Ingrese el nombre del fabricante");
                String nombrefab = leer.next();
                service2.insertarFabricante(nombrefab);
                break;
            case 8:
                System.out.println("Ingrese el codigo del producto a modificar");
                int codigo = leer.nextInt();
                System.out.println("Ingrese el nuevo nombre del producto");
                String nuevonombre = leer.next();
                System.out.println("Ingrese el nuevo precio del producto");
                double nuevoprecio = leer.nextInt();
                System.out.println("Ingrese el nueveo codigo fabricante del producto");
                int codfab2 = leer.nextInt();
                service1.actualizarProducto(codigo, nuevonombre, nuevoprecio, codfab2);
                break;
            case 9:
                s=false;
                break;
            default:
                throw new AssertionError();
        }
        
        }
        
        
    }
    
}
