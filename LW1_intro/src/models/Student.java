package models;

public class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    int age;
    String group;

    public Student(){}

    public Student(String firstName, String lastName, int age, String group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString(){
        return String.format("%s %s age: %d group: %s", firstName, lastName, age, group);
    }

    @Override
    public boolean equals(Object student) {
        return ((Student) student).firstName.equals(this.firstName) && ((Student) student).lastName.equals(this.lastName);
    }


    @Override
    public int compareTo(Student other) {
        int ip1 = firstName.compareTo(other.firstName) ;
        if (ip1 > 0 || (ip1==0 && age> other.age) )
            return 1;
        else if (ip1 < 0 || (ip1 == 0 && age < other.age))
            return -1;
        return 0;
    }
}
