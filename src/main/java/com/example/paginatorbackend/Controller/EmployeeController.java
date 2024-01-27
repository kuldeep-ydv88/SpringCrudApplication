package com.example.paginatorbackend.Controller;

import com.example.paginatorbackend.Model.Employee;
import com.example.paginatorbackend.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is Employee controller it Handles
 * all the upcoming request for the employee
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * This method add the employee in the Db and it returns Id
     *
     *
     *
     * @param employee
     * @return id
     */
    @PostMapping("/add-employee")
    public Long createEmployee(@RequestBody Employee employee) {
        this.employeeRepository.save(employee);
        log.info("Employee add successfully in Db with id: {}", employee.getId());
        return employee.getId();
    }

    /**
     * it the List of all employee which is present in the Db
     *
     * @return List of Employee
     */
    @GetMapping("/get-all_employee")
    public List<Employee> getAll() {
        log.info("this gives me list of Employee ");
        return this.employeeRepository.findByDeleted(Boolean.FALSE);
    }

    /**
     * This method update the details of Employee in the Db
     *
     * @param employee
     * @return Id
     */
    @PutMapping("/update-employee")
    public Long updateEmployee(@RequestBody Employee employee) {
        this.employeeRepository.save(employee);
        log.info("Employee details updated successfully in id :{}", employee.getId());
        return employee.getId();
    }

    /**
     * This method delete Employee Details from Db with id
     *
     *
     * @param id
     * @return True or False
     */
    @DeleteMapping("/delete-Details/{id}")
    public Boolean deleteEmployee(@PathVariable("id") Long id) {
        Employee emp = this.employeeRepository.findById(id).get();
        emp.setDeleted(true);
        this.employeeRepository.save(emp);
        log.info("Employee details delete successfully from Db with id :{}", id);
        return Boolean.TRUE;

    }
}
