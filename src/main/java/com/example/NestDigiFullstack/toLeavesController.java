package com.example.NestDigiFullstack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class toLeavesController {
    @PostMapping("/addTotal")
    public String addTotal(){
        return "Welcome to add page";
    }

    @PostMapping("/searchTotal")
    public String searchTotal(){
        return "Welcome to search page";
    }
    @PostMapping("/editTotal")
    public String editTotal(){
        return "Welcome to edit page";
    }

}
