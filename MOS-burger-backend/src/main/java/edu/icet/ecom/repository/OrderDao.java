package edu.icet.ecom.repository;

import edu.icet.ecom.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrderDao extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByDate(Date date);

    List<OrderEntity> findAllByEmail(String email);
}
