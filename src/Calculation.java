public class Calculation {
    public static double fireCalculator(int year) {
        double[] moex = Constants.MOEX_RATE;
        double[] inflation = Constants.INFLATION_RATE;
        double percent = 0.5;
        double capital = 100;

        while (capital > 0) {
            double rate = capital * percent / 100;
            capital = (capital - rate) * moex[(year - 2001)] / moex[(year - 2002)];
            for (int i = year - 2002 + 1; i < 20; i++) {
                rate *= 1 + inflation[i] / 100;
                capital = (capital - rate) * moex[i + 1] / moex[i];
            }
            if (capital > 0) {
                percent += 0.5;
            } else {
                percent -= 0.5;
                break;
            }
        }
        return percent;
    }
}
