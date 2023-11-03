package be.bstorm.formation.demosecurite.pl.models;

import be.bstorm.formation.demosecurite.dal.models.Badge;
import be.bstorm.formation.demosecurite.dal.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Set<Badge> badges;
    
    public static UserDTO fromEntityToDTO(User entity){
        return UserDTO.builder()
                .badges(entity.getBadges())
                .build();
    }
}
