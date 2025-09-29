package org.saif.experiment.sandfall.StreamExamples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Employee2 {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private LocalDate joinDate;
    private int projectsCompleted;
    private double performanceRating;
    private List<String> skills;


    public Employee2(int id, String name, String department, double salary, int age,
                     LocalDate joinDate, int projectsCompleted, double performanceRating,
                     List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.joinDate = joinDate;
        this.projectsCompleted = projectsCompleted;
        this.performanceRating = performanceRating;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }

    public double getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(double performanceRating) {
        this.performanceRating = performanceRating;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", joinDate=" + joinDate +
                ", projectsCompleted=" + projectsCompleted +
                ", performanceRating=" + performanceRating +
                ", skills=" + skills +
                '}';
    }

}