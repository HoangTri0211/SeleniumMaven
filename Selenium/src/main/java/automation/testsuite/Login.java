package automation.testsuite;

import org.junit.Test;
import org.testng.annotations.*;

public class Login {
	@BeforeMethod
	public void init()
	{
		System.out.println("This is before method");
		
	}
	
	@Test
	public void testcase()
	{
		System.out.println("This is test case 1");
	}
	
	

}
