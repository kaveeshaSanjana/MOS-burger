package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Cart;
import edu.icet.ecom.dto.GetCartDTO;
import edu.icet.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    final CartService cartService;

    @PostMapping("/save")
    public Cart save(@RequestBody Cart c){
        return cartService.save(c);
    }

    @RequestMapping("/delete/{email}")
    public boolean delete(@PathVariable("email")String email ){
        return cartService.delete(email);
    }

    @GetMapping("/get/{email}")
    public List<GetCartDTO> get(@PathVariable("email") String email){
        return cartService.getAll(email);
    }
}
