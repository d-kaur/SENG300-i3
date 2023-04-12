/**
 * 
 */
package com.autovend.software;

/**
 * @author wasay
 * bheesha Kumari 30158810
 *
 */
public class AddItemTextCustomer extends AddItemTextGUI {
    private AddItemByTextSearch addItemByTextSearch;
    private JButton addItemBtn;
    private JButton searchBtn;
    private JComboBox<String> itemsComboBox;
    private JSeparator jSeparator1;
    private JTextField searchBar;

    AddItemTextCustomer(SelfCheckoutStation check) {
        super();

        addItemByTextSearch = new AddItemByTextSearch(check);

        // initialize the components
        itemsComboBox = new JComboBox<>();
        addItemBtn = new JButton();
        searchBar = new JTextField();
        searchBtn = new JButton();
        jSeparator1 = new JSeparator();

        // jFrame size
        setPreferredSize(new Dimension(450, 350));

        // on exit
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        itemsComboBox.setVisible(false);

        // set button styles, and event listener
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addItemBtn.setText("Add Item");
        addItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        // set button styles, and event listener
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        // layout creation
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addComponent(searchBtn).addGap(18, 18, 18).addComponent(
                                        searchBar, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addItemBtn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemsComboBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
                                        248, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemsComboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addItemBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)));

        pack();
    }

    @Override
    // when back button is clicked
    // change frame to AddScanItemGUI
    protected void backButtonActionPerformed(ActionEvent evt) {
        JFrame f = new AddScanItemGUI();
        f.setVisible(true);
        dispose();
    }

    // method which triggers when search button is pressed
    private void searchButtonActionPerformed(ActionEvent evt) {
        String keyword = searchBar.getText();
        String[] items = addItemByTextSearch.searchItems(keyword);
        if (items.length > 0) {
            itemsComboBox.setModel(new DefaultComboBoxModel<>(items));
            itemsComboBox.setVisible(true);
        }
    }

    // method which triggers when add item button is pressed
    private void addItemButtonActionPerformed(ActionEvent evt) {
        String selected = (String) itemsComboBox.getSelectedItem();
        addItemByTextSearch.addItem(selected);
    }
}




