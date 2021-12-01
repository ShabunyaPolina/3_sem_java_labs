package by.bsu.shabunya.lab8.window;

import by.bsu.shabunya.lab8.tabs.Tab1;
import by.bsu.shabunya.lab8.tabs.Tab2;
import by.bsu.shabunya.lab8.tabs.Tab3;

import javax.swing.*;
import java.awt.*;

public class AppWindow {
    static private final int WINDOW_WIDTH = 1000;
    static private final int WINDOW_HEIGHT = 800;

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
        tabbedPane.addTab("task 2", new Tab2(10));
        tabbedPane.addTab("task 3", new Tab3());
    }
}
