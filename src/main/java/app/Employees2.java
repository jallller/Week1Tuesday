package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Employees2 {
    private String name;
    private int age;
    private String department;
    private double salary;
    private LocalDateTime birthday;

    @Override
    public String toString() {
        return "Employees2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Employees2(String name, int age, String department, double salary, LocalDateTime birthday) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int calculateAge() {
        LocalDateTime now = LocalDateTime.now();
        return Period.between(birthday.toLocalDate(), now.toLocalDate()).getYears();
    }
}
