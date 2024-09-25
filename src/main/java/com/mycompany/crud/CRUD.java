/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud;

/**
 *
 * @author 1
 */
import javax.swing.JOptionPane;

public class CRUD extends javax.swing.JFrame {

    public CRUD() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        contactslbl = new javax.swing.JLabel();
        displayFriendsBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        addBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactosList = new javax.swing.JList<>();
        updateBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Cambiar el título "Contactos" a "Contacts"
        contactslbl.setText("Contacts");

        // Cambiar el texto del botón "Cargar Contactos" a "Load Contacts"
        displayFriendsBTN.setText("Load Contacts");
        displayFriendsBTN.addActionListener(evt -> displayFriendsBTNActionPerformed());

        // Cambiar el texto del botón "Borrar Contacto" a "Delete Contact"
        deleteBTN.setText("Delete Contact");
        deleteBTN.addActionListener(evt -> deleteBTNActionPerformed());

        // Cambiar el texto del botón "Añadir Contactos" a "Add Contacts"
        addBTN.setText("Add Contacts");
        addBTN.addActionListener(evt -> addBTNActionPerformed());

        contactosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = DisplayFriends.displayFriends();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(contactosList);

        // Cambiar el texto del botón "Actualizar Número" a "Update Number"
        updateBTN.setText("Update Number");
        updateBTN.addActionListener(evt -> updateBTNActionPerformed());

        // Eliminamos el JLabel de "Realizado" que estaba en la parte inferior
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(contactslbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(displayFriendsBTN)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBTN)
                        .addGap(18, 18, 18)
                        .addComponent(updateBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(addBTN)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contactslbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBTN)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayFriendsBTN)
                    .addComponent(deleteBTN)
                    .addComponent(updateBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void addBTNActionPerformed() {
        this.setVisible(false);
        AddContacts addContacts = new AddContacts();
        addContacts.setVisible(true);
    }

    private void updateBTNActionPerformed() {
        String contacto = contactosList.getSelectedValue();
        String[] contactoSplit = contacto.split(":");
        String nuevoNumero = JOptionPane.showInputDialog("Enter new number for " + contactoSplit[0]);
        UpdateFriend.updateFriend(contactoSplit[0], Long.parseLong(contactoSplit[1]), Long.parseLong(nuevoNumero));
        contactosList.setListData(DisplayFriends.displayFriends());
    }

    private void deleteBTNActionPerformed() {
        String contacto = contactosList.getSelectedValue();
        String nombre = contacto.substring(0, contacto.indexOf(":"));
        DeleteFriend.deleteFriend(nombre);
        contactosList.setListData(DisplayFriends.displayFriends());
    }

    private void displayFriendsBTNActionPerformed() {
        contactosList.setListData(DisplayFriends.displayFriends());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CRUD().setVisible(true));
    }

    private javax.swing.JButton addBTN;
    private javax.swing.JList<String> contactosList;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton displayFriendsBTN;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel contactslbl;
    private javax.swing.JButton updateBTN;
}