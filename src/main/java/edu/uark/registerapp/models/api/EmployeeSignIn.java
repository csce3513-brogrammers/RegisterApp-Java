package edu.uark.registerapp.models.api;

public class EmployeeSignIn {

    private String employeeId;
    private String password;

    public EmployeeSignIn(String Id, String pass) {

        this.employeeId = Id;
        this.password = pass;
    }

    public String getEmployeeId() {

        return employeeId;
    }

    public String getPassword() {

        return password;
    }

    public void setEmployeeId(String Id) {

        this.employeeId = Id;
    }

    public void setPassword(String pass) {

        this.password = pass;
    }
}