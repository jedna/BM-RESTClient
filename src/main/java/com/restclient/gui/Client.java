package com.restclient.gui;

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
    private JButton createButton;
    private JTextField updateHotelIdField;
    private JTextField updateHotelNameField;
    private JButton updateButton;
    private JTextField deleteHotelIdField;
    private JButton deleteButton;
    private JTextField getHotelIdField;
    private JButton getButton;
    private JButton getAllButton;
    private JTextPane responsePanel;

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
