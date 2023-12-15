package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "archivio_bibliotecario")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class ElementoBiblio {
    @Id
    @GeneratedValue
    @Column(name = "isbn", unique = true, nullable = false)
    private UUID isbn;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "pagine")
    private int pagine;




    public ElementoBiblio(UUID isbn, String titolo, LocalDate annoPubblicazione, int pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.pagine = pagine;
    }

    // Getter e setter
    public UUID getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }


}