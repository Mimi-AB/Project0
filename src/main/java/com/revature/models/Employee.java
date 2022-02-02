package com.revature.models;

import com.revature.daos.EmployeeDAO;
import com.revature.util.ConnectionUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee extends Person implements Serializable
{
    private int empID;


    public Employee()
    {

    }

    public Employee(Type type, String fName, String lName, String username, String password, String email, int empID)
    {
        super(type, fName, lName, username, password, email);
        this.empID = empID;
    }

    public int getEmpID()
    {
        return empID;
    }

    public void setEmpID(int empID)
    {
        this.empID = empID;
    }


    public void AppDny()
    {
        String sql = "delete from account where taxID = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {

        } catch (SQLException n){
            n.printStackTrace();
        }

    }

    public void viewAcc()
    {
        String sql = "select * from account";
        System.out.println(sql);

    }
}