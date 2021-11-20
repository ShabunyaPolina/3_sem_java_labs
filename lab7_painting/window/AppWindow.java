package by.bsu.shabunya.lab7.window;

import by.bsu.shabunya.lab7.painting.DrawPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class AppWindow {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 800;

    private final JFrame mainFrame = new JFrame("");
    private final Container contentPane = mainFrame.getContentPane();

    private final DrawPanel drawPanel;
    private final JSlider slider = new JSlider();
    private final JButton colorBut = new JButton("выбрать цвет");
    private final JButton saveBut = new JButton("сохранить");
    private final JButton openBut = new JButton("открыть");

    public AppWindow(int width, int height) {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation((dim.width - mainFrame.getWidth()) / 2,
                (dim.height - mainFrame.getHeight()) / 2);

        drawPanel = new DrawPanel(width,height);

        fillWindow();
        addActions();
        mainFrame.setVisible(true);
    }

    private void fillWindow() {
        JPanel toolsPanel = new JPanel(new GridLayout(3,1, 0, 50));

        // width slider
        Dictionary<Integer, JLabel> labels = new Hashtable<>();
        for (int i = 1; i < 11; ++i) {
            labels.put(i, new JLabel(String.valueOf(i)));
        }
        BoundedRangeModel model = new DefaultBoundedRangeModel(1, 0, 1, 10);
        slider.setModel(model);
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setLabelTable(labels);
        slider.setPaintLabels(true);
        JPanel sliderPanel = new JPanel(new GridLayout(1,1));
        sliderPanel.setBorder(BorderFactory.createTitledBorder("толщина кисти"));
        sliderPanel.add(slider);
        toolsPanel.add(sliderPanel);
        contentPane.add(toolsPanel, BorderLayout.WEST);

        // action buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(4,1, 0, 10));
        buttonsPanel.add(colorBut);
        buttonsPanel.add(saveBut);
        buttonsPanel.add(openBut);
        toolsPanel.add(buttonsPanel);

        // drawing panel
        contentPane.add(new JScrollPane(drawPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }

    public void addActions() {
        slider.addChangeListener(e -> {
            drawPanel.setCurrentBrushWidth(((JSlider) e.getSource()).getValue());
        });

        colorBut.addActionListener(actionEvent -> {
            Color color = Color.BLACK;
            color = JColorChooser.showDialog(
                    mainFrame, "Выбор цвета", color);
            drawPanel.setCurrentColor(color);
        });

        saveBut.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("*.jpg", "*.*"));
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    System.out.println(ImageIO.write(drawPanel.getImage(),
                            "jpg", new File(fileChooser.getSelectedFile().toString())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        openBut.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    drawPanel.openImage(ImageIO.read(new File(fileChooser.getSelectedFile().toString())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
