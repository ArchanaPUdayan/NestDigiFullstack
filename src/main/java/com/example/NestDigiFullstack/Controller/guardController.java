package com.example.NestDigiFullstack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class guardController {
    @Autowired

    @PostMapping("/addGuard")
    public String add(){
        return "add page";
    }
    @PostMapping("/loginGuard")
    public String login(){
        return "login page";
    }
    @GetMapping("/viewGuard")
    public String view(){
        return "view page";
    }
    @PostMapping("/deleteGuard")
    public String delete(){
        return "delete page";
    }
    @PostMapping("/searchGuard")
    public String search(){
        return "search page";
    }


}
