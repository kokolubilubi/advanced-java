package com.caveofprogramming.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class App 
{
    public static void main(String[] args )
    {
    	var props = Profile.getProperties("dp");
    	
    	
        var db = Database.instance();
        
        try {
			db.connect(props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot connect to database.");
		}
        
        System.out.println("Connected");
        
        UserDao userDao = new UserDaoImpl();
        //userDao.save(new User("Mars"));
        //userDao.save(new User("Neptune"));
        
        var users = userDao.getAll();
        
        users.forEach(System.out::println);
        
        var userOpt = userDao.findById(2);
        
        
        if(userOpt.isPresent()) {
        	
        	User user = userOpt.get();
        	System.out.println("Retrieved: " + userOpt.get());
        	user.setName("Snoopy");
        	
        	userDao.update(user);
        }
        else {
        	System.out.println("No user retrieved!");
        }
        
        userDao.delete(new User(3, null));
        
        try {
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot close database connection.");
		}
        	
    }
}






