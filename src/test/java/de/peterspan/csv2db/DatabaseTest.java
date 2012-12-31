package de.peterspan.csv2db;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.peterspan.csv2db.domain.LocationDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "./app-config.xml" })
public class DatabaseTest {

	@Resource
	LocationDAOImpl locationDao;
	
	@Test
    public void testCreateData() {
		System.out.println("Hello World");
		System.out.println("LocationDAOImpl "+locationDao);
    }
}
