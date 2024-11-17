package com.scalar.userservice.dtos;

import com.scalar.userservice.models.Role;
import com.scalar.userservice.models.User;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private String name;
    private String email;

    @ManyToMany
    private List<Role> roles;

    public static UserDto from(User user){

        if(user==null)return null;  // agar validate token me user nhi mila to null aayrga isliye
        UserDto userDto=new UserDto();
        userDto.name=user.getName();
        userDto.email=user.getEmail();
        userDto.roles=user.getRoles();

        return userDto;
    }
}
