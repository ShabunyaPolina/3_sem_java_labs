package by.bsu.shabunya.unymanagsyst.window;

import by.bsu.shabunya.unymanagsyst.entity.Academic;
import by.bsu.shabunya.unymanagsyst.entity.Postgraduate;
import by.bsu.shabunya.unymanagsyst.entity.Student;
import by.bsu.shabunya.unymanagsyst.entity.Undergraduate;
import by.bsu.shabunya.unymanagsyst.structure.Course;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CoursePanel extends JPanel {

    int width;
    int height;
    private final Course course;
    CustomListModel listModel1 = new CustomListModel(new ArrayList<>());
    CustomListModel listModel2 = new CustomListModel(new ArrayList<>());
    JRadioButton rBtn1 = new JRadioButton("Undergraduate");
    JRadioButton rBtn2 = new JRadioButton("Postgraduate");
    JTextField studentNameField = new JTextField("");
    JTextField studentLoginField = new JTextField("");
    JTextField studentEmailField = new JTextField("");
    JTextField academicNameField = new JTextField("");
    JButton btnAdd = new JButton("Add student");

    public CoursePanel(Course course, int w, int h) {
        width = w;
        height = h;

        this.course = course;

        setLayout(new BorderLayout());

        fillPanel();
        addActions();
    }

    private void fillPanel() {
        // heading
        JLabel heading = new JLabel("Course name: " + course.getName());
        heading.setFont(new Font("Serif", Font.PLAIN, 40));
        heading.setHorizontalAlignment(JLabel.CENTER);
        add(heading, BorderLayout.NORTH);

        // lists
        JPanel listsPanel = new JPanel(new GridLayout(1, 2));
        // list1
        JPanel undergrPanel = new JPanel(new BorderLayout());

        for (Student student : course.getUndergraduates(null)) {
            listModel1.add(student.toString());
        }
        JList<String> list1 = new JList<>(listModel1);
        JLabel l1 = new JLabel("Undergraduates:");
        l1.setFont(new Font("Serif", Font.PLAIN, 20));
        undergrPanel.add(l1, BorderLayout.NORTH);
        undergrPanel.add(list1, BorderLayout.CENTER);
        listsPanel.add(undergrPanel);

        // list 2
        JPanel postgrPanel = new JPanel(new BorderLayout());
        for (Student student : course.getPostgraduates(null)) {
            listModel2.add(student.toString());
        }
        JList<String> list2 = new JList<>(listModel2);
        JLabel l2 = new JLabel("Postgraduates:");
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        postgrPanel.add(l2, BorderLayout.NORTH);
        postgrPanel.add(list2, BorderLayout.CENTER);
        listsPanel.add(postgrPanel);
        add(listsPanel);

        // tools panel
        JPanel toolsPanel = new JPanel(new GridLayout(11, 1));
        toolsPanel.setPreferredSize(new Dimension(width / 3, height));
        add(toolsPanel, BorderLayout.EAST);
        ButtonGroup butGroup = new ButtonGroup();
        JPanel rBtnPanel = new JPanel(new GridLayout(1, 2));
        butGroup.add(rBtn1);
        butGroup.add(rBtn2);
        rBtnPanel.add(rBtn1);
        rBtnPanel.add(rBtn2);
        toolsPanel.add(rBtnPanel);

        toolsPanel.add(new JLabel("Student name:"));
        toolsPanel.add(studentNameField);
        toolsPanel.add(new JLabel("Student login:"));
        toolsPanel.add(studentLoginField);
        toolsPanel.add(new JLabel("Student email:"));
        toolsPanel.add(studentEmailField);
        toolsPanel.add(new JLabel("Academic name:"));
        toolsPanel.add(academicNameField);
        toolsPanel.add(new JLabel(""));
        toolsPanel.add(btnAdd);
    }

    private void addActions() {
        btnAdd.addActionListener(actionEvent -> {
            if (!rBtn1.isSelected() && !rBtn2.isSelected()) {
                showDialogException("Select the kind of student");
            } else {
                Student student;
                if (rBtn1.isSelected()) {
                    try {
                        student = new Undergraduate(
                                studentNameField.getText(),
                                studentLoginField.getText(),
                                studentEmailField.getText(),
                                new Academic(academicNameField.getText()));
                        listModel1.add(student.toString());
                    } catch (NumberFormatException e) {
                        showDialogException("Fill in all the fields");
                    }
                } else {
                    try {
                        student = new Postgraduate(
                                studentNameField.getText(),
                                studentLoginField.getText(),
                                studentEmailField.getText(),
                                new Academic(academicNameField.getText()));
                        listModel2.add(student.toString());
                    } catch (NumberFormatException e) {
                        showDialogException("Fill in all the fields");
                    }
                }

            }
        });

    }

    private void showDialogException(String message) {
        JOptionPane.showMessageDialog(this, message);
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
