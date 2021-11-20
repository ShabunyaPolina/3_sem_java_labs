package by.bsu.shabunya.lab7.painting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private BufferedImage image;
    private BufferedImage newImage;
    private final ArrayList<ArrayList<Point>> points = new ArrayList<>();
    private final ArrayList<Integer> width = new ArrayList<>();
    private final ArrayList<Color> color = new ArrayList<>();
    private int currentBrushWidth = 1;
    private Color currentColor = Color.BLACK;

    public DrawPanel(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(new ArrayList<>());
                width.add(currentBrushWidth);
                color.add(currentColor);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.get(points.size() - 1).add(e.getPoint());
                repaint();
            }
        });
    }

    public void setCurrentBrushWidth(int width) {
        currentBrushWidth = width;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setImage(BufferedImage img) {
        image = img;
    }

    public void openImage(BufferedImage img) {
        setImage(img);
        repaint();
    }

    public BufferedImage getImage() {
        return newImage;
    }

    private void draw(Graphics2D gr) {
        for (int i = 0; i < points.size(); ++i) {
            gr.setColor(color.get(i));
            gr.setStroke(new BasicStroke(width.get(i)));
            for (int j = 0; j < points.get(i).size() - 1; ++j) {
                gr.drawLine(points.get(i).get(j).x, points.get(i).get(j).y,
                        points.get(i).get(j + 1).x, points.get(i).get(j + 1).y);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        newImage = (BufferedImage) (this.createImage(getWidth(), getHeight()));
        Graphics2D g2 = (Graphics2D) newImage.getGraphics();
        if(image != null) {
            g2.drawImage(image,0,0, getWidth(), getHeight(),this);
            g.drawImage(image,0,0, getWidth(), getHeight(),this);
        }
        draw(g2);
        draw((Graphics2D) g);
        g2.dispose();
    }
}
