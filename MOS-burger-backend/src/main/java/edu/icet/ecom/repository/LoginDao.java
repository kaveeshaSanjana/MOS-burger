package edu.icet.ecom.repository;

import edu.icet.ecom.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<LoginEntity,Long> {
}
