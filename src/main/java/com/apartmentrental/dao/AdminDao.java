package com.apartmentrental.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.apartmentrental.entity.User;
import com.apartmentrental.entity.Admin;
import com.apartmentrental.entity.Properties;

@Component
public class AdminDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public List<User> getUsers()
	{
		return this.hibernateTemplate.loadAll(User.class);
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
		
		return this.hibernateTemplate.load(User.class,number);
	}
	
	@Transactional
	public void editUser(User user)
	{
		this.hibernateTemplate.update(user);
	}
	


	public List<Properties> getProperties()
	{
		return this.hibernateTemplate.loadAll(Properties.class);
	}
	
	@Transactional
	public void deleteProperty(String id)
	{
		Properties property = this.hibernateTemplate.load(Properties.class,id);
		this.hibernateTemplate.delete(property);
	}
	
	@Transactional
	public Properties getProperty(String id)
	{
		
		return this.hibernateTemplate.load(Properties.class,id);
	}
	
	@Transactional
	public void editProperty(Properties property)
	{
		this.hibernateTemplate.update(property);
	}
	
	@Transactional
	public boolean validate(String username, String password) 
	{
		Admin admin=null;
		Session session =sessionFactory.getCurrentSession();
		admin=(Admin) session.createQuery("From Admin A WHERE A.username = :username").setParameter("username", username).uniqueResult();
		if(admin != null && admin.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
