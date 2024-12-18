package springCourse.CrudDatabaseProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import springCourse.CrudDatabaseProject.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // add a method to sort by last name, this method is handled completely by JpaRepository
    //See https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html for more information
    public List<Employee> findAllByOrderByLastNameAsc();
}
