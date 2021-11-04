package by.bsu.shabunya.lab5.GUI;

import by.bsu.shabunya.lab5.series.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProgGUI extends JFrame {
    Series series;

    public ProgGUI() {
        JFrame frame = new JFrame("Series");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocation(700,400);
        frame.setSize(500,400);

        Container container = frame.getContentPane();
        container.setBackground(new Color(255, 224, 213));

        container.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

        // radio buttons
        JPanel jp1 = new JPanel(new GridLayout(0, 1));
        jp1.setBorder(BorderFactory.createTitledBorder("Type"));
        jp1.setPreferredSize(new Dimension(200,80));
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("Liner");
        bg1.add(radioButton1);
        jp1.add(radioButton1);
        radioButton1.addActionListener(actionEvent -> { series = new Liner(); });
        JRadioButton radioButton2 = new JRadioButton("Exponential");
        bg1.add(radioButton2);
        jp1.add(radioButton2);
        radioButton2.addActionListener(actionEvent -> { series = new Exponential(); });
        container.add(jp1);

        // text fields for data
        JPanel jp2 = new JPanel(new GridLayout(3, 2));
        jp2.setBorder(BorderFactory.createTitledBorder("Features"));
        jp2.setPreferredSize(new Dimension(350,100));
        JTextField tf1 = new JTextField("0");
        JTextField tf2 = new JTextField("0");
        JTextField tf3 = new JTextField("0");
        jp2.add(new JLabel("First element: "));
        jp2.add(tf1);
        jp2.add(new JLabel("Factor: "));
        jp2.add(tf2);
        jp2.add(new JLabel("Number of elements: "));
        jp2.add(tf3);
        container.add(jp2);

        // button to show series
        JButton button = new JButton("Show");
        container.add(button);
        JEditorPane ep1 = new JEditorPane();
        JLabel l = new JLabel("Sum: ");
        container.add(l);
        ep1.setPreferredSize(new Dimension(400,60));
        ep1.setEditable(false);
        container.add(new JScrollPane(ep1));
        button.addActionListener(actionEvent -> {
            series.setFirstElement(Double.parseDouble(tf1.getText()));
            series.setFactor(Double.parseDouble(tf2.getText()));
            series.setNumberOfElements(Integer.parseInt(tf3.getText()));
            ep1.setText(series.toString());
            l.setText("Sum: " + series.calculateSum());
        });

        // button to save data to file
        JButton button2 = new JButton("Save");
        container.add(button2);
        button2.addActionListener(actionEvent -> {
            try {
                series.saveToFile("series.txt", "g");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}
