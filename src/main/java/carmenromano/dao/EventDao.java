package carmenromano.dao;

import carmenromano.entities.Concerto;
import carmenromano.entities.Event;
import carmenromano.entities.Partecipazioni;
import carmenromano.entities.PartitaDiCalcio;
import carmenromano.enums.GenereType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventDao {
    private final EntityManager entityManager;

    public EventDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(String squadra) {
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery(
                "PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        query.setParameter("squadraVincente", squadra);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String squadra) {
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery(
                "PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        query.setParameter("squadraVincente", squadra);
        return query.getResultList();
    }
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Event c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
       return  query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereType genereType) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT e FROM Event e WHERE e.genereType = :genereType", Concerto.class);
        query.setParameter("genereType", genereType);
       return  query.getResultList();
    }




    public void save(Event event) {
        EntityTransaction transazione = entityManager.getTransaction();
        try {
            transazione.begin();
            entityManager.persist(event);
            transazione.commit();
            System.out.println("L'elemento " + event.getTitolo() + " è stato correttamente salvato nel database");
        } catch (PersistenceException e) {
            if (transazione.isActive()) {
                transazione.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
        }
    }
    public Event findById(String id) {
        Event event = entityManager.find(Event.class, UUID.fromString(id));
        return event;
    }

    public void delete(String eventId) {
        EntityTransaction transazione = entityManager.getTransaction();
        try {
            Event eventFound = findById(eventId);
            if (eventFound != null) {
                transazione.begin();
                entityManager.remove(eventFound);
                transazione.commit();
                System.out.println("L'evento " + eventFound.getTitolo() + " è stato eliminato con successo");
            } else {
                System.err.println("Evento con ID " + eventId + " non trovato");
            }
        } catch (PersistenceException e) {
            if (transazione.isActive()) {
                transazione.rollback();
            }
            System.err.println("Errore durante l'eliminazione dell'evento: " + e.getMessage());
        }
    }
}

