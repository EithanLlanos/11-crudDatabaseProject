package springCourse.CrudDatabaseProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springCourse.CrudDatabaseProject.entity.Employee;
import springCourse.CrudDatabaseProject.service.EmployeeService;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/form")
    public String showFormForAdd(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/form")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save employee
        employeeService.save(theEmployee);


        // REDIRECT TO PREVENT DUPLICATE SUBMISSIONS

        return "redirect:/employees/list";
    }

    // add mapping for update
    @GetMapping("/formUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        Optional<Employee> theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PutMapping("/form")
    public String updateEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
}
