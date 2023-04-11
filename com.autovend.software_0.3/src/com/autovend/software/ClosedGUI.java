package com.autovend.software;

import javax.swing.*;
import java.awt.*;

public class ClosedGUI extends JFrame{
    public ClosedGUI(CustomerIO parent)
    {
        //this.parent = parent;
        JLabel label = new JLabel("Station Closed", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 80));
        setSize(600,600);
        add(label);
        setVisible(true);
    }
}
