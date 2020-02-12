package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneById(long id);
}
