/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.dominio.cliente.Cliente;
import libreria.dominio.prestamo.Prestamo;
import libreria.persistencia.ClienteDAO;

public class PrestamoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    private final ClienteDAO daoCliente;

    public PrestamoDAO() {
        this.daoCliente = new ClienteDAO();
    }

    public void guardarPrestamo(Prestamo p) throws Exception {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
  
  
    
}
