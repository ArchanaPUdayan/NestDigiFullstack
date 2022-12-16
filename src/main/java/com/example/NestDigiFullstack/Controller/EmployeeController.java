package com.example.NestDigiFullstack.Controller;



import com.example.NestDigiFullstack.Model.Employee;
import com.example.NestDigiFullstack.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao dao;

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
   public HashMap<String,String> add(@RequestBody Employee e){
        HashMap<String,String> map = new HashMap<>();
        dao.save(e);
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e){
        HashMap<String, String> map = new HashMap<String, String>();
       List<Employee>emp=dao.passwordCheck(e.getUserName(),e.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
            map.put("employeeCode",String.valueOf( emp.get(0).getEmployeeCode()));
        }else {
            map.put("status","failed");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view")
    public List<Employee> view(){
        return (List<Employee>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
   @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Employee> search(@RequestBody Employee employee){
        return (List<Employee>) dao.searchEmployees(employee.getEmployeeCode());
   }
   @CrossOrigin(origins = "*")
   @PostMapping("/delete")
   public HashMap<String,String> delete(@RequestBody Employee employee) {
       HashMap<String, String> map = new HashMap<>();
       dao.deleteEmployee(employee.getId());
       map.put("status","success");
       return map;
   }
   @CrossOrigin(origins = "*")
   @GetMapping("/viewEmpLeaves")
   public List<Employee> viewLeaves(){
       LocalDate ld1=LocalDate.now();
       return (List<Employee>) dao.findEmployeesLeaves(String.valueOf(ld1));
   }

}
