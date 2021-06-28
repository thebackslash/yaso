package com.sapient.contracts;

import java.util.List;

import com.sapient.entities.User;

/**
 * @author Priyadarshan Singh
 * 
 */
public interface IUser {
    
    public boolean createUser(String email, String password, String username);

    public User getUser(String email);

    public User getUser(int id);

    public List<User> getUsers();

    public boolean validateCredentials(String email, String password);

}
