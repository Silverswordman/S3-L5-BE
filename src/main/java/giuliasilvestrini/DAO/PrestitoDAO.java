package giuliasilvestrini.DAO;

import giuliasilvestrini.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {



    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito

    ) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println(" " + prestito);

    }
}
