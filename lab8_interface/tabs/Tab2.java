package by.bsu.shabunya.lab8.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Tab2 extends JPanel {
    private final ArrayList<JButton> buttons = new ArrayList<>();

    public Tab2(int n) {
        int numberOfButtons = n * n;
        for (int i = 1; i <= numberOfButtons; ++i) {
            JButton but = new JButton(String.valueOf(i));
            buttons.add(but);
        }
        setLayout(new GridLayout(n, n));

        fillTab();
        addActions();
    }

    private void fillTab() {
        for (JButton btn : buttons) {
            add(btn);
        }
    }

    private void addActions() {

        for (int i = 0; i < buttons.size(); ++i) {
            buttons.get(i).addMouseListener(new CustomMouseListener(i + 1));
        }

    }

    static class CustomMouseListener implements MouseListener {
        private final Color bgColor = Color.MAGENTA;
        int serialNumber;

        public CustomMouseListener(int serialNumber) {
            this.serialNumber = serialNumber;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {}

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            JButton but = (JButton) mouseEvent.getComponent();
            but.setText("Clicked!");
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            JButton but = (JButton) mouseEvent.getComponent();
            but.setText(String.valueOf(serialNumber));
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            mouseEvent.getComponent().setBackground(bgColor);
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            mouseEvent.getComponent().setBackground(null);
        }
    }
}