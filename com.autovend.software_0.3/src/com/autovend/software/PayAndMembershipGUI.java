package com.autovend.software;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayAndMembershipGUI extends JFrame {

    private JButton card;
    private JButton giftCard;
    private JButton cash;
    private JButton enterMembership;


    public PayAndMembershipGUI(){
        JFrame frame = new JFrame("Pay & Membership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cardPanel = new JPanel();
        JPanel cashPanel = new JPanel();
        JPanel giftCardPanel = new JPanel();
        JPanel membershipPanel = new JPanel();

        setMinimumSize(new Dimension(600, 400));

        card = new JButton("Debit/Credit");
        card.addActionListener(e -> {

        });

        cash = new JButton("Cash");
        cash.addActionListener(e -> {

        });

        giftCard = new JButton("Gift Card");
        cash.addActionListener(e -> {

        });

        enterMembership = new JButton("Enter Membership");
        enterMembership.addActionListener(e -> {

        });

       JPanel content = new JPanel(new GridLayout(3,2));
       content.add(cardPanel);
       content.add(giftCardPanel);
       content.add(cashPanel);
       content.add(membershipPanel);
    } //PayAndMembershipGUI end
} //class end
