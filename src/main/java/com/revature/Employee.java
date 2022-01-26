package com.revature;

import java.io.Serializable;

public class Employee extends Person implements Serializable
{
    private int empID;
    private String jobTitle;


    public Employee()
    {

    }

    public Employee(String fName, String lName, String username, String password, String email, int empID, String jobTitle)
    {
        super(fName, lName, username, password, email);
        this.empID = empID;
        this.jobTitle = jobTitle;
    }

    public int getEmpID()
    {
        return empID;
    }

    public void setEmpID(int empID)
    {
        this.empID = empID;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
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
