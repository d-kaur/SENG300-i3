//Gillian Sharp 30142574
//Johnathan 

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

	private LoginLogout ll;
	
	@Before
	public void setUp() {
		ll = new LoginLogout();
		ll.createAccount("username", "password");
		ll.createAccount("user", "1234");
		ll.createAccount("supervisor", "securepassword");
		ll.removeAccount("username", "password");
	}
	
	@After
	public void tearDown() {
		ll = null;
	}
	
	@Test
    public void validLogin{
		Boolean actual = ll.verifyLogin("user", "1234");
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	@Test
	public void invalidLogin{
		Boolean actual = ll.verifyLogin("username", "password");
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
