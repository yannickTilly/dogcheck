package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Vaccination;
import meyti.dogcheck.Model.Entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationRepository extends CrudRepository<Vaccination, Long> {
    Vaccination findOneById(long id);
}
