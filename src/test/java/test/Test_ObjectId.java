package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pro.util.ObjectId;


public class Test_ObjectId {

	@Test
	public void test() {
		for(int i =0;i<3;i++){
			String id = ObjectId.getId();
			System.out.println(id);
			assertTrue(ObjectId.isValid(id));
			System.out.println(ObjectId.getInitDate(id));
		}
	}

}
