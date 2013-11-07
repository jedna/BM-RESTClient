package com.restclient.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 5.11.13
 * Time: 11:06
 */
public class SendButtonListener implements ActionListener
{
    JTextPane output;
    public SendButtonListener(JTextPane output) {
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output.setText(e.getActionCommand());
    }
}
