package giuliasilvestrini.DAO;

import giuliasilvestrini.entities.ElementoBiblio;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;


public class ElementoBiblioDAO {

    private final EntityManager em;//

    public ElementoBiblioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBiblio elementoBiblio) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementoBiblio);
        transaction.commit();
        System.out.println("Nuovo elemento Libro/Rivista  " + elementoBiblio.getIsbn() + " " + elementoBiblio.getTitolo() + " inserito nel catalogo");
    }

    public ElementoBiblio findbyIsbn(UUID isbn) {
        return em.find(ElementoBiblio.class, isbn);
    }

}

