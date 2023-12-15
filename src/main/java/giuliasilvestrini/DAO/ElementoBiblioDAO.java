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
        em.merge(elementoBiblio);
        transaction.commit();
        System.out.println("Nuovo elemento Libro/Rivista " + elementoBiblio.getTitolo() + " inserito nel catalogo");
    }

    public ElementoBiblio findById(UUID isbn) {

        return (ElementoBiblio) this.em.find(ElementoBiblio.class, isbn);

    }

    public void findByIsbnAndDelete(UUID isbn) {
        try {
            EntityTransaction t = this.em.getTransaction();
            ElementoBiblio found = (ElementoBiblio) this.em.find(ElementoBiblio.class, isbn);
            if (found != null) {
                t.begin();
                this.em.remove(found);
                t.commit();
                System.out.println("Elemento Biblio eliminato");
            } else {
                System.out.println("Elemento Biblio non trovato");
            }
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

    }

}
