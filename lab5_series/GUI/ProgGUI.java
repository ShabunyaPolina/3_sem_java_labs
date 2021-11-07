package by.bsu.shabunya.lab5.GUI;

import by.bsu.shabunya.lab5.series.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class ProgGUI extends JFrame {
    private Series series;

    private final Container container = getContentPane();

    private final JRadioButton radioButLiner = new JRadioButton("Liner");
    private final JRadioButton radioButExp = new JRadioButton("Exponential");
    private final JTextField firstElemField = new JTextField("0");
    private final JTextField factorField = new JTextField("0");
    private final JTextField numberOfElemsField = new JTextField("0");
    private final JButton showButton = new JButton("Show");
    private final JButton saveButton = new JButton("Save");
    private final JLabel sumLabel = new JLabel("Sum: ");
    private final JEditorPane dataPanel = new JEditorPane();

    public ProgGUI() {
        super("Series");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 400, 500, 400);
        container.setBackground(new Color(255, 224, 213));
        fillWindow();
        addActions();
        setVisible(true);
    }

    private void fillWindow() {
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

        // radio buttons
        JPanel radioButPanel = new JPanel(new GridLayout(0, 1));
        radioButPanel.setBorder(BorderFactory.createTitledBorder("Type"));
        ButtonGroup butGroup = new ButtonGroup();
        butGroup.add(radioButLiner);
        radioButPanel.add(radioButLiner);
        butGroup.add(radioButExp);
        radioButPanel.add(radioButExp);
        container.add(radioButPanel);

        // text fields
        JPanel textFieldsPanel = new JPanel(new GridLayout(3, 2));
        textFieldsPanel.setBorder(BorderFactory.createTitledBorder("Features"));
        textFieldsPanel.add(new JLabel("First element: "));
        textFieldsPanel.add(firstElemField);
        textFieldsPanel.add(new JLabel("Factor: "));
        textFieldsPanel.add(factorField);
        textFieldsPanel.add(new JLabel("Number of elements: "));
        textFieldsPanel.add(numberOfElemsField);
        container.add(textFieldsPanel);

        // show button
        container.add(showButton);
        container.add(sumLabel);
        dataPanel.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dataPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 100));
        container.add(scrollPane);

        // save button
        container.add(saveButton);
    }

    private void addActions() {
        radioButLiner.addActionListener(actionEvent -> {
            series = new Liner();
        });
        radioButExp.addActionListener(actionEvent -> {
            series = new Exponential();
        });

        firstElemField.addFocusListener(new TextFieldsFocusListener(firstElemField));
        factorField.addFocusListener(new TextFieldsFocusListener(factorField));
        numberOfElemsField.addFocusListener(new TextFieldsFocusListener(numberOfElemsField));

        showButton.addActionListener(actionEvent -> {
            if (!radioButLiner.isSelected() && !radioButExp.isSelected()) {
                showDialogException("Select the type of series");
                return;
            }
            try {
                series.setFirstElement(Double.parseDouble(firstElemField.getText()));
                series.setFactor(Double.parseDouble(factorField.getText()));
                series.setNumberOfElements(Integer.parseInt(numberOfElemsField.getText()));
            } catch (NumberFormatException e) {
                showDialogException("Incorrect entered data");
            }
            dataPanel.setText(series.toString());
            sumLabel.setText("Sum: " + series.calculateSum());
        });

        saveButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "*.*"));
            if (series == null) {
                showDialogException("Insufficient series data");
                return;
            }
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    series.saveToFile(fileChooser.getSelectedFile().toString(), "Progression:");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showDialogException(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private class TextFieldsFocusListener implements FocusListener {
        private final JTextField textField;

        public TextFieldsFocusListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void focusGained(FocusEvent focusEvent) {
        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            try {
                if (textField.equals(firstElemField))
                    series.setFirstElement(Double.parseDouble(firstElemField.getText()));
                else if (textField.equals(factorField))
                    series.setFactor(Double.parseDouble(factorField.getText()));
                else
                    series.setNumberOfElements(Integer.parseInt(numberOfElemsField.getText()));
            } catch (NumberFormatException e) {
                showDialogException("Incorrect entered data");
            }
        }
    }
}
