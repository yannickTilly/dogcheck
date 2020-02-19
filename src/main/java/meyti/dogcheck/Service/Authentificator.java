package meyti.dogcheck.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import meyti.dogcheck.Model.Entity.User;
import meyti.dogcheck.Model.Exception.UserNotFound;
import meyti.dogcheck.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Authentificator {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    public User getUser() throws UserNotFound {
        String token = request.getHeader("authorization");
        if (token == null) {
            throw new UserNotFound();
        }
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        User user = userRepository.findOneById(jwt.getClaim("id").asLong());
        if (user != null) {
            return user;
        } else {
            throw new UserNotFound();
        }
    }

    public Optional findByToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        User user = userRepository.findOneById(jwt.getClaim("id").asLong());
        org.springframework.security.core.userdetails.User springUser =
                new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        getGrantedAuthorities(user));
        return Optional.of(springUser);
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
