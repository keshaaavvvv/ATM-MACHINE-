package com.atm.ui;

import com.atm.service.AtmService;
import com.atm.ui.AtmDashboard; // ✅ Required import

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthScreen extends JFrame {
    private final AtmService service = new AtmService();
    private final JTextField accountField = new JTextField(10);
    private final JPasswordField pinField = new JPasswordField(10);
    private final JTextField nameField = new JTextField(10);
    private final JTextArea output = new JTextArea(4, 30);

    public AuthScreen() {
        setTitle("ATM Login");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));
        getContentPane().setBackground(new Color(230, 240, 255));

        add(new JLabel("Account Number:"));
        add(accountField);
        add(new JLabel("PIN:"));
        add(pinField);
        add(new JLabel("Name (for Sign Up):"));
        add(nameField);

        JButton signInBtn = new JButton("Sign In");
        signInBtn.setBackground(new Color(0, 102, 204));
        signInBtn.setForeground(Color.WHITE);
        signInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String acc = accountField.getText();
                String pin = new String(pinField.getPassword());
                if (service.signIn(acc, pin)) {
                    dispose();
                    new AtmDashboard(service); // ✅ Now resolved
                } else {
                    output.setText("❌ Invalid credentials.");
                }
            }
        });

        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBackground(new Color(0, 153, 76));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String acc = accountField.getText();
                String pin = new String(pinField.getPassword());
                String name = nameField.getText();
                boolean success = service.signUp(acc, name, pin);
                output.setText(success ? "✅ Account created!" : "❌ Account already exists.");
            }
        });

        add(signInBtn);
        add(signUpBtn);
        add(new JScrollPane(output));
        setVisible(true);
    }
}
