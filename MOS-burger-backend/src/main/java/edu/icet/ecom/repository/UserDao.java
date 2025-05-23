package edu.icet.ecom.repository;

import edu.icet.ecom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsernameAndPassword(String username,String password);
    UserEntity findByUsername(String username);
}
