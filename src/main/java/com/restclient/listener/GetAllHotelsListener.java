package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:10
 */
public class GetAllHotelsListener implements ActionListener {

    private HotelClient hotelClient;
    private JTextPane hotelResponsePanel;

    public GetAllHotelsListener(HotelClient hotelClient, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String output = "";
            for (Hotel hotel: hotelClient.getHotels()) {
                output += hotel.getName() + "\n";
            }
            hotelResponsePanel.setText(output);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection to host could not be established." + "\n" + ex.getMessage(), "Connection unsuccessful", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
