package by.bsu.shabunya.unymanagsyst.structure;

import by.bsu.shabunya.unymanagsyst.entity.Postgraduate;
import by.bsu.shabunya.unymanagsyst.entity.Student;
import by.bsu.shabunya.unymanagsyst.entity.Undergraduate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Course implements Iterable<Student> {

    private final Set<Postgraduate> postgraduates;
    private final Set<Undergraduate> undergraduates;
    private final Set<Student> students;
    private final String name;

    public Course(String name, Set<Postgraduate> postgraduates,
                  Set<Undergraduate> undergraduates, Set<Student> students) {
        this.name = name;
        this.postgraduates = postgraduates;
        this.undergraduates = undergraduates;
        this.students = students;
    }

    public Set<Postgraduate> getPostgraduates(String nameOfSupervisor) {
        if(nameOfSupervisor == null)
            return postgraduates;
        else {
            Set<Postgraduate> res = new HashSet<>();
            for (Postgraduate postgraduate : postgraduates) {
                if (postgraduate.getSupervisor().getName().equals(nameOfSupervisor)) {
                    res.add(postgraduate);
                }
            }
            return res;
        }
    }

    public Set<Undergraduate> getUndergraduates(String nameOfTutor) {
        if(nameOfTutor == null)
            return undergraduates;
        else {
            Set<Undergraduate> res = new HashSet<>();
            for (Undergraduate undergraduate : undergraduates) {
                if (undergraduate.getTutor().getName().equals(nameOfTutor)) {
                    res.add(undergraduate);
                }
            }
            return res;
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Student> getCertainStudents(Predicate<Student> predicate) {
        Set<Student> res = new HashSet<>();
        for(Student student : students) {
            if(predicate.test(student))
                res.add(student);
        }
        return res;
    }

    public String getName() {
        return name;
    }

    private void addStudent(Student student) {
        students.add(student);
    }

    public void addPostgraduate(Postgraduate postgraduate) {
        postgraduates.add(postgraduate);
        addStudent(postgraduate);
    }

    public void addUndergraduate(Undergraduate undergraduate) {
        undergraduates.add(undergraduate);
        addStudent(undergraduate);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
