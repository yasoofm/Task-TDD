package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
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
