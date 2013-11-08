package com.restclient.gui;

import com.restclient.listener.HotelActionListener;
import com.restclient.listener.UserActionListener;

import javax.swing.*;

/**
 * User: Jan Hrubeš
 * Date: 5.11.13
 * Time: 10:14
 */
public class RESTClient {
    private JPanel mainPanel;
    private JTextField hostField;
    private JTextPane responsePane;
    private JButton sendButton;
    private JButton hotelByIdButton;
    private JButton allHotelsButton;
    private JTextField hotelIdField;
    private JTextField userIdField;
    private JButton userByIdButton;
    private JButton allUsersButton;

    public RESTClient() {
        hotelByIdButton.addActionListener(new HotelActionListener(responsePane, hotelIdField));
        userByIdButton.addActionListener(new UserActionListener(responsePane, userIdField));
        allHotelsButton.addActionListener(new HotelActionListener(responsePane, hotelIdField));
        allUsersButton.addActionListener(new UserActionListener(responsePane, userIdField));
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("RESTClient");
        JPanel mainContent = new RESTClient().mainPanel;
        mainContent.setOpaque(true);
        frame.setContentPane(mainContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
}
