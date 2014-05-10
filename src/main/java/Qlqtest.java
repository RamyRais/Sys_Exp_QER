import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Qlqtest {

	
	@BeforeClass
	  public static void testSetup() {
	  }

	  @AfterClass
	  public static void testCleanup() {
	    // Teardown for data used by the unit tests
	  }
	  
	@Test
	public void test() {
		//int x = Integer.parseInt("FF",16);
		//x = x > 127 ? x - 256 : x ;
		Date d = new Date(2014, 4, 8, 8, 50, 1);
		int n = d.getHours()*3600 + d.getMinutes()*60 + d.getSeconds();
		assertEquals(1, n);
	}
	
	public void setUp() throws Exception {
		
	}

}
