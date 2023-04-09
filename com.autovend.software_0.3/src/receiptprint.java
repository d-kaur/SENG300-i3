import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
package com.autovend.software;
import com.autovend.devices.*;
import com.autovend.products.BarcodedProduct;
import com.autovend.software.test.ReceiptPrinterObserverStub;

//*print reciept//*
public class SelfCheckoutGUI extends JFrame {
    private JButton payButton;
    private JLabel totalLabel;
    private JTextField totalField;
    private JLabel paymentLabel;
    private JTextField paymentField;
    private JButton printButton;

    public SelfCheckoutGUI() {
        setTitle("Self-Checkout Station");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and add components to the window
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        totalLabel = new JLabel("Total:");
        totalField = new JTextField(10);
        paymentLabel = new JLabel("Payment:");
        paymentField = new JTextField(10);
        payButton = new JButton("Pay");
        printButton = new JButton("Print Receipt");
        panel.add(totalLabel);
        panel.add(totalField);
        panel.add(paymentLabel);
        panel.add(paymentField);
        panel.add(payButton);
        panel.add(printButton);
        add(panel);

        // Attach listeners to the buttons
        payButton.addActionListener(new PayListener());
        printButton.addActionListener(new PrintListener());

        setVisible(true);
    }

    public static void main(String[] args) {
        new SelfCheckoutGUI();
    }

    private class PayListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Code to update bill record with payment details
        }
    }

    private class PrintListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Code to send print signal to the receipt printer
        }
    }
}
