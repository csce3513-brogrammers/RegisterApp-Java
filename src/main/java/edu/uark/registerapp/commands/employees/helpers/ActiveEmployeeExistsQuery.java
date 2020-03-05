package edu.uark.registerapp.commands.employees.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery {

    public void query() {

        if (employeerepository.existsByIsActive(false)) {

            throw new NotFoundException("Employee");
        }
    }

    @Autowired
    private EmployeeRepository employeerepository;
}