package pt.deti.ies.datarestint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.deti.ies.datarestint.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}