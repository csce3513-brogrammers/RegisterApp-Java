package edu.uark.registerapp.models.enums;

public class EmployeeType {
    private int classification;
    //Getters and Setters

    private String displayLabel;
    //Getters and Setters

    public static EmployeeType[] allEmployeeTypes() {
        final EmployeeClassification[] employeeClassifications = EmployeeClassification.values();
        final EmployeeType[] employeeTypes = new EmployeeType[employeeClassifications.length];

        for(int i = 0; i < employeeClassifications.length; i++) {
            employeeTypes[i] = new EmployeeType(employeeClassifications[i]);
        }

        return employeeTypes;
    }

    //Default Constructor

    public EmployeeType(final EmployeeClassification employeeClassification) {
        this(employeeClassification.getClassification(), employeeClassification.getDisplayLabel());
    }

    public EmployeeType(final int classification, final String displayLabel) {
        this.displayLabel = displayLabel;
        this.classification = classification;
    }
}