import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>();

        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Tesla Model S");
        models.add("Audi A6");
        models.add("BMW X5");
        models.add("Tesla Model 3");
        models.add("Toyota Camry");

        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).contains("Tesla")) {
                models.set(i, "ELECTRO_CAR");
            }
        }

        Set<String> unique = new HashSet<>(models);

        List<String> sorted = new ArrayList<>(unique);
        sorted.sort(Comparator.reverseOrder());

        System.out.println("Отсортированные модели:");
        for (String model : sorted) {
            System.out.println(model);
        }

        Set<String> finalSet = new HashSet<>(sorted);
    }
}