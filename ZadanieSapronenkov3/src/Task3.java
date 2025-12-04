import java.util.*;

class Machine implements Comparable<Machine> {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;

    public Machine(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Machine)) return false;
        Machine machine = (Machine) obj;
        return vin.equals(machine.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public int compareTo(Machine o) {
        return Integer.compare(o.year, this.year); // от новых к старым
    }

    @Override
    public String toString() {
        return model + " (" + year + ") VIN: " + vin;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Set<Machine> machines = new HashSet<>();

        machines.add(new Machine("VIN123", "Camry", "Toyota", 2020, 40000, 25000));
        machines.add(new Machine("VIN124", "X5", "BMW", 2022, 30000, 60000));
        machines.add(new Machine("VIN123", "Camry", "Toyota", 2021, 10000, 30000)); // Дубликат
        machines.add(new Machine("VIN125", "A6", "Audi", 2019, 60000, 45000));

        System.out.println("HashSet (без дубликатов):");
        for (Machine machine : machines) {
            System.out.println(machine);
        }

        List<Machine> sortedList = new ArrayList<>(machines);
        Collections.sort(sortedList);

        System.out.println("\nОтсортировано по году (от новых к старым):");
        for (Machine machine : sortedList) {
            System.out.println(machine);
        }
    }
}

