package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "numero_tessera_utente", nullable = false)
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "isbn", nullable = false)
    private ElementoBiblio elementoBiblio;

    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate datainizioprestito;

    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate datarestprevista;

    @Column(name = "data_restituzione_effettiva", nullable = false)
    private LocalDate dateresteffettiva;

    public Prestito(Utente utente, ElementoBiblio elementoBiblio, LocalDate datainizioprestito, LocalDate datarestprevista, LocalDate dateresteffettiva) {
        this.utente = utente;
        this.elementoBiblio = elementoBiblio;
        this.datainizioprestito = datainizioprestito;
        this.datarestprevista = datarestprevista;
        this.dateresteffettiva = dateresteffettiva;
    }


    // getter e setter
    public long getUtente() {
        return utente.getNumeroTessera();
    }


    public ElementoBiblio getElementobiblio() {
        return elementoBiblio;
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

