public class Calculation {
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
