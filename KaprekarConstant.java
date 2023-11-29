import java.util.*;
import java.lang.*;

public class KaprekarConstant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Input according to Kaprekar conditions");
        String input = scanner.next();
        KaprekarConstant kaprekarConstantObject = new KaprekarConstant();
        if (!kaprekarConstantObject.isInputValid(input)) {
            System.out.println("Correct the input and run the program again");
        }else {
            System.out.println("The number of steps needed to achieve 6174 is : " +
                    kaprekarConstantObject.getNumberOfStepsNeeded(input));
        }
    }

    private boolean isInputValid(String input) {
        return checkInputSize(input) && checkThereAreNumbersOnly(input) &&
                checkAllNumberAreSame(input);
    }

    private boolean checkInputSize(String input) {
        if (input.length() != 4) {
            System.out.println("Please input four digit number(leading zeros are allowed)");
            return false;
        }
        return true;
    }

    private boolean checkThereAreNumbersOnly(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) < '0' || input.charAt(index) > '9') {
                System.out.println("Please input numbers only");
                return false;
            }
        }
        return true;
    }

    private boolean checkAllNumberAreSame(String input) {
        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(0) != input.charAt(index)) {
                return true;
            }
        }
        System.out.println("Use at least two different digits");
        return false;
    }

    private int getNumberOfStepsNeeded(String input) {
        int numberOfStepsNeeded = 0;
        while (!Objects.equals(input, "6174")) {
            String inputInAscendingOrder = prepareInputInAscendingOrder(input);
            String inputInDescendingOrder = prepareInputInDescendingOrder(input);
            input = Utility.subtractNumberStrings(inputInAscendingOrder, inputInDescendingOrder);
            input = input.length()==4?input:prepareValidInput(input);
            numberOfStepsNeeded++;
        }
        return numberOfStepsNeeded;
    }

    private String prepareInputInAscendingOrder(String input) {
        char[] tempArray;
        tempArray = input.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private String prepareInputInDescendingOrder(String input) {
        char[] tempArray;
        tempArray = input.toCharArray();
        Utility.customSortDescending(tempArray);
        return new String(tempArray);
    }

    private String prepareValidInput(String input) {
        String leadingZeros;
        leadingZeros = "0".repeat(Math.max(0, 4 - input.length()));
        input = leadingZeros + input;
        return input;
    }
}