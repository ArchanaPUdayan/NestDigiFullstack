package com.example.NestDigiFullstack.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class guardController {
    @PostMapping("/addGuard")
    public String add(){
        return "add page";
    }

}
