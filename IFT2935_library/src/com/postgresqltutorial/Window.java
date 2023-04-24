package com.postgresqltutorial;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JLabel title;
    private JButton btnQ1;
    private JButton btnQ2;
    private JButton btnQ3;
    private JButton btnQ4;
    private JPanel leftPanel;
    private JButton btnClear;
    private JLabel createdBy;
    private JTextArea response;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private Query query1;
    private Query query2;
    private Query query3;
    private Query query4;

    public Window() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        initComponents();
        initQueries();
        addListeners();
//        this.setPreferredSize(new Dimension(400, 400));
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initQueries() {
        query1 = new Query("select * from library_ms.question1",
                new String[]{"first_name", "last_name", "num_of_books"});
        query2 = new Query("select * from library_ms.question2",
                new String[]{"name", "num_of_books_published"});
        query3 = new Query("select * from library_ms.question3",
                new String[]{"first_name", "last_name", "num_of_borrows"});
        query4 = new Query("select * from library_ms.question4",
                new String[]{"first_name", "last_name", "num_of_orders"});
    }

    private void addListeners() {
        btnQ1.addActionListener(e -> {
            response.setText(query1.runQuery());
        });

        btnQ2.addActionListener(e -> {
            response.setText(query2.runQuery());
        });

        btnQ3.addActionListener(e -> {
            response.setText(query3.runQuery());
        });

        btnQ4.addActionListener(e -> {
            response.setText(query4.runQuery());
        });


        btnClear.addActionListener(e -> {
            response.setText("");
        });
    }

    private void initComponents() {


//        title
        title = new JLabel("Projet Finale - Library");
        title.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        title.setHorizontalAlignment(JLabel.CENTER);


//        question buttons
        btnQ1 = new JButton("Question 1");
        btnQ2 = new JButton("Question 2");
        btnQ3 = new JButton("Question 2");
        btnQ4 = new JButton("Question 2");

        btnQ1.setPreferredSize(new Dimension(90, 90));
        btnQ2.setPreferredSize(new Dimension(90, 90));
        btnQ3.setPreferredSize(new Dimension(90, 90));
        btnQ4.setPreferredSize(new Dimension(90, 90));


//        left panel
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        leftPanel.setPreferredSize(new Dimension(100, 400));
        leftPanel.add(btnQ1);
        leftPanel.add(btnQ2);
        leftPanel.add(btnQ3);
        leftPanel.add(btnQ4);


//        clear button
        btnClear = new JButton("Clear");
        btnClear.setPreferredSize(new Dimension(90, 90));
        btnClear.setVerticalAlignment(JButton.CENTER);
        btnClear.setBorderPainted(false);
        btnClear.setBackground(Color.RED);
        btnClear.setForeground(Color.WHITE);


//        created by
        createdBy = new JLabel("Project by Ali Taladar");
        createdBy.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        createdBy.setHorizontalAlignment(JLabel.CENTER);


//        text area
        response = new JTextArea();
        scrollPane = new JScrollPane(response);


//        Main panel
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(600, 500));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(createdBy, BorderLayout.SOUTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(btnClear, BorderLayout.EAST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);


        this.add(mainPanel);
    }
}