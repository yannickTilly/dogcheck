package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Event;
import meyti.dogcheck.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findOneById(long id);
}
