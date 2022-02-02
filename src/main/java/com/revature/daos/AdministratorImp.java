package com.revature.daos;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Person;
import com.revature.models.Type;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorImp implements AdministratorDAO
{

    @Override
    public boolean createEmployee(Employee e)
    {
        String sql = "insert into employee (empID, type, first, last, email, username, password ) values (?, ?, ?, ?, ?, ?,?)";
        try
        {
            Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, e.getEmpID());
            ps.setInt(2,e.getType().ordinal());
            ps.setString(3, e.getfName());
            ps.setString(4, e.getlName());
            ps.setString(5, e.getEmail());
            ps.setString(6, e.getUsername());
            ps.setString(7, e.getPassword());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee()
    {
        String sql = "select * from Account";
        List<Employee> employees = new ArrayList<>();
        try (Connection c = ConnectionUtil.getConnection();
             Statement s = c.createStatement();) {
            ResultSet rs = s.executeQuery(sql);

            while (rs.next())
            {
                Employee employee = new Employee();
                int typeOrdinal = rs.getInt("type");
                Type[] types = Type.values();
                employee.setType(types[typeOrdinal]);
                employee.setfName(rs.getString("first"));
                employee.setlName(rs.getString("last"));
                employee.setEmail(rs.getString("email"));
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Employee e)
    {
        String sql = "delete from employee where id = ?;";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, e.getEmpID());
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==1){
                return true;
            }
        } catch (SQLException l) {
            l.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean createCustomer(Customer cu)
    {
        String sql = "insert into account (type, first, last, email, taxID, employed, occupation, annIncome, accType, accNum, username, password, balance, savings) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setInt(1,cu.getType().ordinal());
            ps.setString(2, cu.getfName());
            ps.setString(3, cu.getlName());
            ps.setString(4, cu.getEmail());
            ps.setLong(5, cu.getTaxID());
            ps.setBoolean(6, cu.isEmployed());
            ps.setString(7, cu.getOccupation());
            ps.setDouble(8, cu.getAnnIncome());
            ps.setString(9, cu.getAccType());
            ps.setString(10, cu.getAccNum());
            ps.setString(11, cu.getUsername());
            ps.setString(12, cu.getPassword());
            ps.setDouble(13, cu.getBalance());
            ps.setDouble(14, cu.getSavings());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomer()
    {
        String sql = "select * from Account";
        List<Customer> customers = new ArrayList<>();
        try (Connection c = ConnectionUtil.getConnection();
             Statement s = c.createStatement();) {
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
    public boolean deleteCustomer(Customer cu)
    {
        String sql = "delete from account where id = ?;";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1, cu.getTaxID());
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
    public boolean Depositc(Customer cu)
    {
        String sql = "update statement set balance = (balance + ?) where accNum = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getBalance());
            ps.setString(2, cu.getAccNum());


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Deposits(Customer cu)
    {
        String sql = "update statement set savings = (savings + ?) where accNum = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getSavings());
            ps.setString(2, cu.getAccNum());


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Withdrawc(Customer cu)
    {
        String sql = "update statement set balance = (balance - ?) where accNum = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getBalance());
            ps.setString(2, cu.getAccNum());


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean Withdraws(Customer cu)
    {
        String sql = "update statement set savings = (savings - ?) where accNum = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getSavings());
            ps.setString(2, cu.getAccNum());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException f){
            f.printStackTrace();
        }
        return false;
    }

}


