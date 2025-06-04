package services;

import entities.Employee;
import enums.EmployeeStatus;
import jakarta.validation.Valid;
import repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private Employee Employee;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> findByMatricule(String matricule) {
        return employeeRepository.findByMatricule(matricule);
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchByKeyword(keyword);
    }

    public List<Employee> getActiveEmployees() {
        return employeeRepository.findByStatut(EmployeeStatus.ACTIF);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(@Valid Employee employee) {
        return employeeRepository.save(Employee);
    }

    public void deleteById(Long id) {
    }
}