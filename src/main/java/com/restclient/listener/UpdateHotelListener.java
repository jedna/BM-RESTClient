package com.restclient.listener;

import com.restclient.client.HotelClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:10
 */
public class UpdateHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private final JTextField updateHotelIdField;
    private final JTextField updateHotelNameField;
    private final JTextPane hotelResponsePanel;

    public UpdateHotelListener(HotelClient hotelClient, JTextField updateHotelIdField, JTextField updateHotelNameField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.updateHotelIdField = updateHotelIdField;
        this.updateHotelNameField = updateHotelNameField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (updateHotelIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (updateHotelNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill hotel new name first.", "Hotel name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            hotelResponsePanel.setText("Update hotel ID: " + Long.parseLong(updateHotelIdField.getText()) + " and NAME: " + updateHotelNameField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
