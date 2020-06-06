package meyti.dogcheck.RestController.User;

import com.fasterxml.jackson.annotation.JsonView;
import meyti.dogcheck.Model.Exception.DogNotFound;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.ReportRepository;
import meyti.dogcheck.Model.RequestBody.Report.User.PostReport;
import meyti.dogcheck.Model.Response.View.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class ReportController extends meyti.dogcheck.RestController.Base.ReportController {

    @Autowired
    ReportRepository reportRepository;

    @RequestMapping(value = "report", method = RequestMethod.POST)
    @JsonView(Master.Report.class)
    public meyti.dogcheck.Model.Entity.Report postReport(@RequestBody PostReport postReport) throws UserNotFound {
        meyti.dogcheck.Model.Entity.Report report = postReport.getInformation(this.getUser());
        report.setCreator(this.getUser());
        return super.postReport(report);
    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    @JsonView(Master.Report.class)
    public meyti.dogcheck.Model.Entity.Report getReport(@PathVariable long id) throws DogNotFound {
        return super.getReport(id);
    }

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(Master.Report.class)
    public List<meyti.dogcheck.Model.Entity.Report> getReports()
    {
        return super.getReports();
    }

    @RequestMapping(value = "user/{userId}/reports", method = RequestMethod.GET)
    @JsonView(Master.Report.class)
    public List<meyti.dogcheck.Model.Entity.Report> getUserReports(@PathVariable long userId) throws UserNotFound {
//        TODO :droit
        return super.getUserReports(userId);
    }
}
