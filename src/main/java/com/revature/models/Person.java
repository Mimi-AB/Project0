package com.revature.models;

import java.io.Serializable;

public class Person implements Serializable
{
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String email;
    private Type type;


    public Person ()
    {

    }

    public Person(Type type, String fName, String lName, String username, String password, String email)
    {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;

    }


    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    @Override
    public String toString()
    {
        return "Person {Type: " + type + " Name: " + fName + " " + lName +
                " Email: " + email + " Username: " + username + " Password: " + password +"}";
    }

}