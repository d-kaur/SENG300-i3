/**Johnathan Richardson 30045434
 * Gillian Sharp 30142574
 */


package com.autovend.software.test;

import com.autovend.software.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginLogoutTest {
	
	private HashMap accountDatabase;

	@Before
	public void setUp() {
		accountDatabase = new HashMap<String, String>();
        
        LoginLogout.createAccount("username", "password", accountDatabase);
		LoginLogout.createAccount("user", "1234", accountDatabase);
		LoginLogout.createAccount("supervisor", "securepassword", accountDatabase);
		LoginLogout.removeAccount("username", "password", accountDatabase);
	}
	
	@Test
    public void validLogin() {
		Boolean actual = LoginLogout.verifyLogin("user", "1234", accountDatabase);
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	@Test
	public void invalidLogin() {
		Boolean actual = LoginLogout.verifyLogin("username", "password", accountDatabase);
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	
     public class AttendantIOTest {

   	private AttendantIO attendantIO;

   	@BeforeEach
   	public void setUp() {
      	  attendantIO = new AttendantIO();
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
}
