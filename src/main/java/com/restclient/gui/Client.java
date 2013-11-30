package com.restclient.gui;

import com.restclient.client.HotelClient;
import com.restclient.listener.*;

import javax.swing.*;

/**
 * User: jenda_000
 * Date: 28.11.13
 * Time: 15:16
 */
public class Client {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JPanel hotelPanel;
    private JPanel userPanel;
    private JTextField newHotelNameField;
    private JButton createHotelButton;
    private JTextField updateHotelIdField;
    private JTextField updateHotelNameField;
    private JButton updateHotelButton;
    private JTextField deleteHotelIdField;
    private JButton deleteHotelButton;
    private JTextField getHotelIdField;
    private JButton getHotelButton;
    private JButton getAllHotelsButton;
    private JTextPane hotelResponsePanel;

    public Client() {
        HotelClient hotelClient = new HotelClient();

        createHotelButton.addActionListener(new CreateHotelListener(hotelClient, newHotelNameField, hotelResponsePanel));
        getHotelButton.addActionListener(new GetHotelListener(hotelClient, getHotelIdField, hotelResponsePanel));
        getAllHotelsButton.addActionListener(new GetAllHotelsListener(hotelClient, hotelResponsePanel));
        updateHotelButton.addActionListener(new UpdateHotelListener(hotelClient, updateHotelIdField, updateHotelNameField, hotelResponsePanel));
        deleteHotelButton.addActionListener(new DeleteHotelListener(hotelClient, deleteHotelIdField, hotelResponsePanel));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Client");
        frame.setContentPane(new Client().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
