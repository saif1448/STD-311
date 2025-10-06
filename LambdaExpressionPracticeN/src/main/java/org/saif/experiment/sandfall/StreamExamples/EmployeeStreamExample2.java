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
                    + "\n5. Employee with Most Project Completed"
                    + "\n6. Aggregate Sum of Salaries"
                    + "\n7. Aggregate Operation Example"
                    + "\n8. Aggregate Statistics Example"
                    + "\n9. Department Wise Salary Statistics"
                    + "\n10. Group by Department Example"
                    + "\n11. Group by Department and Age Example"
                    + "\n12. Group by Department and Average Salary Example"
                    + "\n13. Group by Department with Employee Count Example"
                    + "\n14. Group Skills by Department Example"
                    + "\n15. Group by Performance Rating Range Example"
                    + "\n16. Check if all employees have salary > 50000"
                    + "\n17. Check if any employee has completed more than 10 projects"
                    + "\n18. Find First Employee in HR Department"
                    + "\n19. Find Any Employee in IT Department"
                    + "\n0. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                //map and flatmap
                case 1 -> showNameSalPair(employeeData2);
                case 2 -> showUniqueSkillSet(employeeData2);
                //reduce
                case 3 -> sumOfSalaries(employeeData2);
                case 4 -> mostCommonSkills(employeeData2);
                case 5 -> mostProjectCompleted(employeeData2);
                //aggregate
                case 6 -> aggregateSumOfSalries(employeeData2);
                case 7 -> aggregateOperationExample(employeeData2);
                case 8 -> aggregateStatisticsExample(employeeData2);
                case 9 -> departmentWiseStatistics(employeeData2);
                //grouping
                case 10 -> groupByDepartmentExample(employeeData2);
                case 11 -> groupByDeptAndAge(employeeData2);
                case 12 -> groupByDeptAndAvgSal(employeeData2);
                case 13 -> groupByDeptWithEmpCount(employeeData2);
                case 14 -> groupSkillsByDepartment(employeeData2);
                case 15 -> groupByPerformanceRatingRange(employeeData2);
                //matching and finding
                case 16 -> ifAllSalaryGreater50000(employeeData2);
                case 17 -> ifAnyCompletedMore10Projects(employeeData2);
                case 18 -> findFirstHREmployee(employeeData2);
                case 19 -> findAnyITEmployee(employeeData2);
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
            5. Department wise Salary Statistics Summary
         */

        //Grouping
        /*
            1. Group by Department
            2. Group by Department and Age
            3. Group by Department and Average Salary
            4. Group by Department with Employee Count
            5. Group skills by Department
            6. Group by performance rating range
         */


        //Matching and Finding
        /*
            1. Check if all employees have salary > 50000
            2. Check if any employee has completed more than 10 projects
            3. Find the first employee in the list
            4. Find any employee from 'IT' department
         */


        //Partitioning
        /*
            1. Partition employees based on salary > 7000
            2. Partition employees based on skills containing 'Java'
         */
        //Parallel Streams
        /*
            1. Calculate sum of salaries using parallel stream
            2. Find max salary using parallel stream
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


    private static void mostProjectCompleted(List<Employee2> employeeData2){

        var mostProjectCompleted2 = employeeData2.stream()
                .reduce((e1, e2) -> e1.getProjectsCompleted() > e2.getProjectsCompleted() ? e1 : e2);

        System.out.println("---------------------Most Project Completed number----------------------");

        mostProjectCompleted2.ifPresent(e -> {
            System.out.println("Employee Name: " + e.getName() + ", Project Completed: " + e.getProjectsCompleted());
        });

        var mostProjectCompleted = employeeData2.stream()
                .collect(Collectors.toMap(e -> e.getName(), e -> e.getProjectsCompleted()))
//                .collect(Collectors.toMap(Employee2::getName, Employee2::getProjectsCompleted))
                .entrySet()
                .stream()
                .reduce((e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2);

        System.out.println("---------------------Most Project Completed----------------------");
        mostProjectCompleted.ifPresent(e -> {
            System.out.println("Employee Name: " + e.getKey() + ", Project Completed: " + e.getValue());
        });

        //just only number
        int noOfMostProjectCompleted = employeeData2.stream()
                .map(Employee2::getProjectsCompleted)
                .max(Integer::compare)
                .orElse(0);

        System.out.println("Most Project Completed Number: " + noOfMostProjectCompleted);
    }


    public static void aggregateSumOfSalries(List<Employee2> employeeData2) {
        double sumOfSal = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .sum();
        System.out.println("---------------------Sum of Salaries using aggregation----------------------");
        System.out.println("Sum of Salaries: " + String.format("%.2f", sumOfSal));
    }

    public static void aggregateOperationExample(List<Employee2> employeeData2) {

        // Sum of salaries using aggregation

        double sumOfSal = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .sum();
        System.out.println("---------------------Example of Aggregation----------------------");
        System.out.println("Sum of Salaries: " + String.format("%.2f", sumOfSal));

        // Average Salary
        double avgSal = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average Salary: " + String.format("%.2f", avgSal));

        // Max Salary

        double maxSal = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .max()
                .orElse(0.0);

        System.out.println("Max Salary: " + String.format("%.2f", maxSal));

        //Min Salary
        double minSal = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .min()
                .orElse(0.0);
        System.out.println("Min Salary: " + String.format("%.2f", minSal));

        var distinctSalary = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .distinct()
                .count();

        System.out.println("Distinct Salary Count: " + distinctSalary);
    }

    public static void aggregateStatisticsExample(List<Employee2> employeeData2) {
        DoubleSummaryStatistics statistics = employeeData2.stream()
                .mapToDouble(Employee2::getSalary)
                .summaryStatistics();

        System.out.println("---------------------Statistics Summary----------------------");
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + String.format("%.2f", statistics.getSum()));
        System.out.println("Min: " + String.format("%.2f", statistics.getMin()));
        System.out.println("Max: " + String.format("%.2f", statistics.getMax()));
        System.out.println("Average: " + String.format("%.2f", statistics.getAverage()));
        System.out.println("-----------------------------------------------------------------------");

    }

    public static void departmentWiseStatistics(List<Employee2> employeeData2) {
        var deptWiseStatistics = employeeData2.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.summarizingDouble(Employee2::getSalary)
                )).entrySet();

        System.out.println("---------------------Department Wise Salary Statistics----------------------");
        System.out.println("----------Dept Wise Max Salary----------------");
        deptWiseStatistics.forEach((e) -> System.out.println(e.getKey() + ": " + e.getValue().getMax()));

        System.out.println("----------Dept Wise Min Salary----------------");
        deptWiseStatistics.forEach((e) -> System.out.println(e.getKey() + ": " + e.getValue().getMin()));

        System.out.println("----------Dept Wise Average Salary----------------");
        deptWiseStatistics.forEach((e) -> System.out.println(e.getKey() + ": " + String.format("%.2f", e.getValue().getAverage())));

        System.out.println("-----------------------------------------------------------------------");
    }

    //Grouping Examples

    public static void groupByDepartmentExample(List<Employee2> employeeData2) {

        System.out.println("---------------------Group by Department Example----------------------");

        var groupByDept = employeeData2.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));

        groupByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(e -> System.out.println("\t" + e.getName()));
        });

        System.out.println("-----------------------------------------------------------------------");
    }

    public static void groupByDeptAndAge(List<Employee2> employeeData2) {

        System.out.println("---------------------Group by Department and Age Example----------------------");

        var groupByDeptAndAge = employeeData2.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.groupingBy(Employee2::getAge)
                        ));
        groupByDeptAndAge.forEach((dept, age) -> {
            System.out.println("Department: " + dept);
            age.forEach((ageKey, empList) -> {
                System.out.println("\tAge: " + ageKey);
                empList.forEach(e -> System.out.println("\t\t" + e.getName()));
            });
        });

        System.out.println("-----------------------------------------------------------------------");

    }


    public static void groupByDeptAndAvgSal(List<Employee2> employeeData2) {

        System.out.println("---------------------Group by Department and Average Salary Example----------------------");
        var groupByDeptAndAvgSal = employeeData2.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.averagingDouble(Employee2::getSalary)
                ));

        groupByDeptAndAvgSal.forEach((dept, avgSal) -> {
            System.out.println("Department: " + dept + ", Average Salary: " + String.format("%.2f", avgSal));
        });


        System.out.println("-----------------------------------------------------------------------");

    }

    public static void groupByDeptWithEmpCount(List<Employee2> employeeData2) {

        System.out.println("---------------------Group by Department with Employee Count Example----------------------");

        var countByDept = employeeData2.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.counting()
                ));

        countByDept.forEach((dept, count) -> {
            System.out.println("Department: " + dept + ", Employee Count: " + count);
        });

        System.out.println("-----------------------------------------------------------------------");

    }


    public static void groupSkillsByDepartment(List<Employee2> employeeData2) {
        System.out.println("---------------------Group Skills by Department Example----------------------");

        var groupSkillsByDepartment = employeeData2.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.flatMapping(
                                        e -> e.getSkills().stream(),
                                        Collectors.toSet()
                                )
                        ));
//        var groupSkillsByDepartment = employeeData2.stream()
//                .collect(Collectors.groupingBy(
//                        Employee2::getDepartment,
//                        Collectors.mapping(
//                                Employee2::getSkills,
//                                Collectors.flatMapping(Collection::stream, Collectors.toSet())
//                        )
//                ));

        groupSkillsByDepartment.forEach((dept, skills) -> {
            System.out.println("Department: " + dept);
            skills.forEach(skill -> System.out.println("\t" + skill));
        });

        System.out.println("-----------------------------------------------------------------------");
    }


    public static void groupByPerformanceRatingRange(List<Employee2> employeeData2) {
        System.out.println("---------------------Group by Performance Rating Range Example----------------------");

        var groupByPerformanceRatingRange = employeeData2.stream()
                        .collect(Collectors.groupingBy( e -> {
                            double rating = e.getPerformanceRating();
                            if (rating >= 4.7) return "Excellent";
                            else if (rating >= 4.5) return "Very Good";
                            else if (rating >= 4.2) return "Good";
                            else if (rating >= 4.0) return "Average";
                            else return "Below Average";
                        }
                        ));

        groupByPerformanceRatingRange.forEach((rating, emplList) ->{
            System.out.println("Performance Rating: " + rating);
            emplList.forEach(e -> System.out.println("\t" + e.getName() + ", Rating: " + e.getPerformanceRating()));
        });

        System.out.println("-----------------------------------------------------------------------");
    }

    // Matching and Finding Examples

    public static void ifAllSalaryGreater50000(List<Employee2> employeeData2) {
        System.out.println("---------------------Check if all employees have salary > 50000----------------------");
        var ifAllSalaryGreater50000 = employeeData2.stream()
                .allMatch(e -> e.getSalary() > 50000);
        System.out.println("All employees have salary > 50000: " + ifAllSalaryGreater50000);
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void ifAnyCompletedMore10Projects(List<Employee2> employeeData2) {
        System.out.println("---------------------Check if any employee has completed more than 10 projects----------------------");
        var ifAnyCompletedMore10Projects = employeeData2.stream()
                        .anyMatch(e -> e.getProjectsCompleted() > 10);
        System.out.println("Any employee has completed more than 10 projects: " + ifAnyCompletedMore10Projects);

        var employee = employeeData2.stream()
                    .filter(e -> e.getProjectsCompleted() > 10)
                    .findFirst(); // findAny can also be used
        employee.ifPresent(e -> {
            System.out.println("Employee Name: " + e.getName() + ", Projects Completed: " + e.getProjectsCompleted());
        });
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void findFirstHREmployee(List<Employee2> employeeData2) {
        System.out.println("---------------------Find First Employee in HR Department----------------------");
        var firstHREmployee = employeeData2.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .findFirst();
        firstHREmployee.ifPresent(e ->{
            System.out.println("Employee Name: " + e.getName() + ", Department: " + e.getDepartment());
        });
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void findAnyITEmployee(List<Employee2> employeeData2) {
        System.out.println("---------------------Find Any Employee in IT Department----------------------");
        var anyITEmployee = employeeData2.stream()
                        .filter(e -> e.getDepartment().equals("Engineering"))
                        .findAny();
        anyITEmployee
                .ifPresent(e -> {
                    System.out.println("Employee Name: " + e.getName() + ", Department: " + e.getDepartment());
                });
        System.out.println("-----------------------------------------------------------------------");
    }

}
