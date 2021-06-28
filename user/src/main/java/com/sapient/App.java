package com.sapient;

import com.sapient.contracts.IUser;
import com.sapient.services.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IUser user = new UserService();
        user.createUser("aarsh@gmail.com", "aarsh", "aarsh");
    }
}
