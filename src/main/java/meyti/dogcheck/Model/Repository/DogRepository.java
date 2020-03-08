package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface DogRepository extends CrudRepository<Dog, Long> {
    Dog findOneById(long id);
    Collection<Dog> findByNameContainingIgnoreCase(String name);
}
