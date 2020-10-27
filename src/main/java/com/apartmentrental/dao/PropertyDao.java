package com.apartmentrental.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartmentrental.entity.Properties;

@Repository
@Service
public class PropertyDao {
	@Autowired
	public SessionFactory sessionFactory;
	
	Logger logger=Logger.getLogger(PropertyDao.class);

	@Transactional
	public void createProperty(Properties property) {
		Session session = sessionFactory.getCurrentSession();
		session.save(property);
	}

	@Transactional
	public List<Properties> getProperties(String property) {
		Session session = sessionFactory.getCurrentSession();
		Query<Properties> hql = session.createQuery("FROM Properties WHERE lister_name = :property", Properties.class);
		hql.setParameter("property", property);
		List<Properties> properties = hql.getResultList();
		if (!properties.isEmpty()) {
			logger.info("List Rendering");
		} else {
			logger.info("List Not Rendering");
		}
		return properties;
	}

	@Transactional
	public void deleteProperty(String id) {
		Session session = sessionFactory.getCurrentSession();
		Properties p = session.load(Properties.class, id);     // exception with entity not found//
		if (p != null) {
			session.delete(p);
		} else {
			logger.info("Not Deleting");
		}
	}

	@Transactional
	public Properties getPropertyById(String id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Properties where id=:id";
		session.createQuery(hql).setParameter("id", id);
		return session.get(Properties.class, id);
		
	}

	@Transactional
	public Properties updateProperty(Properties properties) {
		Session session = sessionFactory.getCurrentSession();
		session.update(properties);
		return properties;
	}
}
