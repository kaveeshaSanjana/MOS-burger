package edu.icet.ecom.service;

import edu.icet.ecom.dto.Cart;
import edu.icet.ecom.dto.GetCartDTO;

import java.util.List;

public interface CartService {
    Cart save(Cart c);
    boolean delete(String id);
    List<GetCartDTO> getAll(String email);
}
