package com.example.NestDigiFullstack.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController




public class guestController {

    @Autowired

    @PostMapping("/guestAdd")
    public String addGuest(){
        return "add page";
    }
    @PostMapping("/addLogGuest")
    public String addGuestLog(){
        return "add guest log page";
    }
    @PostMapping("/editLogGuest")
    public String editGuestLog(){
        return "edit guest page";
    }
    @GetMapping("/viewGuest")
    public String viewGuestLog(){
        return "view guest page";
    }
    @PostMapping("/dateLogGuest")
    public String GuestLog(){
        return "guest log page";
    }

}
