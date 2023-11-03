package be.bstorm.formation.demosecurite.bll;

import be.bstorm.formation.demosecurite.dal.models.User;
import be.bstorm.formation.demosecurite.pl.models.AuthDTO;
import be.bstorm.formation.demosecurite.pl.models.LoginForm;
import be.bstorm.formation.demosecurite.pl.models.UserForm;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    void register(UserForm form);
    AuthDTO login(LoginForm form);
    Optional<User> getOne(String login);
    Set<String> getAllName();
}
