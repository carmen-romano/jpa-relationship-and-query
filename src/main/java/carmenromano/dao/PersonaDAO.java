package carmenromano.dao;

import carmenromano.entities.Partecipazioni;
import carmenromano.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

import java.util.UUID;

public class PersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(persona);
            transaction.commit();
            System.out.println("La persona " + persona.getNome() + " " + persona.getCognome() + " è stata correttamente salvata nel database");
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio della persona: " + e.getMessage());
        }
    }

    public Persona findById(String id) {
        Persona persona = entityManager.find(Persona.class, UUID.fromString(id));
        return persona;
    }

    public void delete(String personaId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Persona personaFound = findById(personaId);
            if (personaFound != null) {
                transaction.begin();
                entityManager.remove(personaFound);
                transaction.commit();
                System.out.println("La persona " + personaFound.getNome() + " " + personaFound.getCognome() + " è stata eliminata con successo");
            } else {
                System.err.println("Persona con ID " + personaId + " non trovata");
            }
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante l'eliminazione della persona: " + e.getMessage());
        }
    }
}
