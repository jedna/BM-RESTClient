package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:06
 */
public class GetHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private JTextField getHotelIdField;
    private JTextPane hotelResponsePanel;

    public GetHotelListener(HotelClient hotelClient, JTextField getHotelIdField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.getHotelIdField = getHotelIdField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getHotelIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long hotelId = Long.parseLong(getHotelIdField.getText());
            Hotel hotel = hotelClient.getHotel(hotelId);
            if (hotel == null) {
                hotelResponsePanel.setText("Hotel does not exist.");
            } else {
                hotelResponsePanel.setText("Get by ID: " + hotelId + "\nNAME: " + hotel.getName());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection to host could not be established." + "\n" + ex.getMessage(), "Connection unsuccessful", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
