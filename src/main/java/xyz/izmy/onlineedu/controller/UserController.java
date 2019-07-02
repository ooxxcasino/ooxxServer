package xyz.izmy.onlineedu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.izmy.onlineedu.entity.User;
import xyz.izmy.onlineedu.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * save user
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object getUserById(@PathVariable("id") Long id){
        User user = userRepository.findById(id).orElse(null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        return user;
    }
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public Object registUser(HttpServletRequest request, @RequestBody JSONObject jsonObject)
    {

        return jsonObject.get("text").toString();
    }


}
