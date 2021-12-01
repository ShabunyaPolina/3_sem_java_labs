package by.bsu.shabunya.lab9.window;

import by.bsu.shabunya.lab9.workwithfile.Reader;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 800;
    private final ToysPanel toysPanel = new ToysPanel(WINDOW_WIDTH, WINDOW_HEIGHT);

    public AppFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - getWidth()) / 2,
                (dim.height - getHeight()) / 2);

        addMenuBar();

        add(toysPanel);

        setVisible(true);
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        menuBar.add(file);

        open.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Reader reader = new Reader();
                toysPanel.openTable(reader.read(fileChooser.getSelectedFile().toString()));
            }
        });
    }
}
