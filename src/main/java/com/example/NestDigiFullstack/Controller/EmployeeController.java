package com.example.NestDigiFullstack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;


   @RestController
    public class employeeController {
       @Autowired
       EmployeeDao dao;

       @CrossOrigin(origins = "*")
       @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
       public HashMap<String, String> add(@RequestBody Employee e) {
           HashMap<String, String> map = new HashMap<>();
           dao.save(e);
           map.put("status", "success");
           return map;
       }


   }

