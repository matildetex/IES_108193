package pt.deti.ies.datarestint.controller;

import pt.deti.ies.datarestint.entity.Employee;
import pt.deti.ies.datarestint.repository.EmployeeRepository;
import pt.deti.ies.datarestint.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmpController {

    private EmployeeService EmployeeService;
    private EmployeeRepository EmployeeRepository;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee){
        Employee savedEmployee = EmployeeService.createEmployee(Employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get Employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long EmployeeId){
        Employee Employee = EmployeeService.getEmployeeById(EmployeeId);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> Employees = EmployeeService.getAllEmployees();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long EmployeeId,
                                           @RequestBody Employee Employee){
        Employee.setId(EmployeeId);
        Employee updatedEmployee = EmployeeService.updateEmployee(Employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //Find employee by email
    @GetMapping("/employees/email/{emailId}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "email") String employeeEmail) {
        Employee employee = EmployeeRepository.findByEmail(employeeEmail);
        return ResponseEntity.ok().body(employee);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long EmployeeId){
        EmployeeService.deleteEmployee(EmployeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}
