package by.bsu.shabunya.unymanagsyst.program;

import by.bsu.shabunya.unymanagsyst.entity.*;
import by.bsu.shabunya.unymanagsyst.file.Writer;
import by.bsu.shabunya.unymanagsyst.notification.Notifier;
import by.bsu.shabunya.unymanagsyst.structure.Course;
import by.bsu.shabunya.unymanagsyst.window.Frame;

import java.util.HashSet;
import java.util.Set;

public class ProgrammingTest {
    public static void main(String[] args) {

        Set<Postgraduate> postgraduates = new HashSet<>();
        Set<Undergraduate> undergraduates = new HashSet<>();

        Academic deitel = new Academic("Paul Deitel");
        Academic horstmann = new Academic("Cay Horstmann");

        Undergraduate u1 = new Undergraduate(
                "Polina Shabunya", "gg4", "fjdn.mail", deitel);
        Undergraduate u2 = new Undergraduate(
                "Valeriya Pulkina", "pr3", "dsdfk.mail", horstmann);
        Postgraduate p1 = new Postgraduate(
                "Dmitry Vezhnovets", "te2", "ffjdkf.mail", deitel);
        Postgraduate p2 = new Postgraduate(
                "Maria Bayok", "yi34", "fgjo.mail", horstmann);
        Postgraduate p3 = new Postgraduate(
                "Yaroslav Pocheshinsky", "jj8", "gznznz.mail", horstmann);

        Set<Student> students = new HashSet<>(undergraduates);
        students.addAll(postgraduates);

        Course course = new Course("Linear algebra", postgraduates, undergraduates, students);

        course.addPostgraduate(p1);
        course.addPostgraduate(p2);
        course.addPostgraduate(p3);
        course.addUndergraduate(u1);
        course.addUndergraduate(u2);

        System.out.println(course.getPostgraduates("Cay Horstmann"));
        System.out.println();

        Notifier notifier = new Notifier(students);
        notifier.doNotifyAll("Hello, Students!");

        System.out.println();
        for(Student student : course) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println(course.getCertainStudents(x -> x.getLogin().length() == 3));

        Writer writer = new Writer(course);
        writer.writeToFile("Course.txt");

        new Frame(course);
    }
}
