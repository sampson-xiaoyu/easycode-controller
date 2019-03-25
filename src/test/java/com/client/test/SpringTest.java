package com.client.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:/spring/*.xml"}) 
public class SpringTest {
	

	@Test
	public void testUpdateDate(){

	}
	
	@Test
	public void testQuery(){

	}
}
