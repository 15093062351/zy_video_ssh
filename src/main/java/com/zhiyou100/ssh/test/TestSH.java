package com.zhiyou100.ssh.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.ssh.service.AdminCourseService;
import com.zhiyou100.ssh.service.AdminSpeakerService;
import com.zhiyou100.ssh.service.AdminVideoService;


/**  
* @ClassName: TestSH  
* @Description: TODO
* @author lyb  
* @date 2017年9月6日  下午4:13:05
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestSH {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	AdminVideoService avs;
	@Autowired
	AdminSpeakerService ass;
	@Autowired
	AdminCourseService acs;
	
	@Test
	public void test01(){
		
		
		
		
		
		
	}
	
}
