package com.example.NestDigiFullstack.Controller;

import com.example.NestDigiFullstack.Model.toLeaves;
import com.example.NestDigiFullstack.dao.toLeaveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
public class toLeavesController {

    @Autowired
    toLeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addTotal(@RequestBody toLeaves total){
        HashMap<String, String> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        total.setYear(localDate.getYear());
        dao.save(total);
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchTotal",consumes = "application/json",produces = "application/json")
    public List<toLeaves> searchTotal(@RequestBody toLeaves total){
        return dao.searchTotalLeavesEmployees(total.getEmp_id());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> editTotal(@RequestBody toLeaves total){
        HashMap<String, String> map = new HashMap<>();
        total.setYear(LocalDate.now().getYear());
        dao.editLeaves( total.getCasual_leaves(), total.getSick_leave(), total.getSpecial_leave(),   total.getEmp_id(),total.getYear());
        map.put("status","success");
        return map;
    }

    }

