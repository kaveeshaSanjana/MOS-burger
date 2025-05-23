package edu.icet.ecom.config;

import edu.icet.ecom.repository.UserDao;
import edu.icet.ecom.service.jwt.JWTService;
import filter.JWTFilter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final JWTService jwtService;
    private final UserDao userDao;
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

    @Bean
    public JWTFilter jwtFilter(){
        return new JWTFilter(jwtService,userDao);
    }

}
