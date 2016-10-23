package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pro.entity.TenantUser;
import com.pro.service.TenantUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@WebAppConfiguration
public class Test_TenantUserServiceImpl {

	@Autowired
	private TenantUserService service;

	@Test
	public void testGetByUserName() {
		System.out.println(service.getByUserName("sizhongxia"));
	}
	@Test
	public void testUpdate() {
		TenantUser user = service.getByUserName("sizhongxia");
		service.update(user);
	}
	@Test
	public void testResetUserPassword() {
		service.resetUserPassword("580c40ecd8c61e80a5393ad1", "123456");
	}

}
