package com.subir.user.service;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.subir.user.entity.User;
import com.subir.user.repository.UserRepository;
import dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void createUser(UserDTO user) {
        userRepository.save(convertToEntity(user));
    }


    private User convertToEntity(UserDTO userDTO) {
        User map = modelMapper.map(userDTO, User.class);
        map.setId(Uuids.timeBased());
        return map;
    }
}
