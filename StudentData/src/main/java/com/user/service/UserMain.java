package com.user.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.user.entity.User;
import com.user.entity.UserAddress;
import com.user.entity.UserDetails;

public class UserMain {
static 	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//public static void Login() {
public static void main(String[] args) {
	

	Configuration cfg = new Configuration();
	cfg.configure("User.cfg.xml");
	SessionFactory snf= cfg.buildSessionFactory();
	Session sn = snf.openSession();
	Transaction transaction=null;
	 try {
         transaction = sn.beginTransaction();

         User user = new User();
         user.setPassword("password");

         UserDetails details = new UserDetails();
         details.setFirstName("John");
         details.setLastName("Doe");

        UserAddress address = new UserAddress();
         address.setCity("City");
         address.setState("State");
         address.setPincode("12345");

        
         if (details.getFirstName() == null) {
             throw new IllegalStateException("First name cannot be null");
         }else {
        	 sn.save(details);
         }

       
         if (address.getCity() == null || address.getState() == null || address.getPincode() == null) {
             throw new IllegalStateException("Address cannot be null");
         }else {
        	 sn.save(address);
         }

         user.setDetails(details);
         user.setAddress(address);

         sn.save(user);

         transaction.commit();
         System.err.println("Registeration successfully");
     } catch (Exception e) {
         if (transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();
     } finally {
         sn.close();
     }
	 
	 
	 // using joins to get user detail-------------
//		String hql = "SELECT u, a, d " +
//	            "FROM User u " +
//	            "INNER JOIN u.address a " +
//	            "INNER JOIN u.details d";
	//Query query = sn.createQuery(hql);
//		List<Object[]> resultList = query.list();
//		for (Object[] result : resultList) {
//			UserDetails userDetails = (UserDetails) result[1];
//		}
}
}
