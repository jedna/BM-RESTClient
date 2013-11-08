package com.restclient.listener;

import com.restclient.client.HotelClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class HotelActionListener implements ActionListener {
    private JTextPane responsePane;
    private JTextField idField;

    private HotelClient hotelClient;

    public HotelActionListener(JTextPane responsePane, JTextField hotelId) {
        this.responsePane = responsePane;
        this.idField = hotelId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Get All")) {
            responsePane.setText("Get All");
        } else {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
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
