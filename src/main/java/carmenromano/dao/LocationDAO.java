package carmenromano.dao;

import carmenromano.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

import java.util.UUID;

public class LocationDAO {

    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(location);
            transaction.commit();
            System.out.println("La location " + location.getTitolo() + " è stata correttamente salvata nel database");
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio della location: " + e.getMessage());
        }
    }

    public Location findById(String id) {
        Location category = entityManager.find(Location.class, UUID.fromString(id));
        return category;
    }

    public void delete(String locationId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Location locationFound = findById(locationId);
            if (locationFound != null) {
                transaction.begin();
                entityManager.remove(locationFound);
                transaction.commit();
                System.out.println("La location " + locationFound.getTitolo() + " è stata eliminata con successo");
            } else {
                System.err.println("Location con ID " + locationId + " non trovata");
            }
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante l'eliminazione della location: " + e.getMessage());
        }
    }
}

