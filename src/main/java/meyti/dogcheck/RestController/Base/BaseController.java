package meyti.dogcheck.RestController.Base;

import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.UserRepository;
import meyti.dogcheck.Service.Authentificator;
import meyti.dogcheck.Service.RedisConnector;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RedisConnector redisConnector;

    @Autowired
    private Authentificator authentificator;
    public User getUser() throws UserNotFound
    {
        return this.authentificator.getUser();
    }
}
