package org.saif.experiment.sandfall.StreamExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeDataLoader {

    public static List<Employee> loadEmployeeData(String filePath) throws IOException {
//        List<Employee> employeeData =
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
//        return employeeData;
    }

}
