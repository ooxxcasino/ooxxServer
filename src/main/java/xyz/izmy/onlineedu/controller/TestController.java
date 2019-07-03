package xyz.izmy.onlineedu.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iYmz
 */
@RestController
@CrossOrigin
public class TestController {

    @RequestMapping(value = "/test")
    public Object getTest(){
        return "test";
    }
}
