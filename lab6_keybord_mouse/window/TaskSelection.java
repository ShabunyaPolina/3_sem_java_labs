package by.bsu.shabunya.lab6.window;

import javax.swing.*;
import java.awt.*;

public class TaskSelection {

    static final int WINDOW_WIDTH = 300;
    static final int WINDOW_HEIGHT = 200;

    JFrame mainFrame = new JFrame();
    Container mainPanel = mainFrame.getContentPane();
    JRadioButton radio1 = new JRadioButton("Task 1");
    JRadioButton radio2 = new JRadioButton("Task 2");
    Font font = new Font("Serif", Font.PLAIN, 20);

    public TaskSelection() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
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
        JLabel label = new JLabel("Select task number.");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
        mainPanel.add(label, BorderLayout.PAGE_START);

        JPanel radioButPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER,30,30));
        ButtonGroup butGroup = new ButtonGroup();

        radio1.setFont(font);
        radio2.setFont(font);

        butGroup.add(radio1);
        radioButPanel.add(radio1);
        butGroup.add(radio2);
        radioButPanel.add(radio2);
        mainPanel.add(radioButPanel);
    }

    private void addActions() {
        radio1.addActionListener(actionEvent -> {
            mainFrame.setVisible(false);
            new FirstAppWindow();
        });
        radio2.addActionListener(actionEvent -> {
            mainFrame.setVisible(false);
            new SecondAppWindow();
        });
    }
}
