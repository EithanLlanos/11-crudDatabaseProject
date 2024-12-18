package springCourse.CrudDatabaseProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springCourse.CrudDatabaseProject.entity.Employee;
import springCourse.CrudDatabaseProject.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    // initialize employeeService
    final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for {/list}
    @GetMapping("/list")
    public String listEmployee(Model theModel) {
        List<Employee> employees = employeeService.findAll();

        theModel.addAttribute("employees", employees);

        return "list-employees";
    }
}
