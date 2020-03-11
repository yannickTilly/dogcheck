package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.HeightPoint;
import meyti.dogcheck.Model.Entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
    Vaccine findOneById(long id);
}
