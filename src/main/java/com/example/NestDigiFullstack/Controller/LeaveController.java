package com.example.NestDigiFullstack.Controller;


import com.example.NestDigiFullstack.Model.Leave;
import com.example.NestDigiFullstack.dao.LeaveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    LeaveDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addLeaves(@RequestBody Leave leaves){

        HashMap<String,String> map = new HashMap<>();
        System.out.println(leaves.toString());
       LocalDate from=LocalDate.parse(String.valueOf(leaves.getFrom()));
        LocalDate to=LocalDate.parse(String.valueOf(leaves.getTo()));
        long diffInDays = ChronoUnit.DAYS.between(from, to);
        leaves.setDays((int) diffInDays+1);
        dao.save(leaves);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewLeaves")
    public List<Leave> viewLeaves(){
        return (List<Leave>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/Leaves")
    public List<Map<String,String>> Leaves(){
        return (List<Map<String, String>>) dao.Leaves();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchLeaves",consumes = "application/json",produces = "application/json")
    public List<Leave> searchLeaves(@RequestBody Leave leaves){

        System.out.println(leaves.getEmpid());
        return (List<Leave>) dao.searchLeaves(leaves.getEmpid());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> editLeaves(@RequestBody Leave leaves){

        HashMap<String,String> map = new HashMap<>();
        System.out.println(leaves.getStatus()+"  "+leaves.getId()+"  "+leaves.getRemarks());
        dao.updateLeave(leaves.getStatus(),leaves.getRemarks(),leaves.getId());
        map.put("status","success");
        return map;
    }


}
