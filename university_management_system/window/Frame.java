package by.bsu.shabunya.unymanagsyst.window;

import by.bsu.shabunya.unymanagsyst.structure.Course;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    static final int WINDOW_WIDTH = 1000;
    static final int WINDOW_HEIGHT = 800;

    public Frame(Course course) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - getWidth()) / 2,
                (dim.height - getHeight()) / 2);

        CoursePanel coursePanel = new CoursePanel(course, WINDOW_WIDTH, WINDOW_HEIGHT);
        add(coursePanel);

        setVisible(true);
    }
}
