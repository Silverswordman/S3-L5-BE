

package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private long id;



    @OneToOne(mappedBy = "prestito")
    private ElementoBiblio elementobiblio;

    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate datainizioprestito;

    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate datarestprevista;

    @Column(name = "data_restituzione_effettiva", nullable = false)
    private LocalDate dateresteffettiva;

    // getter e setter


    public ElementoBiblio getElementobiblio() {
        return elementobiblio;
    }

    public LocalDate getDatainizioprestito() {
        return datainizioprestito;
    }

    public void setDatainizioprestito(LocalDate datainizioprestito) {
        this.datainizioprestito = datainizioprestito;
    }

    public LocalDate getDatarestprevista() {
        return datarestprevista;
    }

    public void setDatarestprevista(LocalDate datarestprevista) {
        this.datarestprevista = datarestprevista;
    }

    public LocalDate getDateresteffettiva() {
        return dateresteffettiva;
    }

    public void setDateresteffettiva(LocalDate dateresteffettiva) {
        this.dateresteffettiva = dateresteffettiva;
    }
}

