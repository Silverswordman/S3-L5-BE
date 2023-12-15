package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {

    @Id
    @GeneratedValue
    private long numeroTessera;
    private String nome;
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    // Relazione one-to-many con la classe Prestito
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prestito> prestiti;

    public Utente(long numeroTessera, List<Prestito> prestiti) {
        this.numeroTessera = numeroTessera;
        this.prestiti = prestiti;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }


    public long getNumeroTessera() {
        return numeroTessera;
    }
}

