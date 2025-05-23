package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDao;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;
    @Override
    public void userRegister(UserDTO userDTO) {
        System.out.println(userDTO);
        userDao.save(modelMapper.map(userDTO, UserEntity.class));
    }
}
