package stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aarav", "Engineering", 75000),
                new Employee("Vikram", "Engineering", 82000),
                new Employee("Arjun", "Engineering", 68000),
                new Employee("Rahul", "HR", 50000),
                new Employee("Rohan", "HR", 55000),
                new Employee("Ananya", "Finance", 690000),
                new Employee("Sneha", "Finance", 690000),
                new Employee("Aisha", "Marketing", 60000),
                new Employee("Priya", "Sales", 65000),
                new Employee("Aman", "Sales", 70000)
        );
// Q : From a list of employees, find all distinct department names.
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
//    Q  :Group employees by department using Collectors.groupingBy.
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + " : " +
                    empList.stream().map(Employee::getName).collect(Collectors.joining(", ")));
        });

//  Q: Find the employee with the highest salary in each department.
        Map<String, Employee> highestByDept = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors
                                        .maxBy(Comparator
                                                .comparingDouble(Employee::getSalary)
                                                .thenComparing(Employee::getName))
                                        ,Optional::get)
                        )
                );

        highestByDept.forEach((d,e)->System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getSalary() ));

    }
}
