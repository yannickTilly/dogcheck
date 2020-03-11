package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import meyti.dogcheck.Model.Entity.WalkPoint;
import org.springframework.data.repository.CrudRepository;

public interface WalkPointRepository extends CrudRepository<WalkPoint, Long> {
    WalkPoint findOneById(long id);
}
