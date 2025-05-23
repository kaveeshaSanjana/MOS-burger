package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Cart;
import edu.icet.ecom.repository.CartDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CartServiceImplTest {


    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private ProductServiceImpl productService;

    @Mock
    private CartDao cartDao;

    @Mock
    private ModelMapper mapper;

    @Test
    void test_CartSave_whenNullableObject (){
        Cart c = cartService.save(new Cart());
        assertNull(c);
    }
    @Test
    void test_CartSave_whenInputExistsEmail (){

        Cart c = cartService.save(new Cart(2L, "kaveeshasanjana22@gamil.com", 1L, 12L));
        assertNotNull(c);
    }
    @Test
    void test_CartSave_whenInputNull (){
        Cart c = cartService.save(null);
        assertNull(c);
    }

}
