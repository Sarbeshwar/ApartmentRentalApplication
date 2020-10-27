package com.apartmentrental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartmentrental.entity.User;
import com.apartmentrental.entity.Properties;

import org.hibernate.criterion.Restrictions;

@Repository
@Service
public class UserDao 
{
	@Autowired
	public SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsers()
	{
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	@Transactional
	public void createUser(User user) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(user);

	}
	
	//TenantDao
	
		@SuppressWarnings("unchecked")
		@Transactional
		public List<Properties> getProperties(){
			
			return sessionFactory.getCurrentSession().createQuery("from Properties").list();
		}
		
		@SuppressWarnings("unchecked")
		@Transactional
		public List<Properties> search(String keyword){
			return sessionFactory.getCurrentSession().createQuery("from Properties where (no_of_rooms LIKE '%"+keyword+"%' OR furnished_status LIKE '%"+keyword+"%' OR lister_name LIKE '%"+keyword+"%' OR type_of_accommodation LIKE '%"+keyword+"%' OR location LIKE '%"+keyword+"%')").list();
		}


	    @SuppressWarnings("deprecation")
		@Transactional
		public Properties find(String id) {
			
			return (Properties)sessionFactory.getCurrentSession().createCriteria(Properties.class).add(Restrictions.eq("id",id)).uniqueResult();
		}

	    @Transactional
		public boolean validate(String username, String password) 
		{
	    	User user=null;
			Session session =sessionFactory.getCurrentSession();
			user=(User) session.createQuery("From User U WHERE U.username = :username").setParameter("username", username).uniqueResult();
			if(user != null && user.getPassword().equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
}

