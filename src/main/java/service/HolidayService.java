package service;

import client.CountryClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.PublicHoliday;
import model.PublicHolidayEntity;
import model.TypeEntity;
import repository.PublicHolidayRepository;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class HolidayService {


    @RestClient
    CountryClient countryClient;

    @Inject
    PublicHolidayRepository repository;

    @Transactional
    public void saveHolidaysForCountry(String countryCode) {
        List<PublicHoliday> apiHolidays = countryClient.getNextPublicHolidays(countryCode);

        for (PublicHoliday apiHoliday : apiHolidays) {
            PublicHolidayEntity entity = new PublicHolidayEntity();
            
            // Mapiranje podataka sa API-ja
            entity.setDate(apiHoliday.getDate());
            entity.setLocalName(apiHoliday.getLocalName());
            entity.setName(apiHoliday.getName());
            entity.setCountryCode(apiHoliday.getCountryCode());
            entity.setYearFromDate(); // Postavlja godinu iz datuma

            // Mapiranje tipova (OneToMany)
            if (apiHoliday.getType() != null) {
                TypeEntity typeEntity = new TypeEntity(apiHoliday.getType());
                typeEntity.setPublicHoliday(entity);
                entity.getTypes().add(typeEntity);
            }

            repository.saveIfNotExists(entity);
        }
    }
}
