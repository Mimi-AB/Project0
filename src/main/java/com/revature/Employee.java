package com.revature;

import java.io.Serializable;

public class Employee extends Person implements Serializable
{
    private int empID;
    private String jobTitle;
    private String AccNum;

    public Employee()
    {

    }

    public Employee(String fName, String lName, String username, String password, String email, int empID, String jobTitle)
    {
        super(fName, lName, username, password, email);
        this.empID = empID;
        this.jobTitle = jobTitle;
    }

    public void AppDny()
    {

    }

    public void viewAcc()
    {

    }
    public void viewAccPI()
    {

    }
}
