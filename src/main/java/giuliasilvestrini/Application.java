package giuliasilvestrini;

import giuliasilvestrini.entities.ElementoBiblio;
import giuliasilvestrini.entities.Libro;
import giuliasilvestrini.entities.Periodicità;
import giuliasilvestrini.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiviobiblio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UUID uuid = UUID.randomUUID();
        Random random = new Random();


        Libro libro = new Libro(uuid, "Titolo 1", LocalDate.now(), random.nextInt(), "Autore 1", "Genere 1");
        Rivista rivista = new Rivista(uuid, "Rivista 1", LocalDate.of(2000, 3, 3), random.nextInt(), Periodicità.SEMESTRALE);


        System.out.println("Hello");
        em.close();
        emf.close();
    }

}