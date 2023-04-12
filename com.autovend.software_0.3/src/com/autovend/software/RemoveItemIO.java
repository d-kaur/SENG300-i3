/** Bheesha Kumari - 30158810
 *
 */

package com.autovend.software;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.autovend.devices.SelfCheckoutStation;
import com.autovend.products.BarcodedProduct;

public class RemoveItemIO extends JFrame {

    private JButton backButton;
    private JButton removeButton;
    private JComboBox<String> itemDropdown;
    private RemoveItem removeItem;

    RemoveItemIO(SelfCheckoutStation check) {
        super();

        // initialize the components
        removeItem = new RemoveItem(check);
        String[] items = PurchasedItems.getListOfProducts().stream()
                .map(product -> product.getDescription()).toArray(String[]::new); //set items descriptions
        itemDropdown = new JComboBox<String>(items);
        backButton = new JButton();
        removeButton = new JButton();

        // on exit
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set button styles, and event listener
        backButton.setFont(new java.awt.Font("Segoe UI", 0, 18));
        backButton.setText("Remove");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        // set button styles, and event listener
        removeButton.setFont(new java.awt.Font("Segoe UI", 0, 18));
        removeButton.setText("Back");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        // layout creation
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(removeButton)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(itemDropdown, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemDropdown, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        pack();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        // when back button is clicked
        // change frame to AddScanItemGUI
        JFrame f = new AddScanItemGUI();
        f.setVisible(true);
        dispose();
    }

    private void removeButtonActionPerformed(ActionEvent evt) {
        // when remove button is clicked
        // find correct product
        for (BarcodedProduct p : PurchasedItems.getListOfProducts()) {
            if (p.getDescription().equals(itemDropdown.getSelectedItem())) {
                // remove it
                removeItem.removeItem(p);
                break;
            }
        }
    }

}
