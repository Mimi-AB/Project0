package com.revature;

import java.io.Serializable;

public class Customer extends Person implements Serializable
{
    private long taxID;
    private String occupation;
    private String accType;
    private double balance;

    public Customer ()
    {

    }

    public Customer(String fName, String lName, String username, String password, String email, long taxID, String accType, String occupation)
    {
        super(fName, lName, username, password, email);
        this.taxID = taxID;
        this.accType = accType;
        this.occupation = occupation;
    }

    public long getTaxID()
    {
        return taxID;
    }

    public void setTaxID(long taxID)
    {
        this.taxID = taxID;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public String getAccType()
    {
        return accType;
    }

    public void setAccType(String accType)
    {
        this.accType = accType;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void Register()
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
}
