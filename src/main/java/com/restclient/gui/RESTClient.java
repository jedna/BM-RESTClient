package com.restclient.gui;

import com.restclient.listener.SendButtonListener;

import javax.swing.*;

/**
 * User: Jan Hrubeš
 * Date: 5.11.13
 * Time: 10:14
 */
public class RESTClient {
    private JPanel mainPanel;
    private JTextField hostField;
    private JTextField queryField;
    private JTextPane responsePane;
    private JButton sendButton;

    public RESTClient() {
        sendButton.addActionListener(new SendButtonListener(responsePane));
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
