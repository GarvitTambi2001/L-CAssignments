import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter txt to compres: ");
        String t = sc.nextLine();
        String c = "";

        char p = t.charAt(0);
        int n = 1;

        for (int i = 1; i < t.length(); i++) {
            char c1 = t.charAt(i);

            if (c1 == p) {
                n++;
            } else {
                c += n + "" + p;
                p = c1;
                n = 1;
            }
        }

        c += n + "" + p;

        System.out.println("Compressed Text: " + c);
    }
}
