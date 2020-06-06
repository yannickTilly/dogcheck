package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.Report;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ReportController extends BaseController {

    @Autowired
    ReportRepository reportRepository;

    public Report postReport(Report report)
    {
        reportRepository.save(report);
        return report;
    }

    public List<Report> getReports()
    {
        return (List<Report>) reportRepository.findAll();
    }

    public List<Report> getUserReports(long userId) throws UserNotFound {
        User user = userRepository.findOneById(userId);
        if (user == null)
        {
            throw new UserNotFound();
        }
        return (List<Report>) user.getCreatedReports();
    }

    public Report getReport(long id) throws DogNotFound {
        Report report = reportRepository.findOneById(id);
        if (report == null)
        {
            throw new DogNotFound();
        }
        return report;
    }
}
