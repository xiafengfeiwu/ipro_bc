package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pro.dao.SystemMenuMapper;
import com.pro.entity.SystemMenuExample;
import com.pro.entity.SystemMenuExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@WebAppConfiguration
public class Test_SystemMenuServiceImpl {

	@Autowired
	private SystemMenuMapper mapper;

	@Test
	public void testCountByExample() {
		SystemMenuExample example = new SystemMenuExample();
		Criteria ct = example.createCriteria();
		ct.andParentMenuIdIsNull();

		System.out.println(mapper.countByExample(example));

		SystemMenuExample example2 = new SystemMenuExample();

		Criteria ct2 = example2.createCriteria();
		ct2.andParentMenuIdEqualTo("5808e049d8c6f5724ffe9da8");
		ct2.andMenuAddressIsNotNull();
		ct2.andMenuLevelEqualTo("level2");

		Criteria ct3 = example2.or();
		ct3.andMenuIdEqualTo("5808e049d8c6f5724ffe9da7");

		System.out.println(mapper.countByExample(example2));
	}

	@Test
	public void testSelectByExample() {
		SystemMenuExample example = new SystemMenuExample();
		Criteria ct = example.createCriteria();
		ct.andParentMenuIdIsNull();

		// example.setOrderByClause("menu_name asc");
		example.setOrderByClause("menu_name desc");

	}

}
