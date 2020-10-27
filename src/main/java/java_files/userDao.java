package java_files;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service
public class userDao 
{
	@Autowired
	public SessionFactory sessionFactory;
	
	
	@Transactional
	public List<User> getUsers()
	{
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	
	
	@Transactional
	public void createUser(User user) 
	{
		Session session=sessionFactory.getCurrentSession();
//		session.beginTransaction();
		session.save(user);
//		session.getTransaction().commit();
	}
	
	//TenantDao
	
	@Transactional
	public List<properties> getProperties(){
		
		return sessionFactory.getCurrentSession().createQuery("from properties").list();
	}
	
	@Transactional
	public List<properties> search(String keyword){
		return sessionFactory.getCurrentSession().createQuery("from properties where (no_of_rooms LIKE '%"+keyword+"%' OR furnished_status LIKE '%"+keyword+"%' OR lister_name LIKE '%"+keyword+"%' OR type_of_accommodation LIKE '%"+keyword+"%' OR location LIKE '%"+keyword+"%')").list();
	}


    @Transactional
	public properties find(String id) {
		
		return (properties)sessionFactory.getCurrentSession().createCriteria(properties.class).add(Restrictions.eq("id",id)).uniqueResult();
	}





    
	
	
	
}
