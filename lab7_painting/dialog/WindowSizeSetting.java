package by.bsu.shabunya.lab7.dialog;

import by.bsu.shabunya.lab7.window.AppWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WindowSizeSetting {
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 350;

    private final JFrame mainFrame = new JFrame();
    private final Container mainPanel = mainFrame.getContentPane();
    private final JTextField drawAreaWidth = new JTextField("1000");
    private final JTextField drawAreaHeight = new JTextField("1000");
    private final JButton setSizeBut = new JButton("создать");

    public WindowSizeSetting() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation((dim.width - mainFrame.getWidth()) / 2,
                (dim.height - mainFrame.getHeight()) / 2);
        mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder
                (20, 20, 20, 20));

        fillWindow();
        addActions();

        mainFrame.setVisible(true);
    }

    private void fillWindow() {
        JPanel textFieldsPanel = new JPanel(new GridLayout(6, 1));
        textFieldsPanel.setBorder(BorderFactory.createTitledBorder("Размер поля для рисования"));
        textFieldsPanel.add(new JLabel("ширина: "));
        textFieldsPanel.add(drawAreaWidth);
        textFieldsPanel.add(new JLabel("длина: "));
        textFieldsPanel.add(drawAreaHeight);
        textFieldsPanel.add(new JLabel(""));
        textFieldsPanel.add(setSizeBut);
        mainPanel.add(textFieldsPanel);
    }

    private void addActions() {
        setSizeBut.addActionListener(actionEvent -> {
            if (Objects.equals(drawAreaWidth.getText(), "") ||
                    Objects.equals(drawAreaHeight.getText(), ""))
                showDialogException("Заполните все поля.");
            else {
                try {
                    new AppWindow(Integer.parseInt(drawAreaWidth.getText()),
                            Integer.parseInt(drawAreaHeight.getText()));
                    mainFrame.setVisible(false);
                } catch (NumberFormatException e) {
                    showDialogException("Некорректные данные.");
                }
            }
        });
    }

    private void showDialogException(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }
}
