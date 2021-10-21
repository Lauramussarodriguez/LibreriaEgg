package libreria.dominio.libro;

import java.util.Collection;
import java.util.UUID;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    LibroDAO dao;

    public LibroServicio() {
        this.dao = new LibroDAO();
    }

    public Libro crearLibro(Libro l) throws Exception {

        try {
            if (l.getTitulo() == null || l.getTitulo().trim().isEmpty()) {
                throw new Exception("Debe ingresar el titulo del libro");
            }
                    
            Libro libro = new Libro();
            libro.setAnio(l.getAnio());
            libro.setTitulo(l.getTitulo());
            libro.setIsbn(l.getIsbn());
            libro.setEjemplares(l.getEjemplares());
            libro.setEjemplaresPrestados(l.getEjemplaresPrestados());
            libro.setEjemplaresRestantes(l.getEjemplaresRestantes());
            libro.setEditorial(l.getEditorial());
            libro.setId(UUID.randomUUID().toString());
            dao.guardarLibro(libro);
            
            if (l.getEjemplares() < l.getEjemplaresPrestados()) {
                throw new Exception("El numero de ejemplares es incorrecto");
            }
            if (l.getEjemplares() < l.getEjemplaresRestantes()) {
                throw new Exception("El numero de ejemplares es incorrecto");
            }        
                   
            return libro;
        } catch (Exception e) {
           System.out.println("No se creeo el usuario" + e.getMessage());
        }
        return null;
    }

    public Libro buscarLibroPorisbn(String isbn) throws Exception {
        try {
            if (isbn == null || isbn.trim().isEmpty()) {
                throw new Exception("Debe ingresar un isbn");
            }

            Libro l = dao.buscarLibroPorISBN(isbn);
            if (l == null) {
                throw new Exception("No se encontro un libro con el isbn ingresado");

            }
            return l;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarLibroPorISBN(String isbn) throws Exception {
        try {
            if (isbn == null || isbn.trim().isEmpty()) {
                throw new Exception("Debe indicar el isbn del libro");
            }
            dao.eliminarLibroPorISBN(isbn);

        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Libro> mostrarLibros() throws Exception {
        try {
            Collection<Libro> libros = dao.listaLibros();
            if (libros == null || libros.isEmpty()) {
                throw new Exception("No hay libros para mostrar en la lista");
            }
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }
}
