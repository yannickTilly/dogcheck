package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.HeightPoint;
import org.springframework.data.repository.CrudRepository;

public interface HeightPointRepository extends CrudRepository<HeightPoint, Long> {
    HeightPoint findOneById(long id);
}
