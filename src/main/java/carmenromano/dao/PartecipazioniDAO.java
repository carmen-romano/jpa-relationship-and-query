package carmenromano.dao;

import carmenromano.entities.Location;
import carmenromano.entities.Partecipazioni;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

import java.util.UUID;

public class PartecipazioniDAO {

    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazioni partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(partecipazione);
            transaction.commit();
            System.out.println("La partecipazione " + partecipazione.getId() + " è stata correttamente salvata nel database");
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio della partecipazione: " + e.getMessage());
        }
    }
    public Partecipazioni findById(String id) {
        Partecipazioni partecipazioni = entityManager.find(Partecipazioni.class, UUID.fromString(id));
        return partecipazioni;
    }

    public void delete(String partecipazioneId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Partecipazioni partecipazioneFound = findById(partecipazioneId);
            if (partecipazioneFound != null) {
                transaction.begin();
                entityManager.remove(partecipazioneFound);
                transaction.commit();
                System.out.println("La partecipazione" + partecipazioneFound.getId() + " è stata eliminata con successo");
            } else {
                System.err.println("Partecipazione con ID " + partecipazioneId + " non trovata");
            }
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante l'eliminazione della partecipazione: " + e.getMessage());
        }
    }
}
