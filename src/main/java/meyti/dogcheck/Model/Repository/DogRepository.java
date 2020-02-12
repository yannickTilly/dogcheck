package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
    Dog findOneById(long id);
}
