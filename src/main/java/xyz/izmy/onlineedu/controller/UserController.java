package xyz.izmy.onlineedu.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.izmy.onlineedu.entity.User;
import xyz.izmy.onlineedu.repository.UserRepository;

import javax.transaction.Transactional;
import java.awt.*;
import java.io.Serializable;
import java.net.URI;

/**
 * user controller
 * @author iYmz
 */

@Transactional
@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * save user
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registUser(@RequestBody User user)
    {
    User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
