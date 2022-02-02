package com.revature;
import com.revature.daos.AdministratorDAO;
import com.revature.daos.CustomerDAO;
import com.revature.daos.AdministratorImp;
import com.revature.models.Customer;
import com.revature.models.Type;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BankDriver
{
    public static void main (String [] args)
    {
        try
        {
           Connection c = ConnectionUtil.getConnection();
            System.out.println(c.getMetaData().getDriverName());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        AdministratorDAO AdministratorDao = new AdministratorImp();
        Customer cv = new Customer(Type.Customer, "Cindy","Vortex","Cindy123@gmail", 010110101, true, "Professor",
                92000.00,"both", null, null, null,0.00, 0.00);
        boolean success = AdministratorDao.createCustomer(cv);
        System.out.println(success);





    }



}
