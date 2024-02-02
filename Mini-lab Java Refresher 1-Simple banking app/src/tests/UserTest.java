package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
	
	public static void main(String[] args) {
//		User testUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
//		
//		System.out.println(testUser);
		testUserConstructor();
	}
	
	public static void testUserConstructor() {
		// move all the test code of User Constructor from the main() to this method
		boolean passed = true;
		String test_username = "mike";
		String test_password = "my_passwd";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";
		User testUser  = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);
		System.out.println("Starting the assertions of the test method: testUserConstructor");
		
		assert testUser.getUsername() == test_username;
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;
		
	
		if (testUser.getUsername() == test_username)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		else 
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getPassword() == test_password)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getFirst_name() == test_first_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getLast_name() == test_last_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getMobile_number() == test_mobile_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
//		if (passed)
//			System.out.println("All TC's passed");
//		
//		if (testUser.getFirst_name() != test_first_name) {
//			System.out.println("TC3 failed: first_name did not match");
//		}
//		
//		if (testUser.getLast_name() != test_last_name) {
//			System.out.println("TC4 failed: last_name did not match");
//		}
//		
//		if (testUser.getMobile_number() != test_mobile_number) {
//			System.out.println("TC5 failed: mobile_number did not match");
//		}
		

	}

	
}
