package giuliasilvestrini;

import com.github.javafaker.Faker;
import giuliasilvestrini.DAO.ElementoBiblioDAO;
import giuliasilvestrini.DAO.PrestitoDAO;
import giuliasilvestrini.DAO.UtenteDAO;
import giuliasilvestrini.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiviobiblio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UUID uuid = UUID.randomUUID();
        Random random = new Random();

        Faker faker = new Faker(Locale.ITALY);


        ElementoBiblioDAO elemento = new ElementoBiblioDAO(em);


//add libri e riviste
        Libro libro = new Libro(uuid, faker.book().title(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), faker.book().author(), faker.book().genre());
        Rivista rivista = new Rivista(uuid, faker.book().title(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), Periodicità.SEMESTRALE);
        Rivista rivista1 = new Rivista(uuid, faker.book().title(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), Periodicità.MENSILE);
        Libro libro1 = new Libro(uuid, faker.book().title(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), faker.book().author(), faker.book().genre());
        Libro libro3 = new Libro(uuid, faker.book().title(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), faker.book().author(), faker.book().genre());

//        elemento.save(libro);
//        elemento.save(rivista);
//        elemento.save(libro1);
//        elemento.save(rivista1);
//        elemento.save(libro3);


        // creazione utenti
        UtenteDAO utente = new UtenteDAO(em);

        Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)));
        Utente utente2 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(random.nextInt(1990, 2023), random.nextInt(1, 12), random.nextInt(1, 29)));

        utente.save(utente1);
        utente.save(utente2);

        //creazione prestiti doesn't work

//        PrestitoDAO prestito = new PrestitoDAO(em);
//        Prestito prestito1 = new Prestito(utente1, libro, LocalDate.of(random.nextInt(2000, 2023), random.nextInt(1, 12), random.nextInt(1, 29))), prestito1.???????????????plusDays(30), null);


// elemento find

        System.out.println(elemento.findById(UUID.fromString("08975d63-bfcf-4bc4-9f68-9a495311f03f")));

// delete

        elemento.findByIsbnAndDelete(UUID.fromString("230ed599-52ae-4521-b708-709df5af6a5d"));
        // lascio scommentato così dice che non trova l elemento


        // trova con l anno e stampa con for
        List<ElementoBiblio> librianno = elemento.findByAnnoPubblicazione(2011);
        for (ElementoBiblio elementoBiblio : librianno) {
            System.out.println(elementoBiblio);
        }

        // trova con autore

        List<ElementoBiblio> libriByAutore = elemento.findByAutore("Cosetta Donati");
        for (ElementoBiblio elementoBiblio : libriByAutore) {
            System.out.println(elementoBiblio);
        }
        em.close();
        emf.close();
    }
}
