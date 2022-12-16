package com.example.NestDigiFullstack.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {
    @PostMapping("addLeaves")
    public String addLeaves(){
        return "Welcome to add leave page";
    }
    @GetMapping("/viewLeaves")
    public String viewLeaves(){
        return "Welcome to view leave page";
    }
    @PostMapping("/Leaves")
    public String Leaves(){
        return "Welcome to leave page";
    }
    @PostMapping("/searchLeaves")
    public String searchLeaves(){
        return "Welcome to searchLeaves page";
    }

    @PostMapping("/editLeaves")
    public String editLeaves(){
        return "Welcome to edit page";
    }

}
