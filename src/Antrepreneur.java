public class Antrepreneur {

    private Integer id;
    private String name;
    private Double money;

    private String ocupation;

    public Antrepreneur(Integer id, String name, Double money, String ocupation) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.ocupation = ocupation;
    }
    public Antrepreneur(){

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

    public String getOcupation() {
        return ocupation;
    }

    @Override
    public String toString() {
        return "Antrepreneur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", ocupation='" + ocupation + '\'' +
                '}';
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }
}
