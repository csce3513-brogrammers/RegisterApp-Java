package edu.uark.registerapp.commands.employees.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class ActiveEmployeeExistsQuery {

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