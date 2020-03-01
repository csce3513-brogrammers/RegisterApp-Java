package edu.uark.registerapp.models.api;

public class EmployeeSignIn {

    public String employeeId;
    public String password;

    public EmployeeSignIn(final String Id, final String pass) {

        this.employeeId = Id;
        this.password = pass;
    }

    public String getEmployeeId() {

        return employeeId;
    }

    public String getPassword() {

        return password;
    }

    public void setEmployeeId(final String Id) {

        this.employeeId = Id;
    }

    public void setPassword(final String pass) {

        this.password = pass;
    }
}