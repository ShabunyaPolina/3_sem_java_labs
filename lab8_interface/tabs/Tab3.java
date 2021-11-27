package by.bsu.shabunya.lab8.tabs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tab3 extends JPanel {
    static final int BUTTONS_NUMBER = 4;
    private final ArrayList<JRadioButton> rButtons = new ArrayList<>();
    private final ArrayList<ArrayList<Image>> images = new ArrayList<>();

    public Tab3() {
        setLayout(new GridLayout(BUTTONS_NUMBER / 2, BUTTONS_NUMBER / 2));

        // create buttons
        for (int i = 0; i < BUTTONS_NUMBER; ++i) {
            rButtons.add(new JRadioButton());
        }

        readImages();

        fillTab();
        addActions();
    }

    private void readImages() {
        for (int i = 0; i < BUTTONS_NUMBER; ++i) {
            images.add(new ArrayList<>());
            for (int j = 0; j < 4; ++j) {
                try {
                    images.get(i).add(ImageIO.read(
                            new File((i + 1) +
                                    "." + (j + 1) + ".jpg")));
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }

    }

    private void fillTab() {
        ButtonGroup butGroup = new ButtonGroup();
        for (JRadioButton btn : rButtons) {
            butGroup.add(btn);
            add(btn);
        }

        for (int i = 0; i < rButtons.size(); ++i) {
            rButtons.get(i).setIcon(new ImageIcon(images.get(i).get(0)));
        }
    }

    private void addActions() {
        for (int i = 0; i < rButtons.size(); ++i) {
            CustomRadioButtonListener listener = new CustomRadioButtonListener(rButtons.get(i), i);
            rButtons.get(i).addChangeListener(listener);
            rButtons.get(i).addMouseListener(listener);
        }
    }

    class CustomRadioButtonListener implements ChangeListener, MouseListener {
        private final JRadioButton btn;
        private final int id;

        public CustomRadioButtonListener(JRadioButton btn, int id) {
            this.btn = btn;
            this.id = id;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            retrieveImage();
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {}

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            btn.setIcon(new ImageIcon(images.get(id).get(2)));
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            retrieveImage();
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            btn.setIcon(new ImageIcon(images.get(id).get(3)));
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            retrieveImage();
        }

        private void retrieveImage() {
            if (btn.isSelected())
                btn.setIcon(new ImageIcon(images.get(id).get(1)));
            else
                btn.setIcon(new ImageIcon(images.get(id).get(0)));
        }
    }
}