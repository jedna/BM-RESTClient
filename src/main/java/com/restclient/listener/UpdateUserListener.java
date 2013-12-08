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
 * Time: 18:10
 */
public class UpdateUserListener implements ActionListener {

    private UserClient userClient;
    private final JTextField updateUserIdField;
    private final JTextField updateUserEmailField;
    private final JTextField updateUserPasswordField;
    private final JComboBox<RoleItem> updateUserRoleCombo;
    private final JTextPane userResponsePanel;

    public UpdateUserListener(UserClient userClient, JTextField updateUserIdField, JTextField updateUserEmailField, JTextField updateUserPasswordField, JComboBox<RoleItem> updateUserRoleCombo, JTextPane userResponsePanel) {
        this.userClient = userClient;
        this.updateUserIdField = updateUserIdField;
        this.updateUserEmailField = updateUserEmailField;
        this.updateUserPasswordField = updateUserPasswordField;
        this.updateUserRoleCombo = updateUserRoleCombo;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (updateUserIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (updateUserEmailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill user new email first.", "User email required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            User user = new User();
            user.setId(Long.parseLong(updateUserIdField.getText()));
            user.setEmail(updateUserEmailField.getText());
            user.setPassword(updateUserPasswordField.getText());

            RoleItem roleItem = (RoleItem) updateUserRoleCombo.getSelectedItem();
            Role role = new Role();
            role.setId(roleItem.getKey());
            role.setName(roleItem.getLabel());

            user.setRoleByRoleId(role);

            Response response = userClient.updateUser(user);

            userResponsePanel.setText("Create user NAME: " + user.getEmail() + "\nResponse: " + response.getStatus());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        }
    }
}
