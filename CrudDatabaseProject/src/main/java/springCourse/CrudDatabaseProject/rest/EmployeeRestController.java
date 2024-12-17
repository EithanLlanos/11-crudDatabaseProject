package springCourse.CrudDatabaseProject.rest;

import org.springframework.web.bind.annotation.*;
import springCourse.CrudDatabaseProject.entity.Employee;
import springCourse.CrudDatabaseProject.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
//        To be sure save method works as intended
        theEmployee.setId(0);
        Employee employee = employeeService.save(theEmployee);
        return employee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee theEmployee) {
        theEmployee.setId(employeeId);
        Employee employee = employeeService.save(theEmployee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isEmpty()) throw new RuntimeException("Employee id not found - " + employeeId);
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }


}
