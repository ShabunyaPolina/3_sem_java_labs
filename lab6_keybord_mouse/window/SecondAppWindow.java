package by.bsu.shabunya.lab6.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecondAppWindow {
    static final int WINDOW_WIDTH = 1000;
    static final int WINDOW_HEIGHT = 800;

    JFrame mainFrame = new JFrame("Task 2");
    Container mainPanel = mainFrame.getContentPane();
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 30));
    JButton buttonNo = new JButton("Поcпать");
    JButton buttonYes = new JButton("Пойти");

    public SecondAppWindow() {
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
        // label
        JLabel label = new JLabel("Физра первой парой..");
        label.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 3));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, WINDOW_HEIGHT / 10));
        buttonsPanel.add(label, BorderLayout.NORTH);

        // buttons
        Font buttonFont = new Font("Serif", Font.PLAIN, WINDOW_HEIGHT / 38);
        buttonNo.setFont(buttonFont);
        buttonYes.setFont(buttonFont);
        buttonsPanel.add(buttonNo);
        buttonsPanel.add(buttonYes);
        mainPanel.add(buttonsPanel);
    }

    private void addActions() {
        buttonNo.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(mainFrame, "Вы приняли верное решение!");
        });

        buttonsPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                final int SAFE_DISTANCE = 15;
                final int ESCAPE_DISTANCE = 10;
                int y = buttonYes.getY();
                int x = buttonYes.getX();
                int width = buttonYes.getWidth();
                int height = buttonYes.getHeight();

                if (e.getX() >= x - SAFE_DISTANCE && e.getX() <= x + width / 3 &&
                        e.getY() >= y - SAFE_DISTANCE && e.getY() <= y + height / 3)
                    buttonYes.setLocation(x + ESCAPE_DISTANCE, y + ESCAPE_DISTANCE);
                else if (e.getX() >= x - SAFE_DISTANCE && e.getX() <= x + width / 3 &&
                        e.getY() >= y + height * 2 / 3 && e.getY() <= y + height + SAFE_DISTANCE)
                    buttonYes.setLocation(x + ESCAPE_DISTANCE, y - ESCAPE_DISTANCE);
                else if (e.getX() >= x + width * 2 / 3 && e.getX() <= x + width + SAFE_DISTANCE &&
                        e.getY() >= y - SAFE_DISTANCE && e.getY() <= y + height / 3)
                    buttonYes.setLocation(x - ESCAPE_DISTANCE, y + ESCAPE_DISTANCE);
                else if (e.getX() >= x + width * 2 / 3 && e.getX() <= x + width + SAFE_DISTANCE &&
                        e.getY() >= y + height * 2 / 3 && e.getY() <= y + height + SAFE_DISTANCE)
                    buttonYes.setLocation(x - ESCAPE_DISTANCE, y - ESCAPE_DISTANCE);
                else if (e.getX() >= x + width / 3 && e.getX() <= x + width * 2 / 3 &&
                        e.getY() >= y - SAFE_DISTANCE && e.getY() <= y + height / 3)
                    buttonYes.setLocation(x, y + ESCAPE_DISTANCE);
                else if (e.getX() >= x + width / 3 && e.getX() <= x + width * 2 / 3 &&
                        e.getY() >= y + height / 3 && e.getY() <= y + height + SAFE_DISTANCE)
                    buttonYes.setLocation(x, y - ESCAPE_DISTANCE);
                else if (e.getX() >= x - SAFE_DISTANCE && e.getX() <= x + width / 3 &&
                        e.getY() >= y + height / 3 && e.getY() <= y + height * 2 / 3)
                    buttonYes.setLocation(x + ESCAPE_DISTANCE, y);
                else if (e.getX() >= x + width * 2 / 3 && e.getX() <= x + width + SAFE_DISTANCE &&
                        e.getY() >= y + height / 3 && e.getY() <= y + height * 2 / 3)
                    buttonYes.setLocation(x - ESCAPE_DISTANCE, y);

                if (x <= 0 || y <= 0 || x + buttonYes.getWidth() >= WINDOW_WIDTH ||
                        y + buttonYes.getHeight() * 2 >= WINDOW_HEIGHT ||
                        (x + width / 2 >= buttonNo.getX() &&
                                x + width / 2 <= buttonNo.getX() + buttonNo.getWidth() &&
                                y + height / 2 >= buttonNo.getY() &&
                                y + height / 2  <= buttonNo.getY() + buttonNo.getHeight())) {
                    buttonYes.setLocation((int) (Math.random() * WINDOW_WIDTH),
                            (int) (Math.random() * WINDOW_HEIGHT));
                }
            }
        });
    }
}
