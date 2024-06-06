package carmenromano;

import carmenromano.dao.EventDao;
import carmenromano.dao.LocationDAO;
import carmenromano.dao.PartecipazioniDAO;
import carmenromano.dao.PersonaDAO;
import carmenromano.entities.*;
import carmenromano.enums.EventType;
import carmenromano.enums.GenderType;
import carmenromano.enums.GenereType;
import carmenromano.enums.StateType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Location location = new Location("villa", "napoli");
   ///locationDAO.save(location);
      Location locationDB = locationDAO.findById("708c0362-5e4c-4eec-92dd-44bfa0d01f98");


        //EVENTO
    //   Event evento = new Event("festa",LocalDate.of(2024, 5, 1),
    //          "party a tema",EventType.PRIVATO,50,locationDB);
          // eventDAO.save(evento);

        //PERSONA
        Persona persona = new Persona(GenderType.M,LocalDate.of(1799, 2, 22),
             "prova@prova.it","P","Marco");
  ///personaDAO.save(persona);


        //PARTECIPAZIONE//
        Persona personaDB = personaDAO.findById("96c4ba73-1ac3-4edc-83cf-f35066a8a367");
        Persona personaDB1 = personaDAO.findById("9fc2b6db-622e-42d7-acc2-37166587cfd7");
      //  Event eventDB = eventDAO.findById("d19e1623-253a-4f3f-9954-8636ded6d0cb");
      //  Partecipazioni partecipazioni = new Partecipazioni(StateType.CONFERMATO,personaDB,eventDB);
         // partecipazioniDAO.save(partecipazioni);
        System.out.println("hello");

        //////////////////////////////////////********************************////////////////////////////////////////////////
        EventDao eventDAO1 = new EventDao(em);
        Set<Persona> personeGara = new HashSet<>();

// Aggiungere personaDB e personaDB1 alla lista
       /// personeGara.add(personaDB);
     ///   personeGara.add(personaDB1);

        Concerto gara1 = new Concerto("Concerto di Paolo Villaggio",LocalDate.of(2024, 5, 1),"da non perdere",
                EventType.PUBBLICO,100000,locationDB,GenereType.ROCK,true);
        Concerto gara3 = new Concerto("Pippo Franco ",LocalDate.of(2024, 5, 1),"bellissimo",
               EventType.PUBBLICO,1,locationDB, GenereType.ROCK,true);
//eventDAO1.save(gara1);

  eventDAO1.getConcertiInStreaming(true).forEach(System.out::println);
        System.out.println("ciao");
  eventDAO1.getConcertiPerGenere(GenereType.ROCK).forEach(System.out::println);

  PartitaDiCalcio partita2 = new PartitaDiCalcio("seria A", LocalDate.of(2023,02,04),
          "ss",EventType.PRIVATO,55555,locationDB,2,
          0,"squadra1","squadra2","squadra1");
///eventDAO1.save(partita2);
        
        eventDAO1.getPartiteVinteInCasa("squadra1").forEach(System.out::println);




    }
}
