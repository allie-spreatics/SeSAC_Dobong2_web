package sesac.sesac_spring_boot_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String helloWorld(){
        return "hello, world";
    }

    @GetMapping("/test")
    public String test(){
        return "you are login user!!";
    }
}
