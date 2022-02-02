package com.revature.models;

import java.io.Serializable;
import java.util.Scanner;

public class Customer extends Person implements Serializable
{
    private long taxID;
    private double annIncome;
    private boolean employed;
    private String occupation;
    private String accType;
    private double balance;
    private String accNum;
    private double savings;
    Scanner sc = new Scanner(System.in);


    //Constructors

    public Customer ()
    {

    }
    public Customer(Type type, String fName, String lName, String email, long taxID, boolean employed, String occupation, double annIncome, String accType, String accNum, String username, String password, double balance, double savings)
    {
        super(type, fName, lName, username, password, email);
        this.taxID = taxID;
        this.accType = accType;
        this.occupation = occupation;
        this.employed = employed;
        this.annIncome = annIncome;
        this.balance = balance;
        this.savings = savings;
        this.accNum = accNum;
    }


    //Getters and Setters

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

    public String getAccNum() { return accNum; }

    public void setAccNum(String accNum) { this.accNum = accNum; }

    public double getAnnIncome() {return annIncome;}

    public void setAnnIncome(double annIncome) {this.annIncome = annIncome;}

    public boolean isEmployed() { return employed; }

    public void setEmployed(boolean employed) { this.employed = employed; }

    public double getSavings() { return savings; }

    public void setSavings(double savings) { this.savings = savings; }


    //Methods

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

        System.out.println("What is your annual income?  ");
        double annIncome = Double.parseDouble(sc.next());

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
    public void accSetup()
    {
        System.out.println("Enter Account Number: ");
        String accNum = sc.next();
        System.out.println("Set Username: ");
        String username = sc.next();
        System.out.println("Set Password: ");
        String password = sc.next();
        System.out.println("Please deposit money into your account to activate.");
    }
    public void Deposit()
    {
        System.out.println("Enter the amount that you would like to deposit: ");
        double depositAmt = Double.parseDouble(sc.next());
        //String sql = "insert into BankStatement (";
        balance = balance + depositAmt;
        System.out.println("Your current balance is: $" + balance);

    }
    public void Withdraw()
    {
        System.out.println("Enter the amount that you would like to withdraw: ");
        double withdrawAmt = Double.parseDouble(sc.next());
        if (withdrawAmt <= balance)
        {
            balance = balance - withdrawAmt;
            System.out.println("Your current balance is: $" + balance);
        } else
        {
            System.out.println("You only have $" + balance + " in your account." );
            System.out.println("Transaction Failed :(");
        }
    }

    public void Transfer()
    {
        System.out.println("Which account do you want to transfer funds to?  ");
        String whichAcc = sc.next();
        if(whichAcc.equals("savings") || whichAcc.equals("Savings"))
        {
            System.out.println("How much would you like to transfer? ");
            double transferAmt = Double.parseDouble(sc.next());
            if(balance >= transferAmt)
            {
                balance = balance - transferAmt;
                savings = savings + transferAmt;
                System.out.println("Your current balance is: $"+ String.format("%.2f" , balance));
                System.out.println("Your current savings are: $"+ String.format("%.2f" , savings));
            } else {
                System.out.println("You only have $"+ balance + " in your checking account available for transfer");
                System.out.println("Transaction Failed :(");
            }
        }
        else if (whichAcc.equals("checking") || whichAcc.equals("Checking"))
        {
            System.out.println("How much would you like to transfer? ");
            double transferAmt = Double.parseDouble(sc.next());
            if(savings >= transferAmt)
            {
                savings = savings - transferAmt;
                balance = balance + transferAmt;
                System.out.println("Your current balance is: $"+ String.format("%.2f" , balance));
                System.out.println("Your current savings are: $"+ String.format("%.2f" , savings));
            }else {
                System.out.println("You only have $"+ savings + " in your savings available for transfer");
                System.out.println("Transaction Failed :(");
            }


        }


    }
}