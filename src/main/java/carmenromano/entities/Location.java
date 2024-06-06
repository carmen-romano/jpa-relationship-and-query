package carmenromano.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "location") //nome tabella
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome") //nome colonna
    private String titolo;

    @Column(name = "citta") //nome colonna
    private String città;

    public Location(){}

    public Location( String titolo, String città) {
        this.titolo = titolo;
        this.città = città;
    }

    public UUID getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
