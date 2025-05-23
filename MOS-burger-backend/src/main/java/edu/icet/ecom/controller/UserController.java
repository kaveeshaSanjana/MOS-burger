package edu.icet.ecom.controller;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public void saveUser(@RequestBody UserDTO userDTO){
        System.out.println("request came"+userDTO);
        userService.userRegister(userDTO);
    }
}
