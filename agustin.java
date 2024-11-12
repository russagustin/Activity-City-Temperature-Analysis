import java.util.Random;

public class Main {

    static int[][] temperatures = new int[7][5]; // 7 days and 5 cities
    static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static String[] cities = {"Tacloban", "Palo", "Calbiga", "Tanauan", "Bacubac"};

    public static void main(String[] args) {
        fillTemperatures(); // Fill the temperatures with random values
        displayTemperatures(); // Display the temperatures
        averageTemperaturePerCity(); // Calculate and display average temperatures per city
        hottestDay(); // Find and display the hottest day
        coldestDay(); // Find and display the coldest day
    } 

    public static void fillTemperatures() {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) { // Loop through days
            for (int j = 0; j < 5; j++) { // Loop through cities
                temperatures[i][j] = rand.nextInt(16) + 20; // Random temperature between 20 and 35
            }
        }
    }

    public static void displayTemperatures() {
        System.out.println("Temperatures (°C):");
        System.out.print("           "); 
        for (String city : cities) {
            System.out.printf("%8s", city); // Print city names
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.printf("%-10s", days[i]); // Print day names with spacing
            for (int j = 0; j < 5; j++) {
                System.out.printf("%8d", temperatures[i][j]); // Print temperature values aligned
            }
            System.out.println();
        }
    }

    public static void averageTemperaturePerCity() {
        System.out.println("\nAverage Temperature per City:");
        for (int city = 0; city < 5; city++) {
            int sum = 0;
            for (int day = 0; day < 7; day++) {
                sum += temperatures[day][city]; // Sum temperatures for each city
            }
            double avg = sum / 7.0; // Calculate average
            System.out.printf("%s: %.2f°C%n", cities[city], avg); // Print average temperature
        }
    }

    public static void hottestDay() {
        int maxTemp = Integer.MIN_VALUE; // Initialize max temperature
        String hottestDay = "";
        String hottestCity = "";
        
        for (int i = 0; i < 7; i++) { // Loop through days
            for (int j = 0; j < 5; j++) { // Loop through cities
                if (temperatures[i][j] > maxTemp) { // Check for new max temperature
                    maxTemp = temperatures[i][j];
                    hottestDay = days[i];
                    hottestCity = cities[j];
                }
            }
        }
        
        System.out.printf("\nHottest Day: %s, %s with %d°C%n", hottestDay, hottestCity, maxTemp); // Print hottest day
    }

    public static void coldestDay() {
        int minTemp = Integer.MAX_VALUE; // Initialize min temperature
        String coldestDay = "";
        String coldestCity = "";
        
        for (int i = 0; i < 7; i++) { // Loop through days
            for (int j = 0; j < 5; j++) { // Loop through cities
                if (temperatures[i][j] < minTemp) { // Check for new min temperature
                    minTemp = temperatures[i][j];
                    coldestDay = days[i];
                    coldestCity = cities[j];
                }
            }
        }
        
        System.out.printf("\nColdest Day: %s, %s with %d°C%n", coldestDay, coldestCity, minTemp); // Print coldest day
    }
}
