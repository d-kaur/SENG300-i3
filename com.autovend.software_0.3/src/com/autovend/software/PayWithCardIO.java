

package com.autovend.software;
import javax.swing.*;

import com.autovend.devices.SelfCheckoutStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayWithCardIO extends JFrame
{
    private PayIO parent;
    private JButton back = new JButton("back");
    public PayWithCardIO(PayIO parent,String msg)
    {
        super(msg);
    }
}