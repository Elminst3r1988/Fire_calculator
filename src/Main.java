import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double[] moex = Constants.MOEX_RATE;
        double[] inflation = Constants.INFLATION_RATE;


        // Нам нужно получить ввод от пользователя
        Scanner sc = new Scanner(System.in);
        String year = sc.nextLine();
        sc.close();
        boolean digitCheck = true;
        // Проверяем было ли что-то введено
        if (year.isEmpty()) {
            System.out.println("Wrong input");
            digitCheck = false;
        }

        // Проверяем есть ли другие символы кроме цифр во вводе
        for (int i = 0; i < year.length(); i++) {
            if (!Character.isDigit(year.charAt(i))) {
                System.out.println("Wrong input");
                digitCheck = false;
                break;
            }
        }
        // Если строка не пустая и в ней нет посторонних символов преобразуем строку в число
        if (digitCheck) {
            int yearToStart = Integer.parseInt(year);
            // Проверяем попадает ли число в диапазон заданный в условии задачи
            if (yearToStart < 2002 || yearToStart > 2021) {
                System.out.println("Wrong input");
            } else {
                //Задаем стартовый процент, т.к. шаг в пол процента, начинаем с 0.5 процента
                double percent = 0.005;
                double capital = 100;
                //До тех пор пока не выполнится наше условие цикл будет выполняться
                while (true) {
                    // Определяем расход в первый год без инфляции и остаток капитала, с учетом мосбиржи в конце года
                    double rate = capital * percent;
                    capital = (capital - rate) * moex[(yearToStart - 2001)] / moex[(yearToStart - 2002)];
                    //Для остальных лет до 2022 тоже самое, но учитываем инфляцию наших расходов
                    for (int i = yearToStart - 2002 + 1; i < 20; i++) {
                        rate *= 1 + inflation[i] / 100;
                        capital = (capital - rate) * moex[i + 1] / moex[i];
                    }
                    //проверяем наш капитал при данном проценте, он должен быть больше 0 в 2022г.
                    if (capital > 0) {
                        percent += 0.005;
                        capital = 100;
                    } else {
                        // откатываем последнее прибавление 0.5 процента, т.к. капитал при таком проценте уже становится отрицательным
                        percent = (percent - 0.005) * 100;
                        break;
                    }
                }
                // Форматируем вид отображения процента, чтобы был 1 знак после запятой
                String formattedPercent = String.format("%.1f", percent);
                System.out.println((formattedPercent));

            }
        }

    }

}