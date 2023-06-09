package com.autovend.software;
import com.autovend.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayAndMembershipGUI extends JFrame {

    private JButton card;
    private JButton giftCard;
    private JButton cash;
    private JButton enterMembership;
    private JButton back;
    private JLabel payLabel;

    public PayAndMembershipGUI(){
        JFrame frame = new JFrame("Pay & Membership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cardPanel = new JPanel();
        JPanel cashPanel = new JPanel();
        JPanel giftCardPanel = new JPanel();
        JPanel membershipPanel = new JPanel();

        setMinimumSize(new Dimension(600, 400));

        payLabel = new JLabel("Choose payment Option:");

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

        back = new JButton("Back");
        back.addActionListener(e -> {

        });

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        enterMembership.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(enterMembership);

        payLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(payLabel);

        card.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(card);

        giftCard.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(giftCard);

        cash.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(cash);

        back.setAlignmentX(JButton.CENTER_ALIGNMENT);
        content.add(back);

        setContentPane(content);
        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    } //PayAndMembershipGUI end

    public static void main(String[] args) {
        PayAndMembershipGUI huhAndMembershipGUI = new PayAndMembershipGUI();
    }
} //class end
