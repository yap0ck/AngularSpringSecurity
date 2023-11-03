package be.bstorm.formation.demosecurite.pl.models;

import be.bstorm.formation.demosecurite.dal.models.Badge;
import be.bstorm.formation.demosecurite.dal.models.UserRole;
import lombok.Data;

import java.util.Set;

@Data
public class UserForm {
    private String nom;

    private Set<UserRole> roles;

    private String login;
    private String password;

    private Set<Badge> badges;
}
