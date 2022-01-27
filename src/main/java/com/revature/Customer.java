package com.revature;

import java.io.Serializable;
import java.util.Scanner;

public class Customer extends Person implements Serializable
{
    private long taxID;
    private String annIncome;
    private boolean employed;
    private String occupation;
    private String accType;
    private double balance;
    private long accNum;
    Scanner sc = new Scanner(System.in);

    public Customer ()
    {

    }

    public Customer(String fName, String lName, String username, String password, String email, long taxID, String accType, String occupation)
    {
        super(fName, lName, username, password, email);
        this.taxID = taxID;
        this.accType = accType;
        this.occupation = occupation;
        this.employed = employed;
        this.annIncome = annIncome;
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

    public long getAccNum() { return accNum; }

    public void setAccNum(long accNum) { this.accNum = accNum; }

    public String getAnnIncome()
    {
        return annIncome;
    }

    public void setAnnIncome(String annIncome)
    {
        this.annIncome = annIncome;
    }

    public boolean isEmployed()
    {
        return employed;
    }

    public void setEmployed(boolean employed)
    {
        this.employed = employed;
    }

    public void Register()
    {
        System.out.println("Hello! Thank you for choosing MightBeAScam Bank!");
        System.out.println("Enter your First Name:  ");
        String fName = sc.next();

        System.out.println("Enter your Last Name:  ");
        String lName = sc.next();

        System.out.println("Enter your Email Address:  ");
        String email = sc.next();

        System.out.println("Enter your Social Security Number:  ");
        long taxID = Long.parseLong(sc.next());
        sc.next();

        System.out.println("Are you employed? (yes/no)  ");
        sc.next();
        String answer = sc.next();
         switch(answer)
         {
             case "yes":
             case "YES":
             case "Yes":
             case "y":
             case "Y":
                 employed = true;

             break;
             case "no":
             case "NO":
             case "No":
             case "n":
             case "N":
                 employed = false;
             break;
             default:
                 System.out.println("Unrecognized answer, try again");

         }


        System.out.println("What is your current job tile?  ");
        String occupation = sc.next();

        System.out.println("What type of account would you like to open? (Checking/Savings/Both)   ");
        String accType = sc.next();
        switch(accType)
        {
            case "Checking":
            case "checking":
            case "Savings":
            case "savings":
            case "Both":
            case "both":
                System.out.println("Thank you, If you are approved the administrator will send you an email with your account details.");
                break;
            default:
                System.out.println("Unrecognized answer, try again");
        }

    }

    public void Withdraw()
    {
        System.out.println();
    }
    public void Deposit()
    {
        System.out.println();
    }
    public void Transfer()
    {
        System.out.println();
    }
}