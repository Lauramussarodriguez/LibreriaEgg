package libreria.dominio.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import libreria.persistencia.ClienteDAO;

public class ClienteServicio {

    private final ClienteDAO dao;

    public ClienteServicio() {
        this.dao = new ClienteDAO();
    }

    public Cliente crearCliente(String dni, String nombre, String apellido, String telefono) throws Exception {
        try {
            if (dni == null || dni.trim().isEmpty()) {
                throw new Exception("Debe indicar dni para el cliente");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar nombre para el cliente");
            }

            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe indicar apellido para el cliente");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new Exception("Debe indicar telefono para el cliente");
            }

            Cliente cliente = new Cliente();
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTelefono(telefono);
            cliente.setId(UUID.randomUUID().toString());//CADENA DE CARACTERES
            dao.guardaCliente(cliente);
            return cliente;
        } catch (Exception e) {
            System.out.println("No se creeo el usuario" + e.getMessage());
        }
        return null;
    }

    public void elminarCliente(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("Debe ingresar el id del cliente");
        }

    }

    public Cliente buscarClientePorId(String id) throws Exception {

        Cliente cliente = new Cliente();
        try {
            if (id == null) {
                throw new Exception("Debe indicar id del cliente");
            }
            cliente = dao.buscarClientePorId(id);
            if (cliente == null) {
                throw new Exception("No se encontro cliente con id ingresado");
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente;

    }

    public void eliminarClientePorId(String id) throws Exception {

        Cliente cliente = new Cliente();
        try {
            if(id==null || id.trim().isEmpty()){
                throw new Exception("Debe indicar id del cliente");
            }
            cliente = dao.buscarClientePorId(id);
            dao.eliminarCliente(cliente);
            if(cliente == null){
                throw new Exception("No se encontro cliente para el id indicado");
            }
        } catch (Exception e) {
            throw e;
        }

    }
    
    
    public Collection<Cliente> mostrarClientes() throws Exception{
            Collection<Cliente> clientes = new ArrayList();
        
        try {
            clientes = dao.listarClientes();
            if(clientes == null){
                throw new Exception("No hay clientes para mostrar en la lista");
            }
            return clientes;
        } catch (Exception e) {
            throw e;
        }
        
    }

}
