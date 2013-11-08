package com.restclient.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class UserActionListener implements ActionListener {
    private JTextPane responsePane;
    private JTextField idField;

    public UserActionListener(JTextPane responsePane, JTextField userId) {
        this.responsePane = responsePane;
        this.idField = userId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Get All")) {
            responsePane.setText("Get All");
        } else {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You have to fill ID first.", "Id required", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                responsePane.setText("Get By ID: " + Long.parseLong(idField.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}
