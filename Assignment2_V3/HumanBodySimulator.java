import java.util.Scanner;

public class HumanBodySimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Start Simulator");
            System.out.println("2. Stop Simulator");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Mouth mouth = new Mouth();
                    mouth.action();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
