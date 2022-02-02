package com.revature.daos;

import com.revature.models.Administrator;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Person;

import java.util.List;

public interface AdministratorDAO
{
    public boolean createCustomer (Customer c);
    List<Customer> getAllCustomer();
    public boolean deleteCustomer(Customer c);

    public boolean createEmployee (Employee e);
    List<Employee> getAllEmployee();
    public boolean deleteEmployee(Employee e);

    public boolean Depositc(Customer cu);

    public boolean Deposits(Customer cu);

    public boolean Withdrawc(Customer cu);

    public boolean Withdraws(Customer cu);
}
