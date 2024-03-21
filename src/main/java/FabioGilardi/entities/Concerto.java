package FabioGilardi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Event {
    //    ATTRIBUTES
    @Enumerated(EnumType.STRING)
    private ConcertType genere;
    private boolean inStreaming;

    //    CONSTRUCTORS
    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, ConcertType genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto() {

    }

    //    GETTERS AND SETTERS
    public ConcertType getConcertType() {
        return genere;
    }

    public void setConcertType(ConcertType genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
