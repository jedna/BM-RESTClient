package com.restclient.listener;

import com.restclient.client.UserClient;
import com.restclient.gui.RoleItem;
import com.restclient.model.Role;
import com.restclient.model.User;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: jenda_000
 * Date: 30.11.13
 * Time: 18:00
 */
public class CreateUserListener implements ActionListener {

    private UserClient userClient;
    private final JTextField newUserEmailField;
    private final JTextField newUserPasswordField;
    private JComboBox<RoleItem> newUserRoleCombo;
    private final JTextPane userResponsePanel;

    public CreateUserListener(UserClient userClient,
                              JTextField newUserEmailField,
                              JTextField newUserPasswordField,
                              JComboBox<RoleItem> newUserRoleCombo,
                              JTextPane userResponsePanel)
    {
        this.userClient = userClient;
        this.newUserEmailField = newUserEmailField;
        this.newUserPasswordField = newUserPasswordField;
        this.newUserRoleCombo = newUserRoleCombo;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newUserEmailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill user name first.", "User name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            User user = new User();
            user.setEmail(newUserEmailField.getText());
            user.setPassword(newUserPasswordField.getText());

            RoleItem roleItem = (RoleItem) newUserRoleCombo.getSelectedItem();
            Role role = new Role();
            role.setId(roleItem.getKey());
            role.setName(roleItem.getLabel());

            user.setRoleByRoleId(role);

            Response response = userClient.createUser(user);

            userResponsePanel.setText("Create user NAME: " + user.getEmail() + "\nResponse: " + response.getStatus());
            // TODO: Exceptions
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        }
    }
}
