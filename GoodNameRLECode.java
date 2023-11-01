import java.util.Scanner;

public class TextCompression {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to compress: ");
        String text = scanner.nextLine();
        String compressedText = compress(text);
        System.out.println("Compressed Text: " + compressedText);
    }

    public static String compress(String text) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int index = 1; index <= text.length(); index++) {
            if (index == text.length() || text.charAt(index) != text.charAt(index - 1)) {
                compressed.append(count).append(text.charAt(index - 1));
                count = 1;
            } else {
                count++;
            }
        }

        return compressed.toString();
    }
}
