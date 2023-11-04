package pt.deti.ies.datarestint.service.impl;
import lombok.AllArgsConstructor;
import pt.deti.ies.datarestint.entity.Employee;
import pt.deti.ies.datarestint.repository.EmployeeRepository;
import pt.deti.ies.datarestint.service.EmployeeService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Override
    public Employee createEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    @Override
    public Employee getEmployeeById(Long EmployeeId) {
        Optional<Employee> optionalEmployee = EmployeeRepository.findById(EmployeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee Employee) {
        Employee existingEmployee = EmployeeRepository.findById(Employee.getId()).get();
        existingEmployee.setName(Employee.getName());
        existingEmployee.setEmail(Employee.getEmail());
        Employee updatedEmployee = EmployeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long EmployeeId) {
        EmployeeRepository.deleteById(EmployeeId);
    }
}
