package carmenromano.entities;
import carmenromano.enums.StateType;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "partecipazione") //nome tabella
public class Partecipazioni {

    @Id
    @GeneratedValue
    private UUID id;


        @ManyToOne
        @JoinColumn(name = "persona_id")
        private Persona persona;

        @ManyToOne
        @JoinColumn(name = "event_id")
        private Event event;
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StateType stateType;

public Partecipazioni(){}

    public Partecipazioni(StateType stateType, Persona persona, Event event) {
        this.stateType = stateType;
        this.persona = persona;
        this.event = event;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public UUID getId() {
        return id;
    }



    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", stateType=" + stateType +
                ", persona=" + persona +
                '}';
    }
}
