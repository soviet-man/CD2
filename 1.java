import java.util.Scanner;

public class DFAEndingWithABC {
    public static boolean isAccepted(String input) {
        int state = 0; // Start at q0

        for (char c : input.toCharArray()) {
            switch (state) {
                case 0: // q0
                    if (c == 'a') state = 1;
                    break;
                case 1: // q1 (after 'a')
                    if (c == 'b') state = 2;
                    else if (c == 'a') state = 1;
                    else state = 0;
                    break;
                case 2: // q2 (after "ab")
                    if (c == 'c') state = 3;
                    else if (c == 'a') state = 1;
                    else state = 0;
                    break;
                case 3: // q3 (after "abc")
                    if (c == 'a') state = 1;
                    else state = 0;
                    break;
            }
        }
        return state == 3; // Accept if ending in q3
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        if (isAccepted(input)) {
            System.out.println("Accepted: The string ends with 'abc'");
        } else {
            System.out.println("Rejected: The string does not end with 'abc'");
        }

        scanner.close();
    }
}