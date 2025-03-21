package com.bhuvan.rest3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	public static int usersCount=5;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		//adding users to the list  
		users.add(new User(1, "John", new Date()));  
		users.add(new User(2, "Robert", new Date()));  
		users.add(new User(3, "Adam", new Date()));  
		users.add(new User(4, "Andrew", new Date()));  
		users.add(new User(5, "Jack", new Date()));  
	}
	
	public List<User> findAll(){
		return users;
	}
	
	//method that add the user in the list   
	public User save(User user)  
	{  
	if(user.getId()==0)  
	{  
	//increments the user id  
	user.setId(++usersCount);  
	}  
	users.add(user);  
	return user;  
	}  
	//method that find a particular user from the list  
	public User findOne(int id)  
	{  
	for(User user:users)  
	{  
	if(user.getId()==id)  
	return user;  
	}  
	return null;  
	}
	
	//method that delete a user
	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();
		
		while(itr.hasNext()) {
			User user = itr.next();
			
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
