package libreria.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.dominio.libro.Libro;

public class LibroDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLibro(Libro l) throws Exception {
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }

    public void eliminarLibroPorISBN(String isbn) throws Exception {
        em.getTransaction().begin();
        Libro l = buscarLibroPorISBN(isbn);
        em.remove(l);
        em.getTransaction().commit();
    }

    public Libro buscarLibroPorISBN(String isbn) throws Exception {
        Libro l = em.find(Libro.class, isbn);
        return l;
    }

    public Collection<Libro> listaLibros() throws Exception {
        Collection<Libro> libros = new ArrayList();
        libros = em.createQuery("Select * from LIBRO").getResultList();
        return libros;
    }
    
    
}
