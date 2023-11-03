package be.bstorm.formation.demosecurite.dal;

import be.bstorm.formation.demosecurite.dal.models.Badge;
import be.bstorm.formation.demosecurite.dal.models.User;
import be.bstorm.formation.demosecurite.dal.models.UserRole;
import be.bstorm.formation.demosecurite.dal.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInit implements InitializingBean {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setNom("Elise");
        user.setLogin("Elise");
        user.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.STUDENT);
        user.setRoles(roles);
        HashSet<Badge> badges = new HashSet<>();
        badges.add(Badge.ANGULAR);
        user.setBadges(badges);
        user.setEnabled(true);
        userRepository.save(user);

        User user2 = new User();
        user2.setNom("Laurent");
        user2.setLogin("Laurent");
        user2.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles2 = new HashSet<>();
        roles2.add(UserRole.STUDENT);
        user2.setRoles(roles2);
        HashSet<Badge> badges2 = new HashSet<>();
        badges2.add(Badge.GIT);
        user2.setBadges(badges2);
        user2.setEnabled(true);
        userRepository.save(user2);

        User user3 = new User();
        user3.setNom("Lucas");
        user3.setLogin("Lucas");
        user3.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles3 = new HashSet<>();
        roles3.add(UserRole.ADMIN);
        user3.setRoles(roles3);
        HashSet<Badge> badges3 = new HashSet<>();
        badges3.add(Badge.GIT);
        user3.setBadges(badges3);
        user3.setEnabled(true);
        userRepository.save(user3);
    }
}
