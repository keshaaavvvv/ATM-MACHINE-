package com.atm.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JFrame {
    public SplashScreen() {
        setUndecorated(true);
        setSize(450, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0, 51, 102));
        setLayout(new BorderLayout());

        JLabel label = new JLabel("🏦 Welcome to ATM Machine 🏦", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        add(label, BorderLayout.CENTER);

        setVisible(true);

        Timer timer = new Timer(2000, new SplashTimerHandler());
        timer.setRepeats(false);
        timer.start();
    }

    private class SplashTimerHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AuthScreen();
        }
    }
}
