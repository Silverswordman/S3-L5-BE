package giuliasilvestrini.entities;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;

@Entity

public class Libro extends ElementoBiblio {
    private String autore;
    private String genere;

    public Libro(UUID isbn, String titolo, LocalDate annoPubblicazione, int pagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}