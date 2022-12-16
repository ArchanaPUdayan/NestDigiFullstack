package com.example.NestDigiFullstack.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
    @Autowired

    @PostMapping("/add")
   public String Addpage(){
        return "welcome to my add page";

    }
    @PostMapping("/login")
    public String Loginpage(){
        return "Welcome to my login page";
    }
    @PostMapping("/view")
    public String Viewpage(){
        return "Welcome to my view page";
    }
   @PostMapping("/search")
    public String Searchpage(){
        return "Welcome tomy search page";
   }

}
