package com.mliddy.javaintro;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String... args) {
        JFrame application = createGUI();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }


    private static JFrame createGUI() {

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 40));

        JButton convertButton = new JButton("Convert");
        JLabel output = new JLabel();
        output.setPreferredSize(new Dimension(300, 40));

        convertButton.addActionListener(event -> {
            output.setText(TitleCaseConverter.convertToTitleCase(input.getText()));
        });

        JFrame gui = new JFrame("Title case convcerter");
        gui.setLayout(new FlowLayout());
        gui.add(input);
        gui.add(output);
        gui.add(convertButton);
        gui.pack();
        gui.setLocationRelativeTo(null);
        return gui;

    }
}