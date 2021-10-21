
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.dominio.cliente.Cliente;


public class ClienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    
    public void guardaCliente(Cliente cliente) throws Exception{
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public void modificarCliente(Cliente cliente) throws Exception{
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }
    
    public void eliminarClienteId(String id) throws Exception{
        Cliente cliente = buscarClientePorId(id);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
    
    public void eliminarClienteApellido(String apellido) throws Exception{
        Cliente cliente = buscarClientePorApellido(apellido);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscarClientePorId(String id) throws Exception{
        Cliente cliente = em.find(Cliente.class, id);//Envio la llave primaria
        return cliente;
    }
    
    //CONSULTA CON PARAMETROS
    public Cliente buscarClientePorApellido(String apellido) throws Exception{
        Cliente cliente = (Cliente) em.createQuery("Selecet "
                + "from Cliente d"
                + "where d.apellido like :apellido").setParameter("apellido", apellido).
                getSingleResult();
        return cliente;
    }
    //CONSULTA SIN PARAMETROS
    
    public List<Cliente> listarClientes()throws Exception {
        List<Cliente> clientes = em.createQuery("select d from Cliente d").getResultList();
        return clientes;
    }
    
    public void eliminarCliente(Cliente cliente) throws Exception{
        
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
    
   
}
