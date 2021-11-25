package by.bsu.shabunya.lab8.window;

import by.bsu.shabunya.lab8.tabs.Tab1;

import javax.swing.*;
import java.awt.*;

public class AppWindow {
    static final int WINDOW_WIDTH = 1000;
    static final int WINDOW_HEIGHT = 800;

    private final JFrame mainFrame = new JFrame("");

    public AppWindow() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation((dim.width - mainFrame.getWidth()) / 2,
                (dim.height - mainFrame.getHeight()) / 2);


        addContext();
        mainFrame.setVisible(true);
    }

    private void addContext(){
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.SCROLL_TAB_LAYOUT);

        mainFrame.add(tabbedPane);
        tabbedPane.addTab("task 1", new Tab1(mainFrame.getWidth(),
                mainFrame.getHeight()));
    }
}
