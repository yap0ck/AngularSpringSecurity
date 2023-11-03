package be.bstorm.formation.demosecurite.pl.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginForm {
    private String login;
    private String password;
}
