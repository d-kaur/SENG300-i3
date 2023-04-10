package com.autovend.software;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayAndMembershipGUI extends JFrame implements ActionListener {

   /* private JButton membershipButton;
    private JLabel payTypeLabel;
    private JButton payCardButton;
    private JButton giftCardButton;
    private JButton payCashButton;
    private JButton back;

*/
    private PayWithCard card;
    private PayWithCash cash;

    public PayAndMembershipGUI(){
        JFrame frame = new JFrame("Pay & Membership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
