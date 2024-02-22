package be.bstorm.formation.demosecurite.pl.controller;

import be.bstorm.formation.demosecurite.bll.UserService;
import be.bstorm.formation.demosecurite.pl.models.AuthDTO;
import be.bstorm.formation.demosecurite.pl.models.LoginForm;
import be.bstorm.formation.demosecurite.pl.models.UserDTO;
import be.bstorm.formation.demosecurite.pl.models.UserForm;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return userService.login(form);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public void register(@RequestBody UserForm form){
        userService.register(form);
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/one")
    public UserDTO getOne(Authentication authentication){
        return UserDTO.fromEntityToDTO(userService.getOne(authentication.getName()).orElseThrow(()-> new RuntimeException("Pas trouvé")));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public Set<String> getAllNames(){
        return userService.getAllName();
    }
}
