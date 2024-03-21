package FabioGilardi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;

@Entity
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.golSquadraDiCasa > p.golSquadraOspite")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.golSquadraOspite > p.golSquadraDiCasa")
public class PartitaDiCalcio extends Event {
    //    ATTRIBUTES
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golSquadraDiCasa;
    private int golSquadraOspite;

    //    CONSTRUCTORS
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraDiCasa = golSquadraDiCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public PartitaDiCalcio() {
    }

    //    GETTERS AND SETTERS
    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraDiCasa() {
        return golSquadraDiCasa;
    }

    public void setGolSquadraDiCasa(int golSquadraDiCasa) {
        this.golSquadraDiCasa = golSquadraDiCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraDiCasa=" + golSquadraDiCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                '}';
    }
}
