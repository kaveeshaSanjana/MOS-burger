package edu.icet.ecom.service.jwt;

import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUsername(username);
        if (user==null)return null;
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
