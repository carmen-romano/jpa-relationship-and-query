package carmenromano.entities;

import carmenromano.enums.GenderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona") //nome tabella
public class Persona {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "data_di_nascita")
    private LocalDate data_di_nascita;

    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(
            mappedBy = "persona"
    )
    private List<Partecipazioni> partecipazioniList;

public Persona (){}

    public Persona(GenderType genderType, LocalDate data_di_nascita, String email, String cognome, String nome) {
        this.genderType = genderType;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.cognome = cognome;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public List<Partecipazioni> getPartecipazioniList() {
        return partecipazioniList;
    }

    public void setPartecipazioniList(List<Partecipazioni> partecipazioniList) {
        this.partecipazioniList = partecipazioniList;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", genderType=" + genderType +
                ", partecipazioniList=" + partecipazioniList +
                '}';
    }
}
