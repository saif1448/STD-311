package org.saif.experiment.sandfall.StreamExamples;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EmployeeStreamExample2 {

    public static void main(String[] args) throws IOException {
        List<Employee2> employeeData2 = EmployeeDataLoader.loadEmployeeData2("D:\\Saif\\Teaching\\StudentCourseCodeExamples\\STD-311\\STD-311Practice\\LambdaExpressionPracticeN\\src\\main\\java\\org\\saif\\experiment\\sandfall\\StreamExamples\\employess_200.csv");

//        AtomicInteger counter = new AtomicInteger(1);
//        employees.forEach(e -> {
//            System.out.println(counter.getAndIncrement() + ". " + e.getName());
//        });

        Scanner sc = new Scanner(System.in);
        boolean isProgramRunning = true;
        while (isProgramRunning) {
            System.out.println("Choose an option:");
            System.out.println("1. Show Name and Salary Pair"
                    + "\n2. Show Unique Skills in the Company"
                    + "\n3. Show Sum of Salaries"
                    + "\n4. Most Common Skills"

                    + "\n0. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                //map and flatmap
                case 1 -> showNameSalPair(employeeData2);
                case 2 -> showUniqueSkillSet(employeeData2);
                //reduce
                case 3 -> sumOfSalaries(employeeData2);
                case 4 -> mostCommonSkills(employeeData2);
                default -> isProgramRunning = false;
            }
        }

        //Map and Flatmap
        /*
            1. Name and Salary Pair
            2. Unique skills among the compnay
         */

        //--------------------------------------------------------------------------------------
        //reduce
        /*
            1. Sum of Salaries
            2. Find the most common skills
            3. Find the employee with most project
         */

        //Aggregation Operations
        /*
            1. Total Salary
            2. Average Salary
            3. Max Salary
            4. Statistics Summary ---> DoubleSummaryStatistics
            5. Count of Employees
         */

        //Grouping
        /*
            1. Group by Department
            2. Group by Department and Location
            3. Group by Department and Average Salary
            4. Group by Department with Employee Count
            5. Group skills by Department
            6. Group by performance rating range
         */

    }

    private static void showNameSalPair(List<Employee2> employeeData2) {
        System.out.println("---------------------Name and Salary Pair------------------------------");
        Map<String, Double> nameSalMap = employeeData2.stream()
                .collect(Collectors.toMap(Employee2::getName, Employee2::getSalary));

        nameSalMap.forEach((name, sal) -> System.out.println("{" + name + ":" + sal + "}"));

        System.out.println("-----------------------------------------------------------------------");
    }

    private static void showUniqueSkillSet(List<Employee2> employeeData2) {
        System.out.println("---------------------Unique Skills in the Company----------------------");
        var skillSets = employeeData2.stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .toList();

        AtomicInteger counter = new AtomicInteger(1);
        skillSets.forEach(skill -> System.out.println(counter.getAndIncrement() + ". " + skill));
        System.out.println("-----------------------------------------------------------------------");
    }

    //reduce
    private static void sumOfSalaries(List<Employee2> employeeData2) {
        System.out.println("---------------------Sum of Salaries----------------------");
        double sumOfSal = 0;
        sumOfSal = employeeData2.stream()
                .map(Employee2::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Sum of Salaries: " + String.format("%.2f", sumOfSal));
        System.out.println("-----------------------------------------------------------------------");
    }

    private static void mostCommonSkills(List<Employee2> employeeData2) {
//        var mostCommonSkill =
                employeeData2.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.groupingBy(
                        skill -> skill,
                        Collectors.counting()
                ))
                .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEach(e -> System.out.println("Skill Name: " + e.getKey() + ", Count: " + e.getValue()));
//                .reduce((s1, s2) -> s1.getValue() > s2.getValue() ? s1 : s2);
//        System.out.println("---------------------Most Common Skill----------------------");
//
//        int count =0 ;
//        mostCommonSkill.ifPresent(e -> {
//            System.out.println("Skill Name: " + e.getKey() + ", Count: " + e.getValue());
//
//        });
        System.out.println("-----------------------------------------------------------------------");
    }

}
