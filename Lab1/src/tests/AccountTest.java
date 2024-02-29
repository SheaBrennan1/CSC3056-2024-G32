package tests;

import model.Account;
import utils.TestUtils;

import java.util.Date;

public class AccountTest {

    public static void testConstructor() {
        Date accountOpeningDate = new Date();
        Account account = new Account("123456789", "user@example.com", "Savings", accountOpeningDate);
        assert account.getAccount_number().equals("123456789");
        assert account.getUsername_of_account_holder().equals("user@example.com");
        assert account.getAccount_type().equals("Savings");
        assert account.getAccount_opening_rate().equals(accountOpeningDate);

        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testConstructor passed." + TestUtils.TEXT_COLOR_RESET);
    }
    
    public static void testSetters() {
        Date accountOpeningDate = new Date();
        Account account = new Account("123456789", "user@example.com", "Savings", accountOpeningDate);
        
        account.setAccount_number("987654321");
        assert account.getAccount_number().equals("987654321");
        
        account.setUsername_of_account_holder("newuser@example.com");
        assert account.getUsername_of_account_holder().equals("newuser@example.com");
        
        account.setAccount_type("Standard");
        assert account.getAccount_type().equals("Standard");
        
        Date newAccountOpeningDate = new Date();
        account.setAccount_opening_rate(newAccountOpeningDate);
        assert account.getAccount_opening_rate().equals(newAccountOpeningDate);

        System.out.println(TestUtils.TEXT_COLOR_GREEN +"testSetters passed." + TestUtils.TEXT_COLOR_RESET);
    }
    
    public static void main(String[] args) {
        testConstructor();
        testSetters();
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "All AccountTest tests passed." + TestUtils.TEXT_COLOR_RESET);
    }
    
}
