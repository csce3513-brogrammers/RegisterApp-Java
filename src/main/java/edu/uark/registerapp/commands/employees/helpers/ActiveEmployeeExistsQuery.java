package edu.uark.registerapp.commands.employees.helpers;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery {

    private static EmployeeRepository employee;

    public ActiveEmployeeExistsQuery(EmployeeRepository employeeRep) {

        employee = employeeRep;
    }

    public void query() {

        if (employee.existsByIsActive(false)) {

            throw new NotFoundException("Employee");
        }
    }
}