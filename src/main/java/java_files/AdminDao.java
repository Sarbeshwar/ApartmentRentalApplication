package java_files;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<User> getUsers()
	{
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}
	
	@Transactional
	public void deleteUser(String number)
	{
		User user = this.hibernateTemplate.load(User.class,number);
		this.hibernateTemplate.delete(user);
	}
	
	@Transactional
	public User getUser(String number)
	{
		
		User user = this.hibernateTemplate.load(User.class,number);
		System.out.println(user);
		return user;
	}
	
	@Transactional
	public void editUser(User user)
	{
		this.hibernateTemplate.update(user);
	}
	


	public List<properties> getProperties()
	{
		List<properties> properties = this.hibernateTemplate.loadAll(properties.class);
		return properties;
	}
	
	@Transactional
	public void deleteProperty(String id)
	{
		properties property = this.hibernateTemplate.load(properties.class,id);
		this.hibernateTemplate.delete(property);
	}
	
	@Transactional
	public properties getProperty(String id)
	{
		
		properties property = this.hibernateTemplate.load(properties.class,id);
		System.out.println(property);
		return property;
	}
	
	@Transactional
	public void editProperty(properties property)
	{
		this.hibernateTemplate.update(property);
	}
	
}
