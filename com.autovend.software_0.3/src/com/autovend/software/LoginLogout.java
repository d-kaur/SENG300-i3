/**Johnathan Richardson
 * 
 */
package com.autovend.software;

import java.util.HashMap;

public class LoginLogout {

	private HashMap<String, String> accountDatabase;
	
	public LoginLogout() {
		accountDatabase = new HashMap<>();
	}
	/**
	 * Checks if the username and password entered are in the accountDatabase. If so, return true. If not, return false.
	 * 
	 * @param username Username entered for login
	 * @param password Password entered for login
	 * @return
	 */
	public boolean verifyLogin(String username, String password){
		if (accountDatabase.containsKey(username)) {
			String userpassword = accountDatabase.get(password);
			if (userpassword == password) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Creates a new account for an attendant working a self checkout station
	 * 
	 * @param username Username that the attendant will use for login
	 * @param password Password that the attendant will use for login
	 */
	public void createAccount(String username, String password){
		if (accountDatabase.containsKey(username)) {
			System.out.println("An account with this username already exists");
		}
		else{
			accountDatabase.put(username, password);
		}
	}
	/**
	 * 
	 * @param username Username of the account that needs to be removed
	 * @param password Password of the account that needs to be removed
	 */
	public void removeAccount(String username, String password) {
		if (accountDatabase.containsKey(username)) {
			String userpassword = accountDatabase.get(password);
			if (userpassword == password) {
				accountDatabase.remove(password, userpassword);
			}
		}
	}
}
