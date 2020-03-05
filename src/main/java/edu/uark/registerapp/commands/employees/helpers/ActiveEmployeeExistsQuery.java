package edu.uark.registerapp.commands.employees.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class ActiveEmployeeExistsQuery implements VoidCommandInterface {

    void execute() {}

    public boolean query() {

        if (employeerepository.existsByIsActive(true)) {
            
            //Sign-In
            return true;
        }

        //Employee-Detail
        return false;
    }

    @Autowired private EmployeeRepository employeerepository;
}