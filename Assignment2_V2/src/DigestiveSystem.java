import java.util.Scanner;

public class DigestiveSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stomach stomach = new Stomach();
        SmallIntestine smallIntestine = new SmallIntestine();

        System.out.println("Welcome to the Digestive System Simulator!");

        runDigestiveSimulation(stomach, smallIntestine, scanner);

        scanner.close();
        System.out.println("Exiting the Digestive System Simulator. Goodbye!");
    }

    private static void runDigestiveSimulation(Stomach stomach, SmallIntestine smallIntestine, Scanner scanner) {

        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("Enter the name of the food you are eating (or 'exit' to quit):");
            String foodName = scanner.nextLine().trim().toLowerCase();

            if (foodName.equals("exit")) {
                exitRequested = true;
            } else {
                processFood(stomach, smallIntestine, foodName);
            }
        }
    }

    private static void processFood(Stomach stomach, SmallIntestine smallIntestine, String foodName) {
        stomach.processFood(foodName);
        smallIntestine.processFood(foodName);
    }
}