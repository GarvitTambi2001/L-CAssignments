import java.util.*;

public class SevenAgesOfLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        Age selectedAge;

        if (age <= 1) {
            selectedAge = new ChildAge(age);
        } else if (age <= 12) {
            selectedAge = new SchoolAge(age);
        } else if (age <= 19) {
            selectedAge = new AdolescentAge(age);
        } else if (age <= 50) {
            selectedAge = new AdultAge(age);
        } else if (age <= 65) {
            selectedAge = new MiddleAge(age);
        } else if (age <= 80) {
            selectedAge = new SeniorAge(age);
        } else {
            selectedAge = new ElderlyAge(age);
        }

        System.out.println(selectedAge.describe());
    }
}
