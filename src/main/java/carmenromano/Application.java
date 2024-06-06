package carmenromano;

import carmenromano.dao.EventDao;
import carmenromano.dao.LocationDAO;
import carmenromano.dao.PartecipazioniDAO;
import carmenromano.dao.PersonaDAO;
import carmenromano.entities.Event;
import carmenromano.entities.Location;
import carmenromano.entities.Partecipazioni;
import carmenromano.entities.Persona;
import carmenromano.enums.EventType;
import carmenromano.enums.GenderType;
import carmenromano.enums.StateType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entity_final = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        LocationDAO locationDAO = new LocationDAO(em);
        EventDao eventDAO = new EventDao(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioniDAO partecipazioniDAO = new PartecipazioniDAO(em);

        ///LOCATION
        Location location = new Location("villa", "Milano");
        //  locationDAO.save(location);
         Location locationDB = locationDAO.findById("577228a5-09eb-4346-af70-e9e905baaab5");


        //EVENTO
        Event evento = new Event("festa",LocalDate.of(2024, 5, 1),
                "party a tema",EventType.PRIVATO,50,locationDB);
          // eventDAO.save(evento);

        //PERSONA
         Persona persona = new Persona(GenderType.F,LocalDate.of(1996, 6, 22),"prova@prova.it","Romano","Carmen");
         // personaDAO.save(persona);


        //PARTECIPAZIONE
        Persona personaDB = personaDAO.findById("e39baf46-ef0f-4441-852a-59592ce468ce");
        Event eventDB = eventDAO.findById("d19e1623-253a-4f3f-9954-8636ded6d0cb");
        Partecipazioni partecipazioni = new Partecipazioni(StateType.CONFERMATO,personaDB,eventDB);
         // partecipazioniDAO.save(partecipazioni);



    }
}
