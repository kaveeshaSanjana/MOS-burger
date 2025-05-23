package edu.icet.ecom.controller;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
    @RequestMapping("/api/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LoginPageController {
    final LoginService loginService;
    final PasswordEncoder passwordEncoder;

    public UserDTO isExists ( HttpServletRequest httpHeaders){
      log.debug(httpHeaders.getRequestURI());
      return null;
    }

    @GetMapping("check/{username}/{password}")
    public ResponseEntity<String> isUser(@PathVariable("username") String username, @PathVariable("password") String password, HttpServletRequest servletRequest){
        log.info(servletRequest.getRemoteAddr());

        System.out.println(passwordEncoder.encode("12345"));

        System.out.println(passwordEncoder.matches(password,"$2a$12$eh84Vuww1WizXsGbbsivzOb5cmNOjEvyBXgYXunUl2oW1mOPZacYC"));
        String user = loginService.isUser(username, password);
        System.out.println("Token "+user);
        return ResponseEntity.ok(user);
    }
}
