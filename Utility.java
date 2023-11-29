import java.math.*;
import java.util.*;

public class Utility {
    public static void customSortDescending(char[] array) {

        Character[] charObjects = new Character[array.length];
        for (int index = 0; index < array.length; index++) {
            charObjects[index] = array[index];
        }

        Arrays.sort(charObjects, Comparator.reverseOrder());

        for (int index = 0; index < array.length; index++) {
            array[index] = charObjects[index];
        }
    }

    public static String subtractNumberStrings(String num1, String num2) {
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);

        BigInteger difference = bigInteger2.subtract(bigInteger1);

        return difference.toString();
    }
}
