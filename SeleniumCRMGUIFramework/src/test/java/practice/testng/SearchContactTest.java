package practice.testng;


/**
 * test class for contact module
 * @author Monika
 */
import org.testng.annotations.Test;

import com.comcas.crm.objectrepository.LoginPage1;
import com.crm.comcast.baseUtility.BaseClass;

public class SearchContactTest extends BaseClass {
	/**
	 * scenario 1: login9)==> navigate to contact==> create contact==>verify
	 */

	@Test
	public void dearchContactTest() {
		/* step1: login to app */
		LoginPage1 lp = new LoginPage1(driver);
		lp.LoginToApp("admin", "admin");
	}
}
