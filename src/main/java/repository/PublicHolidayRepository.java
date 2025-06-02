package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.PublicHolidayEntity;

@ApplicationScoped
public class PublicHolidayRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void saveIfNotExists(PublicHolidayEntity holiday) {
        // Provera duplikata po godini i zemlji
        Long count = entityManager.createQuery(
            "SELECT COUNT(h) FROM PublicHolidayEntity h WHERE h.year = :year AND h.countryCode = :countryCode", 
            Long.class)
            .setParameter("year", holiday.getYear())
            .setParameter("countryCode", holiday.getCountryCode())
            .getSingleResult();

        if (count == 0) {
            entityManager.persist(holiday);
        }
    }
}
