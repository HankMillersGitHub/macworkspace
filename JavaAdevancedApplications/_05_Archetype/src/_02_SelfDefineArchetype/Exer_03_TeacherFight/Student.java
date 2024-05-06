package _02_SelfDefineArchetype.Exer_03_TeacherFight;

public class Student<E> {
    String name;
    E grade;

    public Student(String name, E grade) {
        this.name = name;
        this.grade = grade;
    }
}
