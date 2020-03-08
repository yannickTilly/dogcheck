package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneById(long id);
    User findOneByLogin(String login);
    Collection<User> findByNameContainingIgnoreCase(String name);
}
