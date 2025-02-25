package com.ticket.ui;

import javax.swing.*;
import java.awt.*;

public class TicketManagementUI extends JFrame {

    public TicketManagementUI() {
        setTitle("IT Support Ticket System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Ticket List Panel
        JTable ticketTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(ticketTable);
        add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton createTicketButton = new JButton("Create Ticket");
        JButton refreshButton = new JButton("Refresh");
        buttonPanel.add(createTicketButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicketManagementUI::new);
    }
}