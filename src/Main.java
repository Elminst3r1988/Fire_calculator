import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String year = sc.nextLine();
        sc.close();

        if (Validation.yearCheck(year)) {
            System.out.println(Calculation.fireCalculator(year));
        }
    }



}
