/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

/**
 *
 * @author 1
 */
import javax.swing.JOptionPane;

public class AddContacts extends javax.swing.JFrame {

    public AddContacts() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        addContactslbl = new javax.swing.JLabel();
        numberLBL = new javax.swing.JLabel();
        nameLBL = new javax.swing.JLabel();
        nameTXT = new javax.swing.JTextField();
        numberTXT = new javax.swing.JTextField();
        addContactBTN = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addContactslbl.setText("AÑADIR CONTACTOS");

        numberLBL.setText("Número:");

        nameLBL.setText("Nombre:");

        addContactBTN.setText("Añadir Contacto");
        addContactBTN.addActionListener(evt -> addContactBTNActionPerformed());

        backBTN.setText("Volver");
        backBTN.addActionListener(evt -> backBTNActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLBL)
                    .addComponent(numberLBL))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTXT)
                    .addComponent(numberTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(addContactslbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(backBTN)
                .addGap(18, 18, 18)
                .addComponent(addContactBTN)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addContactslbl)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLBL)
                    .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLBL)
                    .addComponent(numberTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addContactBTN)
                    .addComponent(backBTN))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }

    private void backBTNActionPerformed() {
        this.setVisible(false);
        new CRUD().setVisible(true);
    }

    private void addContactBTNActionPerformed() {
        String nombre = nameTXT.getText();
        Long numero = Long.parseLong(numberTXT.getText());
        JOptionPane.showMessageDialog(null, AddFriend.addFriend(nombre, numero));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AddContacts().setVisible(true));
    }

    private javax.swing.JButton addContactBTN;
    private javax.swing.JLabel nameLBL;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JLabel numberLBL;
    private javax.swing.JTextField numberTXT;
    private javax.swing.JLabel addContactslbl;
    private javax.swing.JButton backBTN;
}