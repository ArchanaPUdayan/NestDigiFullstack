package com.example.NestDigiFullstack.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @PostMapping("/addLog")
    public String addLog(){
        return "welcome to add page";
    }
    @PostMapping("/editLog")
    public String editLog(){
        return "welcome to my edit page";
    }
    @GetMapping("/todayLog")
    public String todayLog(){
        return "Welcome to my today page";
    }
    @PostMapping("/dateLog")
    public String dateLog(){
        return "Welcome to my date page";
    }

}
