package java_files;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
//		Session session=sessionFactory.openSession();
//		String hql="from User";
////		Query<User> query=session.createQuery("from User",User.class);
//		
//		List<User> users=session.createQuery(hql).list();
//		if(users.size()>0)
//		{
//			System.out.println("List Rendering");
//			System.out.println(users.toString());
//		}
//		else
//		{
//			System.out.println("List Not Rendered");
////		}
//		return users;
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
}
