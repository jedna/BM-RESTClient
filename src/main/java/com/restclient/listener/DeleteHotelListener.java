package com.restclient.listener;

import com.restclient.client.HotelClient;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:11
 */
public class DeleteHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private final JTextField deleteHotelIdField;
    private final JTextPane hotelResponsePanel;

    public DeleteHotelListener(HotelClient hotelClient, JTextField deleteHotelIdField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.deleteHotelIdField = deleteHotelIdField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (deleteHotelIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long hotelId = Long.parseLong(deleteHotelIdField.getText());
            Response response = hotelClient.deleteHotel(hotelId);

            hotelResponsePanel.setText("Delete By ID: " + hotelId + "\nResponse: " + response.getStatus());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        }
    }
}
