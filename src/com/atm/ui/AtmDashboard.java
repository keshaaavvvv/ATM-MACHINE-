package com.atm.ui;

import com.atm.model.Account;
import com.atm.model.Transaction;
import com.atm.service.AtmService;

import javax.swing.*;
import java.awt.*;

public class AtmDashboard extends JFrame {
    private final Account acc;
    private final JTextArea output = new JTextArea(10, 30);

    public AtmDashboard(AtmService service) {
        this.acc = service.getCurrentAccount();

        setTitle("ATM Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(245, 250, 255));

        String greeting = acc.getUsername().equalsIgnoreCase("sukriti sinha")
                ? "Welcome Sukriti Sinha 💖"
                : "Welcome " + acc.getUsername();

        JLabel welcome = new JLabel(greeting);
        welcome.setFont(new Font("SansSerif", Font.BOLD, 20));
        welcome.setForeground(new Color(0, 51, 102));
        add(welcome);

        JButton depositBtn = new JButton("Deposit ₹500");
        depositBtn.addActionListener(_ -> {
            acc.deposit(500);
            output.setText("✅ Deposited ₹500\nBalance: ₹" + acc.getBalance());
        });

        JButton withdrawBtn = new JButton("Withdraw ₹500");
        withdrawBtn.addActionListener(_ -> {
            boolean success = acc.withdraw(500);
            output.setText(success ? "✅ Withdrawn ₹500\nBalance: ₹" + acc.getBalance()
                    : "❌ Insufficient balance.");
        });

        JButton historyBtn = new JButton("Transaction History");
        historyBtn.addActionListener(_ -> {
            StringBuilder sb = new StringBuilder("🧾 Transaction History:\n");
            for (Transaction tx : acc.getTransactionHistory()) {
                sb.append(tx.toString()).append("\n");
            }
            output.setText(sb.toString());
        });

        add(depositBtn);
        add(withdrawBtn);
        add(historyBtn);
        add(new JScrollPane(output));

        setVisible(true);
    }
}
