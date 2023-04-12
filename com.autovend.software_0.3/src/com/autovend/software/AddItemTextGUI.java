/**
 * 
 */
package com.autovend.software;

/**
 * @author wasay
 *
 * bheesha kumari - 30158810
 *
 */
public class AddItemTextGUI {

    public abstract class AddItemTextGUI extends AddItemBrowseGUI {
        private JButton backButton;

        AddItemTextGUI() {

            // initialize the component
            backButton = new JButton();

            // on exit
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // set button styles, and event listener

            backButton.setFont(new Font("Segoe UI", 0, 18));
            backButton.setText("Back");
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    backButtonActionPerformed(evt);
                }
            });

            // layout creation

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(309, Short.MAX_VALUE)
                                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(235, Short.MAX_VALUE)
                                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16))
            );

            pack();
        }

        // method which triggers when back button is pressed
        protected abstract void backButtonActionPerformed(ActionEvent evt);


    }


}
