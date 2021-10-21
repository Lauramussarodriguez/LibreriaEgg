package libreria.dominio.prestamo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import libreria.dominio.cliente.Cliente;
import libreria.dominio.cliente.ClienteServicio;
import libreria.dominio.libro.Libro;
import libreria.dominio.libro.LibroServicio;
import libreria.persistencia.PrestamoDAO;

/**
 * String id, Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente
 * cliente
 */
public class PrestamosServicio {

    LibroServicio libroS;
    PrestamoDAO prestamoD;
    ClienteServicio clienteS;
    Scanner sc;
    public PrestamosServicio() {
        this.libroS = new LibroServicio();
        this.prestamoD = new PrestamoDAO();
        this.clienteS = new ClienteServicio();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    
    public void registarPrestamo(String id) throws Exception{
        
        try {
            if(id==null || id.trim().isEmpty()){
                throw new Exception("Debe ingresar el id del cliente");
            }
            Libro l= new Libro();
            Prestamo p = new Prestamo();
            p.setId(id);
            p.setFechaPrestamo(cargarFechaPrest());
            p.setFechaDevolucion(cargarFechaDev());
            p.setLibro(l);
            
            prestamoD.guardarPrestamo(p);
        } catch (Exception e) {
            
            System.out.println("No se registro el prestamo " + e.getMessage());
        }
        
    }
    
    public Date cargarFechaPrest() throws Exception{
        System.out.print("Ingrese fecha del prestamo: ");
        String fecha = sc.next();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        try {
            realDate = df.parse(fecha);
        } catch (Exception e) {
            System.out.println("Formato invalido");
        }
        return realDate;
    } 
    
    public Date cargarFechaDev() throws Exception{
        System.out.print("Ingrese fecha de devolucon: ");
        String fecha = sc.next();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        try {
            realDate = df.parse(fecha);
        } catch (Exception e) {
            System.out.println("Formato invalido");
        }
        return realDate;
    } 
    
    

    
    public Cliente cargarCliente(){
        Cliente cliente = new Cliente();
        try{
            System.out.print("Ingrese dni: ");
            String dni = sc.next();
            System.out.print("Ingrese nombre: ");
            String nombre = sc.next();
            System.out.print("Ingrese apellido: ");
            String apellido = sc.next();
            System.out.print("Ingrese telfono: ");
            String telefono = sc.next();
            clienteS.crearCliente(dni, nombre, apellido, telefono);
        }catch(Exception e){
            System.out.println("No se cargo el cliente");
        }
        return cliente;
    }

}
/*

*/