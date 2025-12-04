import java.util.*;
import java.util.stream.Collectors;

class Car {
    String model;
    String manufacturer;
    int year;
    int mileage;
    double price;

    public Car(String model, String manufacturer, int year, int mileage, double price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return model + " | " + manufacturer + " | " + price + "$ | " + mileage + "km";
    }
}

public class Task4 {
    public static void main(String[] args) {
        List<Machine> machines = new ArrayList<>();

        machines.add(new Machine("Camry", "Toyota", 2020, 40000, 25000));
        machines.add(new Machine("X5", "BMW", 2022, 30000, 65000));
        machines.add(new Machine("Model S", "Tesla", 2023, 15000, 80000));
        machines.add(new Machine("A6", "Audi", 2018, 70000, 45000));
        machines.add(new Machine("Civic", "Honda", 2021, 20000, 22000));
        machines.add(new Machine("G-Class", "Mercedes", 2023, 10000, 130000));

        // Машины с пробегом < 50000
        List<Machine> lowMileage = machines.stream()
                .filter(c -> c.getMileage() < 50000)
                .collect(Collectors.toList());

        System.out.println("Машины с пробегом < 50000:");
        lowMileage.forEach(System.out::println);

        // Топ 3 самые дорогие
        System.out.println("\nТоп 3 самых дорогих:");
        machines.stream()
                .sorted(Comparator.comparing(Machine::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        // Средний пробег
        double avgMileage = machines.stream()
                .mapToInt(Machine::getMileage)
                .average()
                .orElse(0);

        System.out.println("\nСредний пробег: " + avgMileage);

        // Группировка по производителю
        Map<String, List<Machine>> grouped = machines.stream()
                .collect(Collectors.groupingBy(Machine::getManufacturer));

        System.out.println("\nГруппировка по производителю:");
        grouped.forEach((manufacturer, list) -> {
            System.out.println(manufacturer + ":");
            list.forEach(System.out::println);
        });
    }
}

