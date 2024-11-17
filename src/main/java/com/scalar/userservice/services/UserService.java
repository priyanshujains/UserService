package com.scalar.userservice.services;

import com.scalar.userservice.Repositories.TokenRepo;
import com.scalar.userservice.Repositories.UserRepo;
import com.scalar.userservice.models.Token;
import com.scalar.userservice.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
        private UserRepo userRepo;
        private TokenRepo  tokenRepo;
        private BCryptPasswordEncoder bCryptPasswordEncoder;

            @Autowired
        public UserService(UserRepo userRepo,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                                    TokenRepo tokenRepo){
            this.userRepo=userRepo;
            this.bCryptPasswordEncoder=bCryptPasswordEncoder;
            this.tokenRepo=tokenRepo;
        }

    public User signup(String email, String password ,String name){
        User u =new User();
        u.setName(name);
        u.setEmail(email);
        u.setHashedPassword(bCryptPasswordEncoder.encode(password));

       return userRepo.save(u);
    }

    public Token login(String email, String Cpassword){
        Optional<User>  userOptional=userRepo.findByEmail(email);

        if(userOptional.isEmpty()){
            //return
            return null;
        }

        User user=userOptional.get();
        if(!bCryptPasswordEncoder.matches(Cpassword,user.getHashedPassword())){
            return null;
            //throw password not match exception
        }
        Token token=new Token();
        token.setUser(user);

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date futureDate = calendar.getTime();
        token.setExpiryAt(futureDate);
        token.setValue(RandomStringUtils.randomAlphabetic(15));
        return tokenRepo.save(token);

    }


    public void logout(String token){
                Optional<Token> token1=tokenRepo.findByValueAndDeletedEquals(token, false);

                if(token1.isEmpty()){
                    return;
                    //throw token not  exist and expire excep
                }

                Token tkn=token1.get();
                tkn.setDeleted(true);

                tokenRepo.save(tkn);
    }

    public User validateToken(String token ){
                Optional<Token> token1=tokenRepo.findByValueAndDeletedEqualsAndExpiryAtGreaterThan(token,false,new Date());

                if(token1.isEmpty())return null;

                return token1.get().getUser();


    }


}
