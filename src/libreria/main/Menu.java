package libreria.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import libreria.dominio.cliente.Cliente;
import libreria.dominio.libro.LibroServicio;
import libreria.dominio.cliente.ClienteServicio;
import libreria.dominio.libro.Libro;
import libreria.dominio.prestamo.PrestamosServicio;
import libreria.persistencia.LibroDAO;

/*
Al alumno le toca desarrollar, las siguientes funcionalidades:
            -DONE-
1. Creación de un Cliente nuevo
2. Crear entidad Préstamo
         -INCOMPLETE-

3. Registrar el préstamo de un libro.
4. Devolución de un libro
5. Búsqueda de todos los prestamos de un Cliente.
6. Agregar validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
• No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
No se podrán prestar libros con fecha anterior a la fecha actual, etc.
 */
public class Menu {

    private final Scanner sc;
    private final ClienteServicio clienteS;
    private final LibroServicio libroS;
    private final PrestamosServicio prestamoS;
    private final LibroDAO libroD;

    public Menu() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.clienteS = new ClienteServicio();
        this.libroS = new LibroServicio();
        this.prestamoS = new PrestamosServicio();
        this.libroD = new LibroDAO();
    }

    public void acivarMenu() throws Exception {

        String respuesta;

        do {
            System.out.println("Seleccione la opción:");
            System.out.println("=====================================");

            System.out.println(" 1- Crear cliente");//OK
            System.out.println(" 2- Eliminar cliente");//OK
            System.out.println(" 3- Mostrar clientes");//OK
            System.out.println(" 4- Cargar nuevo libro");//OK
            System.out.println(" 5- Eliminar libro");//OK
            System.out.println(" 6- Mostrar libros");//OK
            System.out.println(" 7- Resgistrar un prestamo");//OK
            System.out.println(" 8- Registrar devolucion");//OK
            System.out.println(" 9- Buscar prestamos por cliente");//OK
            System.out.println(" 10- Mostrar libros");
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                /*
                dni,nombre,apellido,telefono
                 */
                case 1:
                    clienteS.crearCliente(cargarDni(), cargarNombre(), cargarApellido(), cargarTelefono());
                    break;
                case 2:
                    System.out.print("Ingrese id de cliente a eliminar: ");
                    String idUsuario= sc.next();
                    clienteS.eliminarClientePorId(idUsuario);
                    break;
                case 3:
                    System.out.println(clienteS.mostrarClientes());
                    break;
                case 4:
                    libroS.crearLibro(cargarLibro());
                    break;
                case 5:
                    System.out.println("Ingrese isbn del libro a eliminar");
                    String isbn = sc.next();
                    libroS.eliminarLibroPorISBN(isbn);
                    break;
                case 6:
                    libroS.mostrarLibros();
                    break;
//                case 7:
//                    usuarioService.imprimirUnUsuario(buscarPorCorreo());
//                    break;
//                case 8:
//                    usuarioService.eliminarUsuario(buscarPorCorreo()); // Tener en cuenta que si elimino usuario, elimino sus mascotas asociadas 
//                    break;
//                case 9:
//                    mascotaService.modificarApodoMascota(cargarIdMascot(), cargarApodo());
//                    break;               
//                case 0:
//                    System.exit(0);
//                    break;
            }
            System.out.println("Desea hacer otra consulta? ('si/no'): ");
            respuesta = sc.next();
        } while ("si".equals(respuesta));
    }

    public String cargarDni() {
        System.out.print("Ingrese dni: ");
        String dni = sc.next();
        return dni;
    }

    public String cargarNombre() {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.next();
        return nombre;
    }

    public String cargarApellido() {
        System.out.print("Ingrese apellido: ");
        String apellido = sc.next();
        return apellido;
    }

    public String cargarTelefono() {
        System.out.print("Ingrese telefono: ");
        String telefono = sc.next();
        return telefono;
    }

    public Date cargarFechaPrestamo() {
        System.out.print("Ingrese fecha de prestamo (dd/mm/aaaa): ");
        String fecha = sc.next();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        String date = fecha;
        try {
            realDate = df.parse(date);
        } catch (ParseException e) {
            System.out.println("Formato invalido");
        }
        return realDate;
    }

    public Date cargarFechaDevolucion() {
        System.out.print("Ingrese fecha de devolucion (dd/mm/aaaa): ");
        String fecha = sc.next();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        String date = fecha;
        try {
            realDate = df.parse(date);
        } catch (ParseException e) {
            System.out.println("Formato invalido");
        }
        return realDate;
    }
    
    public Libro cargarLibro() {

        Libro l = new Libro();

        try {
            System.out.print("Ingrese isnb: ");
            long isbn = sc.nextLong();
            l.setIsbn(isbn);
            System.out.print("Ingrese titulo: ");
            String titulo = sc.next();
            l.setTitulo(titulo);
            System.out.print("Ingrese año: ");
            Integer anio = sc.nextInt();
            l.setAnio(anio);
            System.out.print("Ingrese ejemplares: ");
            Integer ej = sc.nextInt();
            l.setAnio(ej);
            System.out.print("Ingrese ejemplares prestados: ");
            Integer ejP = sc.nextInt();
            l.setEjemplaresPrestados(ejP);
            l.setEjemplaresRestantes(ej-ejP);
            System.out.print("Ingrese editorial: ");
            String editorial = sc.next();
            l.setEditorial(editorial);
            libroS.crearLibro(l);
            
        } catch (Exception e) {
            System.out.println("No se cargo el libro");
        }
        return l;
    }
    
  

    

    
    
}
/*
  
        try{
            testDate = df.parse(date);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+testDate);
        } catch (Exception e){ System.out.println("invalid format");}
 */
