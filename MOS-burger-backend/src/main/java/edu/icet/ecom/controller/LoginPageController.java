package edu.icet.ecom.controller;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
    @RequestMapping("/api/login")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class LoginPageController {
    final LoginService loginService;
    final PasswordEncoder passwordEncoder;

    public UserDTO isExists ( HttpServletRequest httpHeaders){
      log.debug(httpHeaders.getRequestURI());
      return null;
    }

    @GetMapping("check/{username}/{password}")
    public String isUser(@PathVariable("username") String username, @PathVariable("password") String password,HttpServletRequest servletRequest){
        log.info(servletRequest.getRemoteAddr());

        System.out.println(passwordEncoder.encode("12345"));

        System.out.println(passwordEncoder.matches("12345","$2a$12$9o2T4nJonpTHk39/DOd2a.p.ybVrq2rjRRG3KcDSL0ITtaOFF7BpG"));
        return loginService.isUser(username,password);
    }
}
