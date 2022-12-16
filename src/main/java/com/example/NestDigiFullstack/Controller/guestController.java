package com.example.NestDigiFullstack.Controller;


import com.example.NestDigiFullstack.Model.Guest;
import com.example.NestDigiFullstack.dao.GuestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class guestController {

    @Autowired
    GuestDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/guestAdd",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addGuest(@RequestBody Guest g) {
        HashMap<String, String> map = new HashMap<>();
        LocalDate ld1=LocalDate.now();
        g.setDate(String.valueOf(ld1));
        dao.save(g);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLogGuest",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addGuestLog(@RequestBody Guest log) {
        HashMap<String, String> map = new HashMap<>();
        LocalTime lt1 = LocalTime.now();
        LocalDate ld1=LocalDate.now();
        log.setLogin(String.valueOf(lt1));
        log.setDate(String.valueOf(ld1));
        System.out.println(log.getLogin());
        System.out.println(log.getDate());
        dao.updateLogin(log.getDate(),log.getLogin(),log.getGuest_id());

        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editLogGuest",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> editGuestLog(@RequestBody Guest log) {
        HashMap<String, String> map = new HashMap<>();
        LocalTime lt1 = LocalTime.now();
        LocalDate ld1=LocalDate.now();
        log.setLogout(String.valueOf(lt1));
        log.setDate(String.valueOf(ld1));
        List<Guest> log1=dao.searchLog(log.getDate(),log.getGuest_id());
        LocalTime lt2 = LocalTime.parse(log1.get(0).getLogin());
        int minutes= (int) lt2.until(lt1, ChronoUnit.MINUTES);
        System.out.println(minutes);
        dao.updateGuestLog(log.getLogout(),minutes, log.getGuest_id(),log.getDate());
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewGuest")
    public List<Map<String,String>> viewGuestLog(){
        LocalDate ld1=LocalDate.now();

        return (List<Map< String,String>>) dao.todayLog1Maps(String.valueOf(ld1));
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/dateLogGuest",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> GuestLog(@RequestBody logHours log){
        return  dao.todayLog1Maps(log.getDate());
    }



}
