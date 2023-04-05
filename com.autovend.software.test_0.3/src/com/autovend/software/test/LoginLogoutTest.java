package com.autovend.software.test;

import com.autovend.software.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

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
}
