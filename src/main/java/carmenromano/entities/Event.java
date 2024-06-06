package carmenromano.entities;

import carmenromano.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Event {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "numero_max_partecipanti")
    private Integer numeroMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(
            mappedBy = "event"
    )
    private List<Partecipazioni> partecipazioniList;

    public Event() {}

    public Event(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, Integer numeroMaxPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.eventType = eventType;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
        this.location = location;
    }

    // Getter e Setter
    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Integer getNumeroMaxPartecipanti() {
        return numeroMaxPartecipanti;
    }

    public void setNumeroMaxPartecipanti(Integer numeroMaxPartecipanti) {
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }




    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", eventType=" + eventType +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                ", location=" + location +
                '}';
    }
}
