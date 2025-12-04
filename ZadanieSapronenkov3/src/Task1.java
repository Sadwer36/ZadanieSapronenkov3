import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] years = new int[50];
        Random random = new Random();

        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + random.nextInt(26); // 2000–2025
        }

        System.out.println("Машины после 2015 года:");
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }

        int currentYear = 2025;
        int totalAge = 0;

        for (int year : years) {
            totalAge += (currentYear - year);
        }

        double averageAge = (double) totalAge / years.length;
        System.out.println("\nСредний возраст автомобилей: " + averageAge);
    }
}
