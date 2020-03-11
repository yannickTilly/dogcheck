package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.WeightPoint;
import org.springframework.data.repository.CrudRepository;

public interface WeightPointRepository extends CrudRepository<WeightPoint, Long> {
    WeightPoint findOneById(long id);
}
