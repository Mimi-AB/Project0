package com.revature.daos;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Person;

import java.util.List;

public interface EmployeeDAO
{
    public boolean updateCustomer(Customer cu);
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(long taxID);
}
