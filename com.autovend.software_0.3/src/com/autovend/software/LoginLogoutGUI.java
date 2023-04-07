package com.autovend.software;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	//using jframe
	public class LoginLogoutGUI extends JFrame implements ActionListener {
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    
	    private JButton loginButton;
	    private JButton errorButton;
	    
	    private LoginLogoutGUI loginLogout;

	    public LoginLogoutGUI() {
	        super("Login");
	        this.loginLogout = loginLogout;

	        // create components
	        JLabel usernameLabel = new JLabel("Username:");
	        JLabel passwordLabel = new JLabel("Password:");
	        
	        usernameField = new JTextField(20);
	        passwordField = new JPasswordField(20);
	        
	        loginButton = new JButton("Login");
	        loginButton.addActionListener(this);
	      
	        errorButton = new JButton("Error");
	        errorButton.addActionListener(this);
	        errorButton.setVisible(false); // hide the error button initially

	        // create layout and add components
	        JPanel contentPane = new JPanel(new GridLayout(3, 2));
	        contentPane.add(usernameLabel);
	        contentPane.add(usernameField);
	        
	        contentPane.add(passwordLabel);
	        contentPane.add(passwordField);
	        
	        contentPane.add(errorButton);
	        contentPane.add(loginButton);

	        // set frame properties
	        setContentPane(contentPane);
	        pack();
	        
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String username = usernameField.getText();
	        String password = new String(passwordField.getPassword());

	        if (( loginLogout).verifyLogin(username, password)) {
	            JOptionPane.showMessageDialog(this, "Login successful.");
	            dispose(); // close the login window
	        } else {
	            JOptionPane.showMessageDialog(this, "Invalid username or password.");
	        }
	    
	        if (e.getSource() == errorButton) verifyLogin(username, password) {
			// TODO Auto-generated method stub
			return;
	        }
	    }
		
	    private boolean verifyLogin(String username, String password) {
			// TODO Auto-generated method stub
			return false;
		}
		{
	            // hide the error button
	            errorButton.setVisible(false);
	        }
	    
	    public static void main(String[] args) {
	        LoginLogoutGUI loginLogout = new LoginLogoutGUI();
	        LoginLogoutGUI loginGUI = new LoginLogoutGUI();
	    }
	}
