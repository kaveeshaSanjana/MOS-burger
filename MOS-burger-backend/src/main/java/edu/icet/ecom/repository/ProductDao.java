package edu.icet.ecom.repository;

import edu.icet.ecom.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByNameContaining(String name);
}
