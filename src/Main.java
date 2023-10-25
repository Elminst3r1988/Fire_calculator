import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        sc.close();

        if (Validation.yearCheck(year)) {
            System.out.println(Calculation.fireCalculator(year));
        }
    }
}

