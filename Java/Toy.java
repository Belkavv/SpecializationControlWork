import java.util.Objects;

public class Toy implements Comparable<Toy>{
    private int id;
    private double rate;
    private String name;

    public Toy(int id, String name, double rate) {
        this.id = id;
        this.rate = rate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "ID: " + this.id +
                " Name: " + this.name +
                " Rate: " + Math.round(this.rate * 100) + " %";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id && Double.compare(toy.rate, rate) == 0 && name.equals(toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate);
    }

    @Override
    public int compareTo(Toy o) {
        return Double.compare(o.getRate(), this.getRate());
    }
}
