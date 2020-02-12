package meyti.dogcheck.Controller.Base;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected UserRepository userRepository;

    public User getUser()
    {
        return new User();
    }
}
