import javax.swing.plaf.FontUIResource;

public class Employee {

    private Integer id;
    private String name;
    private Double money;

    public Employee(int id, String name, double money) {
        this.id=id;
        this.name=name;
        this.money=money;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public static Antrepreneur becomeAntrepreneur(Employee employee){
        Antrepreneur futureAntrepreneur = new Antrepreneur();
        futureAntrepreneur.setId(employee.getId());
        futureAntrepreneur.setName(employee.getName());
        futureAntrepreneur.setMoney(employee.getMoney());
        futureAntrepreneur.setOcupation("Antrepreneur");
        return futureAntrepreneur;
    }
}
