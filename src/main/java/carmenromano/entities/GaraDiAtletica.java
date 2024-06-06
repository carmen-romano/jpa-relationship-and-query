package carmenromano.entities;

import carmenromano.entities.Event;
import carmenromano.entities.Persona;
import carmenromano.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
public class GaraDiAtletica extends Event {
    @Id
    @GeneratedValue
    private UUID id;


    @OneToMany
    @JoinColumn(name = "gara_id")
    private Set<Persona> atleti;

    @OneToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(){}


    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, Integer numeroMaxPartecipanti, Location location, Persona vincitore, Set<Persona> atleti) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti, location);
        this.vincitore = vincitore;
        this.atleti = atleti;
    }
    // Getter e Setter

    @Override
    public UUID getId() {
        return id;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
