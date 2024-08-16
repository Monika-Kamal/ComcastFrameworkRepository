package pack2;

import org.testng.annotations.Test;

public class orgTest {

	@Test
	public void createOrgTest() {
		String Browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println(Browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println("execute createOrgTest ");
	}
	@Test
	public void modifyOrgTest() {
		System.out.println("execute modifyOrgTest ");
	}
}
