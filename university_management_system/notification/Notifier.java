package by.bsu.shabunya.unymanagsyst.notification;

import by.bsu.shabunya.unymanagsyst.entity.Student;

import java.util.Set;

public class Notifier {

    private final Set<Student> notifiables;

    public Notifier(Set<Student> notifiables) {
        this.notifiables = notifiables;
    }

    public void doNotifyAll(String message) {
        for(Student student : notifiables) {
            student.notify(message);
        }
    }
}
