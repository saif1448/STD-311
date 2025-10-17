package org.saif.experiment.sandfall.StreamExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeDataLoader {

    public static List<Employee> loadEmployeeData(String fileName) throws IOException {
        // Use relative path from the current package
        String filePath = "src/main/java/org/saif/experiment/sandfall/StreamExamples/" + fileName;
        return Files.lines(Paths.get(filePath))
                .skip(1) // skipping the header row
                .map(line -> line.split(","))
                .map(rowData -> new Employee(  //rowData is an array of String
                        Integer.parseInt(rowData[0]), //Id ---> Integer
                        rowData[1], //Name  ----> String
                        rowData[2], //Department ---> String
                        Double.parseDouble(rowData[3]), //Salary ---> Double
                        Integer.parseInt(rowData[4]), //Experience ---> Integer
                        rowData[5] //Location ---> String
                ))
                .collect(Collectors.toList());
    }

    public static List<Employee2> loadEmployeeData2(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .skip(1) // Skip header
                .map(line -> {
                    String[] fields = line.split(",");
                    int id = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    String department = fields[2];
                    double salary = Double.parseDouble(fields[3]);
                    int age = Integer.parseInt(fields[4]);
                    LocalDate joinDate = LocalDate.parse(fields[5], DateTimeFormatter.ISO_DATE);
                    int projectsCompleted = Integer.parseInt(fields[6]);
                    double performanceRating = Double.parseDouble(fields[7]);
                    List<String> skills = Arrays.asList(fields[8].split(","));

                    return new Employee2(id, name, department, salary, age, joinDate,
                            projectsCompleted, performanceRating, skills);
                })
                .collect(Collectors.toList());
    }

}
