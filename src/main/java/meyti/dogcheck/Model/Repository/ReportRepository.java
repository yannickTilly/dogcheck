package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Report findOneById(long id);
}
