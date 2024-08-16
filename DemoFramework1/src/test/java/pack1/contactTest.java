package pack1;

import org.testng.annotations.Test;

public class contactTest {
	@Test
	public void createContactTest() {
		String Browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println(Browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println("execute createContactTest ");
	}
	@Test
	public void modifyContactTest() {
		System.out.println("execute modifyContactTest ");
	}
	@Test
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest ");
	}
}
