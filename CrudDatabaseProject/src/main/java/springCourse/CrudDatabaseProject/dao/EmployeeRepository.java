package springCourse.CrudDatabaseProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import springCourse.CrudDatabaseProject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
