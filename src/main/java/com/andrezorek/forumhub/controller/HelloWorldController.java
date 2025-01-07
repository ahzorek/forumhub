package com.andrezorek.forumhub.controller;

import com.andrezorek.forumhub.dto.HelloData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String getHello(){
        return "Hello, World!";
    }

    @PostMapping
    public String postHello(@RequestBody HelloData helloData){
        System.out.println("HelloData recebido ::: ");

        return "Hello, " + helloData.name() + ". " + helloData.verb();
    }

}
