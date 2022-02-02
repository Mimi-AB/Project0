package com.revature.daos;

import com.revature.models.Customer;
import com.revature.models.Type;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImp implements EmployeeDAO
{
    @Override
    public boolean updateCustomer(Customer cu)
    {
        String sql = "update account set type = ?, first = ?, last = ?, email = ?, username = ?, password = ? where taxID = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql))
        {

            ps.setInt(1, cu.getType().ordinal());
            ps.setString(2, cu.getfName());
            ps.setString(3, cu.getlName());
            ps.setString(4, cu.getEmail());
            ps.setString(5, cu.getUsername());
            ps.setString(6, cu.getPassword());
            ps.setLong(7, cu.getTaxID());

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public List<Customer> getAllCustomer()
    {
        String sql = "select * from account";
        List<Customer> customers = new ArrayList<>();
        try (Connection c = ConnectionUtil.getConnection();
             Statement s = c.createStatement();)
        {
            ResultSet rs = s.executeQuery(sql);

            while (rs.next())
            {
                Customer customer = new Customer();
                int typeOrdinal = rs.getInt("type");
                Type[] types = Type.values();
                customer.setType(types[typeOrdinal]);
                customer.setfName(rs.getString("first"));
                customer.setlName(rs.getString("last"));
                customer.setEmail(rs.getString("email"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerById(long taxID)
    {
        String sql = "select * from account where taxID = ? ";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql))
        {

            ps.setLong(1,taxID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Customer customer = new Customer();
                int typeOrdinal = rs.getInt("type");
                Type[] types = Type.values();
                customer.setType(types[typeOrdinal]);
                customer.setfName(rs.getString("first"));
                customer.setlName(rs.getString("last"));
                customer.setEmail(rs.getString("email"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                return customer;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
