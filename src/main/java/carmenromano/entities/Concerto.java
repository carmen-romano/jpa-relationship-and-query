package carmenromano.entities;

import carmenromano.enums.EventType;
import carmenromano.enums.GenereType;
import carmenromano.enums.StateType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Concerto extends Event{
    @Id
    @GeneratedValue
    private UUID id;;
    private boolean inStreaming;

    @Column(name = "Genere")
    @Enumerated(EnumType.STRING)
    private GenereType genereType;

    public Concerto(){}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, Integer numeroMaxPartecipanti,
                    Location location, GenereType genereType, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti, location);
        this.genereType = genereType;
        this.inStreaming = inStreaming;
    }

    public GenereType getGenereType() {
        return genereType;
    }

    public void setGenereType(GenereType genereType) {
        this.genereType = genereType;
    }

    @Override
    public UUID getId() {
        return id;
    }


    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
