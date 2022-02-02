//Think about creating an interface to implement all the methods from customer + employee to put into Admin
package com.revature.models;

import java.io.Serializable;

public class Administrator extends Person implements Serializable
{
    private int adminID;

    public Administrator()
    {

    }

    public Administrator(Type type, String fName, String lName, String username, String password, String email, int adminID)
    {
        super(type, fName, lName, username, password, email);
        this.adminID = adminID;
    }

    public int getAdminID()
    {
        return adminID;
    }

    public void setAdminID(int adminID)
    {
        this.adminID = adminID;
    }

    public void viewEmploy()
    {

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

    public void Withdraw()
    {

    }

    public void Deposit()
    {

    }

    public void Transfer()
    {

    }

    public void Cancel()
    {

    }

}
