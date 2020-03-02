package edu.uark.registerapp.commands.employees.helpers;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery {

    public ActiveEmployeeExistsQuery() {

    }

    public void query() {

        if (EmployeeRepository.existsByIsActive(false)) {

            NotFoundException exception = new NotFoundException("Employee");
        }
    }
}