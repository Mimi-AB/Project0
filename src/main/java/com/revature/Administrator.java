//Think about creating an interface to implement all the methods from customer + employee to put into Admin
package com.revature;

public class Administrator extends Person
{
    private int adminID;

    public Administrator()
    {

    }

    public Administrator(String fName, String lName, String username, String password, String email, int adminID)
    {
        super(fName, lName, username, password, email);
        this.adminID = adminID;
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
