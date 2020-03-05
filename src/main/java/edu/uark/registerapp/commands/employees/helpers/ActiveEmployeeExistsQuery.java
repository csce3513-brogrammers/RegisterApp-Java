package edu.uark.registerapp.commands.employees.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery {

    public boolean query() {

        if (employeerepository.existsByIsActive(true)) {

            throw new NotFoundException("Employee");
        }

        return true;
    }

    @Autowired
    private EmployeeRepository employeerepository;
}