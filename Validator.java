import java.util.Scanner;


//Валидатор с проверкой на целые числа

public class Validator {
  private static Scanner scanner = new Scanner(System.in);


  public static int getNumber(String message) {
    while (true) {
      System.out.print(message);
      String input = scanner.nextLine().trim();

      if (input.isEmpty()) {
        System.out.println("Ошибка! Вы ничего не ввели. Попробуйте снова.");
        continue;
      }

      if (!isValidNumber(input)) {
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


  private static boolean isValidNumber(String input) {
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


  public static String getString(String message) {
    System.out.print(message);
    return scanner.nextLine().trim();
  }


  public static int getMenuChoice() {
    return getNumber("\nВыберите задание (1-6) или 0 для выхода: ");
  }


  public static void closeScanner() {
    scanner.close();
  }
}