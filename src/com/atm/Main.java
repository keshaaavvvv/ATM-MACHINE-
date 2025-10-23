package com.atm;

import com.atm.ui.SplashScreen;

public class Main {
    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(SplashScreen::new);
    }
}
