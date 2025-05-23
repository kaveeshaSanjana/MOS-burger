package edu.icet.ecom.controller;

import edu.icet.ecom.dto.ProductDto;
import edu.icet.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    final ProductService productService;

    @PostMapping("/save")
    public Boolean save(@RequestBody ProductDto p){
       return productService.add(p);
    }

    @GetMapping("/get-all")
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return productService.delete(id);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody ProductDto productDto){
        return productService.update(productDto);
    }
}
