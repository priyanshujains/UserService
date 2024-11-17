package com.scalar.userservice.security.services;

import com.scalar.userservice.Repositories.UserRepo;
import com.scalar.userservice.models.CustomUserDetail;
import com.scalar.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepo userRepo;
    // CustomUserDetail customUserDetail;

    @Autowired
    public CustomUserDetailService(UserRepo userRepo){
        this.userRepo=userRepo;
       // this.customUserDetail=customUserDetail;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional=userRepo.findByEmail(username);

        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("user with emailid "+username+"is not exist");
        }

        return new CustomUserDetail(userOptional.get());
    }
}
