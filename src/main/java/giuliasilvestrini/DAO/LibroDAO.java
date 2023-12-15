package giuliasilvestrini.DAO;

import giuliasilvestrini.entities.ElementoBiblio;
import giuliasilvestrini.entities.Libro;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;


public class LibroDAO {

    private final EntityManager em;//

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBiblio elementoBiblio) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementoBiblio);
        transaction.commit();
        System.out.println("Nuovo elemento Libro  " + Libro.getIsbn() + " " + Libro.getTitolo() + " inserito nel catalogo");
    }

    public Libro findbyIsbn(UUID isbn) {
        return em.find(Libro.class, isbn);
    }

}

