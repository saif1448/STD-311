package org.saif.experiment.sandfall.StreamExamples;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EmployeeStreamExample1 {

    public static void main(String[] args) throws IOException {
        List<Employee> employeeData = EmployeeDataLoader.loadEmployeeData("D:\\Saif\\Teaching\\StudentCourseCodeExamples\\STD-311\\STD-311Practice\\LambdaExpressionPracticeN\\src\\main\\java\\org\\saif\\experiment\\sandfall\\StreamExamples\\employees_100.csv");

        System.out.println("----------------Employee Data----------------------");
        System.out.println();

        employeeData.forEach(System.out::println);

        System.out.println("-------------------Filtering Examples--------------------------------");

        // Filter employees in the "HR" department and print their details
        System.out.println("---------------Employees in HR Department----------------");
        employeeData.stream()
                .filter(e -> e.getDepartment().equals("HR")) // intermediate operation
                .filter(e -> e.getExperience() >= 2 && e.getExperience() <= 10) // intermediate operation
                .forEach(System.out::println); // terminal operation

        List<Employee> output2 = employeeData.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .filter(e -> e.getLocation().equals("San Francisco"))
                .toList(); // terminal operation

        System.out.println(output2);


        System.out.println("-------------------Map Examples--------------------------------");
        System.out.println("---------------Employee Names of IT Dept in Capital Case----------------");
        output2.stream()
                .map(e -> e.getName().toUpperCase())
                .map(String::length)
                .forEach(System.out::println);

        AtomicInteger count = new AtomicInteger(1);
//        int count = 1; // we cannot use that because of functional interface, as the interface is gonna make it final and immutable
        employeeData.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .map(e -> count.getAndIncrement() +"."+ e.getName().toUpperCase())
                .forEach(System.out::println);

        System.out.println("-------------------Sort Examples--------------------------------");
        System.out.println("---------------Employee Names of IT Dept in Capital Case Sorted by Salary In Los Angeles----------------");

        employeeData.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .filter(e -> e.getLocation().equals("Los Angeles"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        //-----------------------------
        System.out.println("-------------------Collect Examples--------------------------------");

        // Grouping By Example --> Map<String, List<Employee>>
        var employeesByDept = employeeData.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDept.forEach((dept, empList) -> {
            System.out.print(dept + " has: ");
            empList.forEach(e -> System.out.print(e.getName() + ", "));
            System.out.println();
        });

        //Grouped by avg Salary by Department --> Map<String, Double>
        var avgSalaryByDept = employeeData.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        avgSalaryByDept.forEach((dept, avgSalary) -> {
            System.out.println(dept + " has average salary: " + String.format("%.2f", avgSalary));
        });
    }
}
