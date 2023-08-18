import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nBasic concepts with streams\n");

        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "Jeff Bezos", 100000.0);
        Employee employee2 = new Employee(2, "Bill Gates", 200000.0);
        Employee employee3 = new Employee(3, "Mark Zuckerberg", 300000.0);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        ArrayList<Antrepreneur> antrepreneurs;


        System.out.println("\nExample with peek, filter, map and collect");
        antrepreneurs = (ArrayList<Antrepreneur>) employees.stream()
                .peek(employee -> employee.setMoney(employee.getMoney() + 999))
                .filter(employee -> employee.getMoney() > 100000)
                .map(employee -> employee.becomeAntrepreneur(employee))
                .collect(Collectors.toList())

        ;

        System.out.println("\nExample with forEach");
        antrepreneurs.stream()
                .forEach(System.out::println)
        ;

        System.out.println("\nExample with findFirst");
        var firstAntrepreneur = antrepreneurs.stream().findFirst();
        System.out.println(firstAntrepreneur);

        System.out.println("\nExample with toArray");
        Employee[] employeesInArray = employees.stream()
                .toArray(Employee[]::new);
        Arrays.stream(employeesInArray).forEach(System.out::println);

        System.out.println("\nExample with flatmap");
        List<List<? extends ArrayList<?>>> combinedList = Arrays.asList(
                List.of(employees),
                List.of(antrepreneurs)
        );

        var resultOfCombinedList = combinedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        resultOfCombinedList.stream().forEach(System.out::println);



        System.out.println("\nAdvanced concepts with streams\n");

    }
}