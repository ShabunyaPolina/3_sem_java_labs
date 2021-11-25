package by.bsu.shabunya.lab8.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Tab1 extends JPanel {

    int width;
    int height;

    private final String[] data1 = {"cat", "dog", "rat", "camel", "fox"};
    private final String[] data2 = {"bird", "snake", "mouse", "elephant", "rabbit", "turtle"};

    private final CustomListModel listModel1 =
            new CustomListModel(new ArrayList<>(Arrays.asList(data1)));
    private final CustomListModel listModel2 =
            new CustomListModel(new ArrayList<>(Arrays.asList(data2)));

    JList<String> list1 = new JList<>(listModel1);
    JList<String> list2 = new JList<>(listModel2);

    private final JPanel buttonsPanel = new JPanel();
    JButton from1to2button = new JButton("->");
    JButton from2to1button = new JButton("<-");

    public Tab1(int w, int h) {
        width = w;
        height = h;

        setLayout(new BorderLayout());

        add(list1, BorderLayout.WEST);
        add(buttonsPanel);
        add(list2, BorderLayout.EAST);

        fillTab();
        addActions();
    }

    private void fillTab() {
        Dimension d = new Dimension(width * 2 / 5, height);
        list1.setPreferredSize(d);
        list2.setPreferredSize(d);
        buttonsPanel.setLayout(new BorderLayout());
        from1to2button.setPreferredSize(new Dimension(100, height / 6));
        from2to1button.setPreferredSize(new Dimension(100, height / 6));
        buttonsPanel.add(from1to2button, BorderLayout.NORTH);
        buttonsPanel.add(from2to1button, BorderLayout.SOUTH);
    }

    private void addActions() {
        from1to2button.addActionListener(actionEvent -> {
            int[] selectedIndices = list1.getSelectedIndices();
            ArrayList<String> tmp = new ArrayList<>();
            for (int i = selectedIndices.length - 1; i >= 0; --i) {
                tmp.add(0, listModel1.getElementAt(selectedIndices[i]));
                listModel1.remove(selectedIndices[i]);
            }
            for (String element : tmp) {
                listModel2.add(element);
            }
        });
        from2to1button.addActionListener(actionEvent -> {
            int[] selectedIndices = list2.getSelectedIndices();
            ArrayList<String> tmp = new ArrayList<>();
            for (int i = selectedIndices.length - 1; i >= 0; --i) {
                tmp.add(0, listModel2.getElementAt(selectedIndices[i]));
                listModel2.remove(selectedIndices[i]);
            }
            for (String element : tmp) {
                listModel1.add(element);
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list2.removeSelectionInterval(0, listModel2.getSize() - 1);
            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list1.removeSelectionInterval(0, listModel1.getSize() - 1);
            }
        });
    }

    private static class CustomListModel extends AbstractListModel<String> {
        private final ArrayList<String> list;

        public CustomListModel(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public int getSize() {
            return list.size();
        }

        @Override
        public String getElementAt(int i) {
            return list.get(i);
        }

        public void add(String item) {
            list.add(item);
            fireIntervalAdded(this, list.size() - 1, list.size() - 1);
        }

        public void remove(int index) {
            list.remove(index);
            fireIntervalRemoved(this, index, index);
        }
    }
}
