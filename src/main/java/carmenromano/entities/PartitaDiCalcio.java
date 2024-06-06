package carmenromano.entities;

import carmenromano.entities.Event;
import carmenromano.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@NamedQueries({@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = :squadraVincente"),
        @NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente != :squadraVincente")
})
public class PartitaDiCalcio extends Event {
    @Id
    @GeneratedValue
    protected UUID id;

    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;  // Null se pareggio
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(){}


    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, Integer numeroMaxPartecipanti, Location location, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite, String squadraVincente, String squadraOspite, String squadraDiCasa) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti, location);
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
        this.squadraVincente = squadraVincente;
        this.squadraOspite = squadraOspite;
        this.squadraDiCasa = squadraDiCasa;
    }

    // Getter e Setter

    @Override
    public UUID getId() {
        return id;
    }


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

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

}

