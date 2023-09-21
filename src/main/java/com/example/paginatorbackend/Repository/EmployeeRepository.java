package com.example.paginatorbackend.Repository;
import com.example.paginatorbackend.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee>findByDeleted(Boolean delete);

}
