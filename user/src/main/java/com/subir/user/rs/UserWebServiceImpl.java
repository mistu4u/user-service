package com.subir.user.rs;

import com.subir.user.service.UserService;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rs")
public class UserWebServiceImpl implements UserWebService {
    private UserService userService;

    @Autowired
    public UserWebServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public void createUser(@RequestBody @Valid UserDTO userDTO) {
        userService.createUser(userDTO);
    }
}
