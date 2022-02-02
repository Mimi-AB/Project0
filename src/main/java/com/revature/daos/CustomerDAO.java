package com.revature.daos;

import com.revature.models.Customer;
import com.revature.models.Person;

import java.util.List;
import java.util.Scanner;

public interface CustomerDAO
{

    public boolean Register(Customer cu);

    public boolean accSetup(Customer cu);

    public boolean Depositc(Customer cu);

    public boolean Deposits(Customer cu);

    public boolean Withdrawc(Customer cu);

    public boolean Withdraws(Customer cu);

}
