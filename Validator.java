import java.util.Scanner;

//FIXME: п.21 лишний комментарий
//Валидатор с проверкой на целые числа
//FIXTO:

public class Validator {
    private static Scanner scanner = new Scanner(System.in);

    //FIXME: п.7 методы в PascalCase
    // public static int getNumber(String message) {
    //FIXTO:
    public static int GetNumber(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка! Вы ничего не ввели. Попробуйте снова.");
                continue;
            }

            //FIXME: п.7 PascalCase
            // if (!isValidNumber(input)) {
            //FIXTO:
            if (!IsValidNumber(input)) {
                System.out.println("Ошибка! Введите целое число. Пример: 5 или -10");
                continue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Неправильный формат числа. Пример: 5 или -10");
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static boolean isValidNumber(String input) {
    //FIXTO:
    private static boolean IsValidNumber(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        if (input.equals("-")) {
            return false;
        }

        return true;
    }

    //FIXME: п.7 методы в PascalCase 
    // public static String getString(String message) {
    //FIXTO:
    public static String GetString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    //FIXME: п.7 методы в PascalCase 
    // public static int getMenuChoice() {
    //FIXTO:
    public static int GetMenuChoice() {
        return GetNumber("\nВыберите задание (1-6) или 0 для выхода: ");
    }

    //FIXME: п.7 методы в PascalCase
    // public static void closeScanner() {
    //FIXTO:
    public static void CloseScanner() {
        scanner.close();
    }
}
