package by.bsu.shabunya.lab9.window;

import by.bsu.shabunya.lab9.toy.Toy;
import by.bsu.shabunya.lab9.toy.ToyList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ToysPanel extends JPanel {

    private final int width;
    private final int height;
    private ToyList toyList = new ToyList();
    private final DefaultTableModel model = new DefaultTableModel();
    private final JTextField nameField = new JTextField();
    private final JTextField priceField = new JTextField();
    private final JTextField lowerBoundField = new JTextField();
    private final JTextField upperBoundField = new JTextField();
    private final JButton btnAdd = new JButton("Add toy");

    public ToysPanel(int w, int h) {

        width = w;
        height = h;

        setLayout(new BorderLayout());

        fillPanel();
        addActions();
    }

    private void fillPanel() {
        // panel for ToyList
        JPanel listPanel = new JPanel(new BorderLayout());
        // heading
        JLabel heading = new JLabel("Toys: ");
        heading.setFont(new Font("Serif", Font.PLAIN, 40));
        heading.setHorizontalAlignment(JLabel.CENTER);
        listPanel.add(heading, BorderLayout.NORTH);

        // toys table
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Serif", Font.PLAIN, 18));

        String[] columnNames = {"name", "price", "age limit"};
        for(String name : columnNames) {
            model.addColumn(name);
        }
        for (Toy toy : toyList) {
            model.addRow(new String[]{
                    toy.getName(),
                    String.valueOf(toy.getPrice()),
                    String.valueOf(toy.getAgeLimit())});
        }
        listPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(listPanel, BorderLayout.CENTER);

        // tools panel
        JPanel toolsPanel = new JPanel(new GridLayout(15, 1));
        toolsPanel.setPreferredSize(new Dimension(width / 3, height));

        toolsPanel.add(new JLabel(""));
        toolsPanel.add(new JLabel("Toy name:"));
        toolsPanel.add(nameField);
        toolsPanel.add(new JLabel("Toy price:"));
        toolsPanel.add(priceField);
        toolsPanel.add(new JLabel("Age limit:"));
        JPanel ageLimitFiendsPanel = new JPanel(new GridLayout(2, 2));
        ageLimitFiendsPanel.add(new JLabel("Lower bound:"));
        ageLimitFiendsPanel.add(lowerBoundField);
        ageLimitFiendsPanel.add(new JLabel("Upper bound:"));
        ageLimitFiendsPanel.add(upperBoundField);
        toolsPanel.add(ageLimitFiendsPanel);
        toolsPanel.add(new JLabel(""));
        toolsPanel.add(btnAdd);
        add(toolsPanel, BorderLayout.EAST);
    }

    private void addActions() {
        btnAdd.addActionListener(actionEvent -> {
            try {
                Toy toy = new Toy(
                        nameField.getText(),
                        Integer.parseInt(priceField.getText()),
                        Integer.parseInt(lowerBoundField.getText()),
                        Integer.parseInt(upperBoundField.getText()));
                toyList.add(toy);
                model.addRow(new String[]{
                        toy.getName(),
                        String.valueOf(toy.getPrice()),
                        String.valueOf(toy.getAgeLimit())});
            } catch (NumberFormatException e) {
                showDialogException("Incorrect data. Check all the fiends again");
            }
        });
    }

    public void openTable(ToyList toyList) {
        model.setNumRows(0);
        this.toyList = toyList;
        for (Toy toy : toyList) {
            model.addRow(new String[]{
                    toy.getName(),
                    String.valueOf(toy.getPrice()),
                    String.valueOf(toy.getAgeLimit())});
        }
    }

    private void showDialogException(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
