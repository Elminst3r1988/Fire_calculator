import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String year = sc.nextLine();
        sc.close();

        if (yearCheck(year)) {
            System.out.println(fireCalculator(year));
        }
    }


    public static boolean yearCheck(String year) {
        try {
            int check = Integer.parseInt(year);
            if (check > 2001 && check < 2022) {
                return true;
            } else {
                throw new Exception("Wrong input");

            }
        } catch (Exception ex) {
            System.out.println("Wrong input");
            return false;
        }
    }

    public static double fireCalculator(String year) {
        double[] moex = Constants.MOEX_RATE;
        double[] inflation = Constants.INFLATION_RATE;
        int yearToStart = Integer.parseInt(year);
        double percent = 0.5;
        double capital = 100;

        while (capital > 0) {
            double rate = capital * percent / 100;
            capital = (capital - rate) * moex[(yearToStart - 2001)] / moex[(yearToStart - 2002)];
            for (int i = yearToStart - 2002 + 1; i < 20; i++) {
                rate *= 1 + inflation[i] / 100;
                capital = (capital - rate) * moex[i + 1] / moex[i];
            }
            if (capital > 0) {
                percent += 0.5;
                capital = 100;
            } else {
                percent = percent - 0.5;
                break;
            }
        }
        return percent;
    }
}
