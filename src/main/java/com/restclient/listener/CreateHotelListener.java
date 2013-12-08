package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:00
 */
public class CreateHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private final JTextField newHotelNameField;
    private final JTextPane hotelResponsePanel;

    public CreateHotelListener(HotelClient hotelClient, JTextField newHotelNameField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.newHotelNameField = newHotelNameField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newHotelNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill hotel name first.", "Hotel name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Hotel hotel = new Hotel();
            hotel.setName(newHotelNameField.getText());

            Response response = hotelClient.createHotel(hotel);

            hotelResponsePanel.setText("Create hotel NAME: " + newHotelNameField.getText() + "\nResponse: " + response.getStatus());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
