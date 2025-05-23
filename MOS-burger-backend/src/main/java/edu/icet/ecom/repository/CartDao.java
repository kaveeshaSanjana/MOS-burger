package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CartEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartDao extends JpaRepository<CartEntity, Long> {
    @Query("SELECT c FROM CartEntity c WHERE c.productId = :id AND c.customerEmail = :email")
    Optional<CartEntity> findByProductIdAndEmail(@Param("id") Long id, @Param("email") String email);

    @Query("SELECT c FROM CartEntity c WHERE c.customerEmail = :email")
    List<CartEntity> findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM CartEntity WHERE customerEmail =:email")
    Integer deleteByEmail(@Param("email") String email);
}
