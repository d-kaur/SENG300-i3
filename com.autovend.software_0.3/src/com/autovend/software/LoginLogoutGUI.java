/**Johnathan Richardson 30045434
 * Gillian Sharp 30142574
 */

package com.autovend.software;

import com.autovend.software.*;
import java.util.HashMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	//using jframe
	public class LoginLogoutGUI extends JFrame {
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    
	    private JButton loginButton;
	    private JButton errorButton;
	    private AttendantIO attendantIO;
	    private JPanel contentPane;

		public LoginLogoutGUI(AttendantIO attendantIO) {
	        super("Login");
	        this.attendantIO = attendantIO;

	        // create components
	        JLabel usernameLabel = new JLabel("Username:");
	        JLabel passwordLabel = new JLabel("Password:");
	        
	        usernameField = new JTextField(20);
	        passwordField = new JPasswordField(20);
	        
	        loginButton = new JButton("Login");

	      
	        errorButton = new JButton("Error");
	        //errorButton.addActionListener(this);
	        errorButton.setVisible(false); // hide the error button initially

	        // create layout and add components
	         contentPane = new JPanel(new GridLayout(3, 2));
	        contentPane.add(usernameLabel);
	        contentPane.add(usernameField);
	        
	        contentPane.add(passwordLabel);
	        contentPane.add(passwordField);
	        
	        contentPane.add(errorButton);
	        contentPane.add(loginButton);
			loginButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (LoginLogout.verifyLogin(new String(usernameField.getText()), new String(passwordField.getPassword()))) {
						attendantIO.displayMainScreen();
					} else {
						errorButton.setVisible(true);
					}
				}}
			);
	        // set frame properties
	        // setContentPane(contentPane);
	        pack();
	        add(contentPane);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }

	    
	    //public static void main(String[] args) {
	      //  LoginLogoutGUI loginGUI = new LoginLogoutGUI();
	    //}
	}
