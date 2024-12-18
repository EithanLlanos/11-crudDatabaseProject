package springCourse.CrudDatabaseProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

        return "employees/list-employees";
    }

    // add mapping for {/add}
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/showFormForAdd")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save employee
        employeeService.save(theEmployee);


        // REDIRECT TO PREVENT DUPLICATE SUBMISSIONS

        return "redirect:/employees/list";
    }
}
