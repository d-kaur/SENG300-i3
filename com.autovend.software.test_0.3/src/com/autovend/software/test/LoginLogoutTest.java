/**Johnathan Richardson 30045434
 * Gillian Sharp 30142574
 */


package com.autovend.software.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.autovend.software.LoginLogout;


public class LoginLogoutTest {
	
	private HashMap accountDatabase;

	@Before
	public void setUp() {
		accountDatabase = new HashMap<String, String>();
        
        LoginLogout.createAccount("username", "password");
		LoginLogout.createAccount("user", "1234");
		LoginLogout.createAccount("supervisor", "securepassword");
		LoginLogout.removeAccount("username", "password");
	}
	
	@Test
    public void validLogin() {
		Boolean actual = LoginLogout.verifyLogin("user", "1234");
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	@Test
	public void invalidLogin() {
		Boolean actual = LoginLogout.verifyLogin("username", "password");
		Boolean expected = false;
		assertEquals(actual, expected);
	}
}
	

