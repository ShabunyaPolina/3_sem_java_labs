package by.bsu.shabunya.lab6.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstAppWindow {

    static final int WINDOW_WIDTH = 1000;
    static final int WINDOW_HEIGHT = 800;

    JFrame mainFrame = new JFrame("Task 1");
    Container mainPanel = mainFrame.getContentPane();
    JLabel statusLabel = new JLabel("x:  " + "  y:  ");
    JPanel buttonField = new JPanel();
    JButton button = new JButton("click me");
    Font font = new Font("Serif", Font.PLAIN, 20);

    public FirstAppWindow() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation((dim.width - mainFrame.getWidth()) / 2,
                (dim.height - mainFrame.getHeight()) / 2);

        fillWindow();
        addActions();

        mainFrame.setVisible(true);
    }

    private void fillWindow() {
        // status bar
        statusLabel.setHorizontalTextPosition(JLabel.CENTER);
        statusLabel.setHorizontalAlignment(JLabel.LEFT);
        statusLabel.setFont(font);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        // button
        mainPanel.add(buttonField);
        buttonField.setLayout(null);
        button.setSize(200, 70);
        button.setFont(font);
        buttonField.add(button);
    }

    private void addActions() {
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setLocation(e.getX() - button.getWidth() / 2,
                        e.getY() - button.getHeight() / 2);
            }
        });

        mainPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                showMouseCoordinates(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                showMouseCoordinates(e);
            }
        });

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                showMouseCoordinates(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                showMouseCoordinates(e);
                if (e.isControlDown())
                    button.setLocation(e.getX() + button.getX() - button.getWidth() / 2,
                            e.getY() + button.getY() - button.getHeight() / 2);

            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE
                        && button.getText().length() != 0)
                    button.setText(button.getText()
                            .substring(0, button.getText().length() - 1));
                else
                    button.setText(button.getText() + e.getKeyChar());
            }
        });
    }

    void showMouseCoordinates(MouseEvent e) {
        Point currentPoint = SwingUtilities.convertPoint
                (e.getComponent(), e.getPoint(), mainPanel);
        statusLabel.setText("x: " + currentPoint.x
                + ";  y: " + currentPoint.y);
    }
}
