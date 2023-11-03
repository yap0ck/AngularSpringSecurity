package be.bstorm.formation.demosecurite.pl.models;

import be.bstorm.formation.demosecurite.dal.models.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthDTO {
    private String login;
    private String token;
    private Set<UserRole> roles;
}
