/**Johnathan Richardson 30045434
 * Gillian Sharp 30142574
 */
package com.autovend.software;

import java.util.HashMap;
import java.util.Objects;

public class LoginLogout {
	private static HashMap<String, String> accountDatabase;
	static
	{
		accountDatabase = new HashMap<String, String>();
	}
	
	public static boolean verifyLogin(String username, String password){
		if (accountDatabase.containsKey(username)) {
			String userpassword = accountDatabase.get(username);
			if (Objects.equals(password, userpassword)) {
				return true;
			}
		}
		return false;
	}
	
	public static void createAccount(String username, String password){
		if (accountDatabase.containsKey(username)) {
			System.out.println("An account with this username already exists");
		}
		else{
			accountDatabase.put(username, password);
		}
	}
	
	public static void removeAccount(String username, String password) {
		if (accountDatabase.containsKey(username)) {
			String userpassword = accountDatabase.get(password);
			if (Objects.equals(password, userpassword)) {
				accountDatabase.remove(password, userpassword);
			}
		}
	}
	/*
	public class AttendantIO {
   		private boolean loggedIn;

   		// Constructor to set initial state
   		public AttendantIO() {
      	loggedIn = true;
   }

   	// Method to handle logout functionality
   	public void logout() {
      		if (loggedIn) {
        	  // Perform cleanup actions here
         	  // ...

         	  // Set the loggedIn flag to false to indicate logout
        	  loggedIn = false;

        	  System.out.println("Successfully logged out.");
      }
      	 else {
         	  System.out.println("You are not currently logged in.");
      		}
      	 }
   }*/

}
