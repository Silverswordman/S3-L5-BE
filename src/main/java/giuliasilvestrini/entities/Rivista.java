package giuliasilvestrini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Rivista extends ElementoBiblio {


    @Enumerated(EnumType.STRING)
    @Column(name = "periodicità", nullable = true)
    private Periodicità periodicità;


    public Rivista(UUID isbn, String titolo, LocalDate annoPubblicazione, int pagine, Periodicità periodicità) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }


    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
