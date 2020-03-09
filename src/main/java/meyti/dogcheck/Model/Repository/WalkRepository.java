package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Entity.Walk;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface WalkRepository extends CrudRepository<Walk, Long> {
    Walk findOneById(long id);
}
