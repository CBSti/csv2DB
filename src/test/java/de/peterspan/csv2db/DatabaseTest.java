package de.peterspan.csv2db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.peterspan.csv2db.domain.LocationDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "./app-config.xml" })
public class DatabaseTest {

	@Autowired 
	private ApplicationContext applicationContext;
	
	@Autowired
	DataSource dataSource;
	
	@Resource
	LocationDAOImpl locationDao;
	
	@Resource
	SessionFactory sessionFactory;
	
	@Test
    public void testCreateData() {
		System.out.println("Hello World");
		System.out.println("LocationDAOImpl "+locationDao);
		System.out.println("SessionFactory: "+sessionFactory);
		System.out.println("App COntext "+applicationContext);
		System.out.println("dataSource "+dataSource);
		
		try {
			Connection con = dataSource.getConnection();
			System.out.println("Connection "+con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Session session = sessionFactory.openSession();
		System.out.println("Session: "+session);
//		if(sessionFactory.getCurrentSession() == null){
//			session = sessionFactory.openSession();
//		}
		
		
		locationDao.create(session, 1.0, 2.0, "ABC-2", 1);
//		
		int count = locationDao.count(session);
//		
		System.out.println("Count "+count);
		
    }
}
