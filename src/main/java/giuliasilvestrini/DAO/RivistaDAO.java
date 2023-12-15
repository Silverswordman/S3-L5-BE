package giuliasilvestrini.DAO;

import giuliasilvestrini.entities.ElementoBiblio;
import giuliasilvestrini.entities.Libro;
import giuliasilvestrini.entities.Rivista;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;


public class RivistaDAO {

    private final EntityManager em;//

    public RivistaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBiblio elementoBiblio) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementoBiblio);
        transaction.commit();
        System.out.println("Nuovo elemento Rivista " + Rivista.getIsbn() + " " + Rivista.getTitolo() + " inserito nel catalogo");
    }

    public Libro findbyIsbn(UUID isbn) {
        return em.find(Libro.class, isbn);
    }

}

