package de.peterspan.csv2db;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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
	EntityManagerFactory entityManagerFactory;
	
	@Test
    public void testCreateData() {
		System.out.println("Hello World");
		System.out.println("LocationDAOImpl "+locationDao);
		System.out.println("App COntext "+applicationContext);
		System.out.println("dataSource "+dataSource);
		
//		try {
//			Connection con = dataSource.getConnection();
//			System.out.println("Connection "+con);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Session session = sessionFactory.openSession();
//		System.out.println("Session: "+session);
////		if(sessionFactory.getCurrentSession() == null){
////			session = sessionFactory.openSession();
////		}
//		
//		
//		locationDao.create(session, 1.0, 2.0, "ABC-2", 1);
////		
//		int count = locationDao.count(session);
////		
//		System.out.println("Count "+count);
		
    }
}
