package by.bsu.shabunya.unymanagsyst.file;

import by.bsu.shabunya.unymanagsyst.entity.Student;
import by.bsu.shabunya.unymanagsyst.structure.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    Course course;

    public Writer(Course course) {
        this.course = course;
    }

    public void writeToFile(String fileName) {
        try (FileWriter fw = new FileWriter(new File(fileName))) {
            fw.write(course.getName() + ":\n");
            for(Student student : course) {
                fw.write(student.toString() + '\n');
            }
            fw.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
