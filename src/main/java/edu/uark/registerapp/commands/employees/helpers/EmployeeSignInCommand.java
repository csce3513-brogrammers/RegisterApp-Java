package edu.uark.registerapp.commands.employees.helpers;

import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeSignInCommand {

    private EmployeeSignIn employeeInfo;
    private String sessionID;

    public EmployeeSignInCommand(EmployeeSignIn employee, String session) {

        this.employeeInfo = employee;
        this.sessionID = session;
    }

    public void validate() {

        String ID = this.employeeInfo.getEmployeeId();
        String pass = this.employeeInfo.getPassword();

        if (ID.isEmpty() == false && NumberUtils.isDigits(ID) && pass.isEmpty() == false) {

            int number = Integer.parseInt(ID);

            if (employeeRepository.existsByEmployeeId(number)) {

                Optional<EmployeeEntity> employeeEnt = employeeRepository.findByEmployeeId(number);
                EmployeeEntity empEnt = employeeEnt.get();
                byte[] passArray = pass.getBytes();

                if (Arrays.equals(passArray, empEnt.getPassword())) {

                    createActiveUser();
                }

                else {

                    //Password Incorrect
                }
            }

            else {

                //employee doesnt exist
            }
        }
    }

    @Transactional
    public void createActiveUser() {

        UUID ID = UUID.fromString(employeeInfo.getEmployeeId());
        Optional<ActiveUserEntity> activeUser = activeRepository.findByEmployeeId(ID);

        if (activeUser.isPresent()) {

            ActiveUserEntity activeUserEntity = activeUser.get();
            activeUserEntity.setSessionKey(sessionID);
            activeRepository.save(activeUserEntity);
        }

        else {

            int intID = Integer.parseInt(this.employeeInfo.getEmployeeId());
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findByEmployeeId(intID);
            EmployeeEntity employeeEnt = employeeEntity.get();

            ActiveUserEntity newActive = new ActiveUserEntity();
            newActive.setSessionKey(sessionID);
            newActive.setEmployeeId(ID);
            newActive.setName(employeeEnt.getFirstName() + " " + employeeEnt.getLastName());
            newActive.setClassification(employeeEnt.getClassification());

            activeRepository.save(newActive);
        }
    }

    @Autowired
    private EmployeeRepository employeeRepository;
    private ActiveUserRepository activeRepository;
}