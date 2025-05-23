package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Cart;
import edu.icet.ecom.dto.GetCartDTO;
import edu.icet.ecom.entity.CartEntity;
import edu.icet.ecom.repository.CartDao;
import edu.icet.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartDao cartDao;
    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;
    @Override
    public Cart save(Cart c) {
        if(c == null || c.getCustomerEmail() == null || c.getProductId()==null) return null;

        Optional<CartEntity> s = cartDao
                                .findByProductIdAndEmail(c.getProductId()
                                                        ,c.getCustomerEmail());
        System.out.println(s);
        if(s.isPresent()){
            CartEntity save = modelMapper.map(c, CartEntity.class);
            save.setCartId((s.get().getCartId()));
            save.setQty(s.get().getQty()+1);
            cartDao.save(save);
            return modelMapper.map(save,Cart.class);
        }

        return modelMapper.map(cartDao.save(modelMapper.map(c, CartEntity.class)), Cart.class);

    }

    @Override
    public boolean delete(String email) {

        return cartDao.deleteByEmail(email)>0;
    }

    @Override
    public List<GetCartDTO> getAll(String email) {
        ArrayList<GetCartDTO> cart = new ArrayList<>();
        cartDao.findByEmail(email).forEach(cartEntity -> {
            GetCartDTO getCartDTO = new GetCartDTO();
            getCartDTO.setProduct(productService.search(cartEntity.getProductId()));
            getCartDTO.setQty(cartEntity.getQty());
            getCartDTO.setCustomerEmail(cartEntity.getCustomerEmail());
            getCartDTO.setCartId(cartEntity.getCartId());

            cart.add(getCartDTO);
        });
        return cart;
    }
}
