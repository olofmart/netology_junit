
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final int FIRST_OPERATOR = 0;
        final int SECOND_OPERATOR = 2;
        boolean exit = false;
        MathOper mathOper = new MathOper();
        Scanner scanner = new Scanner(System.in);

        welcome();
        String inputString = null;
        String[] strings = null;

        while (!exit) {
            System.out.println("Введите выражение:");
            inputString = scanner.nextLine();
            if (inputString.equals("exit")) {
                System.out.println("Спасибо за использование нашей программы!");
                exit = true;
                continue;
            }
            strings = inputString.split(" ");

            try {
                inputDataAnalysis(strings);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }

            if (strings[1].equals("+")) {
                System.out.println(mathOper.addition(strings[FIRST_OPERATOR], strings[SECOND_OPERATOR]));
                continue;
            }

            if (strings[1].equals("-")) {
                System.out.println(mathOper.subtraction(strings[FIRST_OPERATOR], strings[SECOND_OPERATOR]));
                continue;
            }

            if (strings[1].equals("/")) {
                System.out.println(mathOper.division(strings[FIRST_OPERATOR], strings[SECOND_OPERATOR]));
                continue;
            }

            if (strings[1].equals("*")) {
                System.out.println(mathOper.multiplication(strings[FIRST_OPERATOR], strings[SECOND_OPERATOR]));
                continue;
            }
        }
    }

    private static void inputDataAnalysis (String[] strings) throws Exception {
        ConverRomToArab converRomToArab = new ConverRomToArab();

        if (strings.length != 3) {
            throw new Exception();
        }

        if (!strings[1].equals("+") && !strings[1].equals("/") &&
                !strings[1].equals("*") && !strings[1].equals("-")) {
            throw new Exception();
        }

        try {
            if (Integer.parseInt(strings[0]) > 10 || Integer.parseInt(strings[0]) < 0
                    || Integer.parseInt(strings[2]) > 10 || Integer.parseInt(strings[2]) < 0) {
                throw new Exception();
            }
        } catch (NumberFormatException e) {
            if (converRomToArab.convert(strings[0]) > 10 || converRomToArab.convert(strings[2]) > 10) {
                throw new Exception();
            }
        }

        try {
            if ((Integer.valueOf(strings[0]) > Integer.MIN_VALUE || Integer.parseInt(strings[0]) < Integer.MAX_VALUE) &&
                    (converRomToArab.convert(strings[2]) > 0)) {
                throw new Exception();
            }
        } catch (NumberFormatException e) {
            try {
                if ((converRomToArab.convert(strings[0]) > 0) &&
                        (Integer.valueOf(strings[2]) > Integer.MIN_VALUE || Integer.parseInt(strings[2]) < Integer.MAX_VALUE)) {
                    throw new Exception();
                }
            } catch (NumberFormatException n) {

            }
        }
    }

    private static void welcome () {
        System.out.println("Программа КАЛЬКУЛЯТОР");
        System.out.println("доступны операции c двумя операндами:  +  -  /  *");
        System.out.println("доступны операнды:  римские и целые арабские цифры от 1 до 10");
        System.out.println("формат ввода: a + b");
        System.out.println("для завершения программы введите: exit");
    }
}
