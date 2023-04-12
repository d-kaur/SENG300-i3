/**Johnathan Richardson 30045434
 * Gillian Sharp 30142574
 */


package com.autovend.software.test;

import com.autovend.software.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.util.HashMap;

import static org.junit.Assert.*;


public class LoginLogoutTest {
	
	

	@Before
	public void setUp() {
		
        
        LoginLogout.createAccount("username", "password");
		LoginLogout.createAccount("user", "1234");
		LoginLogout.createAccount("supervisor", "securepassword");
		LoginLogout.removeAccount("username", "password");
	}
	@After
	public void tearDown() {
		LoginLogout.removeAccount("user", "1234");
		LoginLogout.removeAccount("supervisor", "securepassword");
	}
	
	@Test
    public void validLogin1() {
		Boolean actual = LoginLogout.verifyLogin("user", "1234");
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	@Test
    public void validLogin2() {
		Boolean actual = LoginLogout.verifyLogin("supervisor", "securepassword");
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	@Test
	public void invalidLogin1() {
		Boolean actual = LoginLogout.verifyLogin("u", "p");
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	@Test
	public void invalidLogin2() {
		Boolean actual = LoginLogout.verifyLogin("username", "password");
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	/*
     public class AttendantIOTest {

   	private AttendantIO attendantIO;

   	@BeforeEach
   	public void setUp() {
      	  //attendantIO = new AttendantIO();
  	 }

   	@Test
   	public void testLogoutSuccess() {
      	  attendantIO.logout();
      	  Assertions.assertFalse(attendantIO.loggedIn);
   	}
	 
	@Test
   	public void testLogoutNotLoggedIn() {
      	  attendantIO.logout();
          attendantIO.logout(); // Attempt to logout again
          Assertions.assertFalse(attendantIO.loggedIn);
        }

   	@Test
   	public void testLogoutMessage() {
      	  ConsoleOutputCapturer coc = new ConsoleOutputCapturer();
          coc.start();
          attendantIO.logout();
          coc.stop();
          String expectedMessage = "Successfully logged out.";
          String actualMessage = coc.getOutput().trim();
          Assertions.assertEquals(expectedMessage, actualMessage);
         }
	     
	@Test
   	public void testLogoutNotLoggedInMessage() {
      	  ConsoleOutputCapturer coc = new ConsoleOutputCapturer();
      	  coc.start();
      	  attendantIO.logout();
          attendantIO.logout(); // Attempt to logout again
          coc.stop();
          String expectedMessage = "You are not currently logged in.";
          String actualMessage = coc.getOutput().trim();
          Assertions.assertEquals(expectedMessage, actualMessage);
       }
    }
    /*
     * 
     */
}
