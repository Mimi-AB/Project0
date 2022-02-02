package com.revature.daos;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerImp implements CustomerDAO
{
    @Override
    public boolean Register(Customer cu)
    {
        String sql = "insert into account (type, first, last, email, taxID, employed, occupation, annIncome, accType) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, null, null, null, null, null)";

        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setInt(1, cu.getType().ordinal());
            ps.setString(2, cu.getfName());
            ps.setString(3, cu.getlName());
            ps.setString(4, cu.getEmail());
            ps.setLong(5, cu.getTaxID());
            ps.setBoolean(6, cu.isEmployed());
            ps.setString(7, cu.getOccupation());
            ps.setDouble(8, cu.getAnnIncome());
            ps.setString(9, cu.getAccType());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean accSetup(Customer cu)
    {
        String sql = "update account set accNum = ?, username = ?, password = ?, balance = ?, savings = ?, where taxID = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setString(1, cu.getAccNum());
            ps.setString(2, cu.getUsername());
            ps.setString(3, cu.getPassword());
            ps.setDouble(4, cu.getBalance());
            ps.setDouble(5, cu.getSavings());
            ps.setLong(6, cu.getTaxID());

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
    public boolean Depositc(Customer cu)
    {
        String sql = "update statement set balance = (balance + ?) where username = ? and password =?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getBalance());
            ps.setString(2, cu.getUsername());
            ps.setString(3, cu.getPassword());


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
        String sql = "update statement set savings = (savings + ?) where username = ? and password =?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getSavings());
            ps.setString(2, cu.getUsername());
            ps.setString(3, cu.getPassword());


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
        String sql = "update statement set balance = (balance - ?) where username = ? and password =?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getBalance());
            ps.setString(2, cu.getUsername());
            ps.setString(3, cu.getPassword());


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
        String sql = "update statement set savings = (savings - ?) where username = ? and password =?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);)
        {
            ps.setDouble(1, cu.getSavings());
            ps.setString(2, cu.getUsername());
            ps.setString(3, cu.getPassword());


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
