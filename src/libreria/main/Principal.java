package libreria.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.dominio.cliente.ClienteServicio;

public class Principal {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emf.createEntityManager();

        Menu menu = new Menu();
        
        menu.acivarMenu();
        
    }

}
