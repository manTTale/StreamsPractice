import java.util.*;
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

        System.out.println("\nComparison Based Stream Operations");

        System.out.println("\nSorted");
        employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\nMax");
        Optional<Employee> richestEmployee = employees.stream()
                .max((e1, e2) -> (int) (e1.getMoney() - e2.getMoney()));
        System.out.println("Employee with most money " + richestEmployee);

        System.out.println("\nMin");
        Optional<Employee> poorestEmployee = employees.stream()
                .min((e1, e2) -> (int) (e1.getMoney() - e2.getMoney()));
        System.out.println("Employee with fewest money " + poorestEmployee);

        System.out.println("\nDistinct");
        List<Integer> listWithDuplicates = Arrays.asList(1,1,2,3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        listWithoutDuplicates.stream().forEach(System.out::println);


        System.out.println("\nallMatch, anyMatch, and noneMatch");
        boolean isJeffBezos = employees.stream()
                .anyMatch(employee -> employee.getName().contains("Jeff"));
        System.out.println(isJeffBezos);

        boolean isAntrepreneur = antrepreneurs.stream()
                .allMatch(antrepreneur -> antrepreneur.getOcupation().equals("Antrepreneur"));
        System.out.println(isAntrepreneur);

        boolean isBrokie = antrepreneurs.stream()
                .noneMatch(brokie -> brokie.getMoney() > 999999999);
        System.out.println(isBrokie);




    }
}