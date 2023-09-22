package com.example.paginatorbackend.Controller;
import com.example.paginatorbackend.Model.Employee;
import com.example.paginatorbackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add-employee")
    public Long createEmployee(@RequestBody Employee employee){
        this.employeeRepository.save(employee);
        System.out.println("employee Id:"+employee.getId());
        return employee.getId();
    }

    @GetMapping("/get-all_employee")
    public List<Employee> getAll(){
        return this.employeeRepository.findByDeleted(Boolean.FALSE);
    }

    @PutMapping("/update-employee")
    public Long updateEmployee(@RequestBody Employee employee){
        this.employeeRepository.save(employee);
        System.out.println("Employee ID:"+employee.getId());
        return employee.getId();
    }

    @DeleteMapping("/delete-Details/{id}")
    public Boolean deleteEmployee(@PathVariable("id") Long id){
        Employee emp=this.employeeRepository.findById(id).get();
        emp.setDeleted(true);
        System.out.println("Delete Employee Details:"+id);
        this.employeeRepository.save(emp);
        return Boolean.TRUE;
    }
}
