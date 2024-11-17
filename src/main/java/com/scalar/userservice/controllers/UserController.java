package com.scalar.userservice.controllers;

import com.scalar.userservice.dtos.LoginRequestDto;
import com.scalar.userservice.dtos.LogoutRequestDto;
import com.scalar.userservice.dtos.SigninRequestDto;
import com.scalar.userservice.dtos.UserDto;
import com.scalar.userservice.models.Token;
import com.scalar.userservice.models.User;
import com.scalar.userservice.services.UserService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }



    @PostMapping()
    public UserDto signUp(@RequestBody SigninRequestDto request){
        String email= request.getEmail();
        String name= request.getName();
        String password= request.getPassword();

        return UserDto.from(userService.signup(email,password,name));
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto loginRequestDto){
        String email=loginRequestDto.getEmail();
        String password=loginRequestDto.getPassword();
        return userService.login(email,password);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto){
        userService.logout(logoutRequestDto.getToken());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/validate/{token}")
    public UserDto ValidateToken(@PathVariable("token") String token){

        return UserDto.from(userService.validateToken(token));
    }
}
