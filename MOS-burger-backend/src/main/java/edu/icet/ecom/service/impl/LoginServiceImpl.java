package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDao;
import edu.icet.ecom.service.LoginService;
import edu.icet.ecom.service.jwt.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserDTO isExists(String username, String password){
        UserEntity user = userDao.findByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }
    public String isUser(String username, String password) {
        System.out.println(userDao.findByUsername(username));
        if(userDao.findByUsername(username)!=null){
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,"12345"));
            } catch (AuthenticationException e) {
                throw new RuntimeException(e);
            }
            System.out.println(password);
            Map<String, Object> claims = new HashMap<>();
            claims.put("role","user");
            claims.put("ip","108.663.25.8");

            String token = jwtService.getToken(username, claims );
            return token;

        }
        return "Already not Exists";

    }

}
