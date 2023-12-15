package giuliasilvestrini;

import com.github.javafaker.Faker;
import giuliasilvestrini.DAO.ElementoBiblioDAO;
import giuliasilvestrini.entities.Libro;
import giuliasilvestrini.entities.Periodicità;
import giuliasilvestrini.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
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


        Libro libro = new Libro(uuid, faker.book().title(), LocalDate.now(), random.nextInt(1, 400), faker.book().author(), faker.book().genre());
        Rivista rivista = new Rivista(uuid, faker.book().title(), LocalDate.of(2000, random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), Periodicità.SEMESTRALE);
        Rivista rivista1 = new Rivista(uuid, faker.book().title(), LocalDate.of(2000, random.nextInt(1, 12), random.nextInt(1, 29)), random.nextInt(1, 400), Periodicità.MENSILE);
        Libro libro1 = new Libro(uuid, faker.book().title(), LocalDate.now(), random.nextInt(1, 400), faker.book().author(), faker.book().genre());

//        elemento.save(libro);
//        elemento.save(rivista);
//        elemento.save(libro1);
//        elemento.save(rivista1);

        System.out.println("Hello");

        em.close();
        emf.close();
    }
}
