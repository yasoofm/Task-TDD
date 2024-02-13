package com.letcode.SecureBankSystem.controllers;

import com.letcode.SecureBankSystem.bo.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class CodedController {

    @GetMapping("/sayHi")
    public String sayHi(){
        return "Welcome to Coded";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello " + name;
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Person person){
        return "Farewell " + person.name;
    }
}
