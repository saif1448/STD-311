package org.saif.experiment.sandfall.StreamExamples;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAdvancedGroupingExamples {

    public static void main(String[] args) throws IOException {
        List<Employee> employeeData = EmployeeDataLoader.loadEmployeeData("employees_100.csv");

        System.out.println("=== ADVANCED GROUPING EXAMPLES ===\n");

        // 1. Group by Department
        System.out.println("1. GROUP BY DEPARTMENT");
        System.out.println("===================");
        Map<String, List<Employee>> employeesByDepartment = employeeData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((dept, employees) -> {
            System.out.println(dept + " Department (" + employees.size() + " employees):");
            employees.forEach(emp -> System.out.println("  - " + emp.getName() + " ($" + emp.getSalary() + ")"));
            System.out.println();
        });

        // 2. Group by Department and Location
        System.out.println("2. GROUP BY DEPARTMENT AND LOCATION");
        System.out.println("===================================");
        Map<String, Map<String, List<Employee>>> employeesByDeptAndLocation = employeeData.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.groupingBy(Employee::getLocation)
                ));

        employeesByDeptAndLocation.forEach((dept, locationMap) -> {
            System.out.println(dept + " Department:");
            locationMap.forEach((location, employees) -> {
                System.out.println("  " + location + " (" + employees.size() + " employees):");
                employees.forEach(emp -> System.out.println("    - " + emp.getName()));
            });
            System.out.println();
        });

        // 3. Group by Department with Average Salary
        System.out.println("3. GROUP BY DEPARTMENT WITH AVERAGE SALARY");
        System.out.println("==========================================");
        Map<String, Double> avgSalaryByDepartment = employeeData.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.averagingDouble(Employee::getSalary)
                ));

        avgSalaryByDepartment.forEach((dept, avgSalary) ->
            System.out.println(dept + ": $" + String.format("%.2f", avgSalary))
        );
        System.out.println();

        // 4. Group by Department with Employee Count
        System.out.println("4. GROUP BY DEPARTMENT WITH EMPLOYEE COUNT");
        System.out.println("=========================================");
        Map<String, Long> employeeCountByDepartment = employeeData.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.counting()
                ));

        employeeCountByDepartment.forEach((dept, count) ->
            System.out.println(dept + ": " + count + " employees")
        );
        System.out.println();

        // 5. Group skills by Department (simulated since Employee doesn't have skills field)
        System.out.println("5. GROUP EXPERIENCE LEVELS BY DEPARTMENT");
        System.out.println("=======================================");
        Map<String, Map<String, List<Employee>>> experienceLevelsByDept = employeeData.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.groupingBy(emp -> {
                        int exp = emp.getExperience();
                        if (exp < 2) return "Junior (0-1 years)";
                        else if (exp < 5) return "Mid-level (2-4 years)";
                        else return "Senior (5+ years)";
                    })
                ));

        experienceLevelsByDept.forEach((dept, expLevelMap) -> {
            System.out.println(dept + " Department:");
            expLevelMap.forEach((expLevel, employees) -> {
                System.out.println("  " + expLevel + ": " + employees.size() + " employees");
                employees.forEach(emp ->
                    System.out.println("    - " + emp.getName() + " (" + emp.getExperience() + " years)")
                );
            });
            System.out.println();
        });

        // 6. Group by Performance Rating Range (using salary as performance indicator)
        System.out.println("6. GROUP BY PERFORMANCE RATING RANGE (BASED ON SALARY)");
        System.out.println("=====================================================");
        Map<String, List<Employee>> employeesByPerformanceRange = employeeData.stream()
                .collect(Collectors.groupingBy(emp -> {
                    double salary = emp.getSalary();
                    if (salary < 60000) return "Low Performer ($0-$60K)";
                    else if (salary < 80000) return "Average Performer ($60K-$80K)";
                    else if (salary < 100000) return "High Performer ($80K-$100K)";
                    else return "Top Performer ($100K+)";
                }));

        employeesByPerformanceRange.forEach((range, employees) -> {
            System.out.println(range + " (" + employees.size() + " employees):");
            employees.forEach(emp ->
                System.out.println("  - " + emp.getName() + " (" + emp.getDepartment() +
                                  ", $" + emp.getSalary() + ")")
            );
            System.out.println();
        });

        // BONUS: Case-insensitive sorting example
        System.out.println("BONUS: CASE-INSENSITIVE SORTING BY NAME");
        System.out.println("======================================");
        List<Employee> sortedEmployees = employeeData.stream()
                .sorted(Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER))
                .limit(10) // Show only first 10 for brevity
                .collect(Collectors.toList());

        sortedEmployees.forEach(emp ->
            System.out.println(emp.getName() + " (" + emp.getDepartment() + ")")
        );
        System.out.println();

        // BONUS: Case-insensitive reverse sorting
        System.out.println("BONUS: CASE-INSENSITIVE REVERSE SORTING BY NAME");
        System.out.println("==============================================");
        List<Employee> reverseSortedEmployees = employeeData.stream()
                .sorted(Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER).reversed())
                .limit(10) // Show only first 10 for brevity
                .collect(Collectors.toList());

        reverseSortedEmployees.forEach(emp ->
            System.out.println(emp.getName() + " (" + emp.getDepartment() + ")")
        );
    }
}
