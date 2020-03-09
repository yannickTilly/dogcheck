package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Information;
import meyti.dogcheck.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface InformationRepository extends CrudRepository<Information, Long> {
    Information findOneById(long id);
}
