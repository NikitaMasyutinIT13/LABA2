import java.util.Arrays;


public class Main {
  private static Point point1, point2, point3;
  private static Line line1, line2, line3;
  private static Student studentVasya, studentPetya, studentAndrey, studentMaxim;

  public static void main(String[] args) {
    System.out.println("ПРОГРАММА ДЛЯ ВЫПОЛНЕНИЯ 6 ЗАДАНИЙ");

    showMenu();
    Validator.closeScanner();

    System.out.println("\nПРОГРАММА ЗАВЕРШЕНА");
  }

  private static void showMenu() {
    while (true) {
      System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
      System.out.println("1. Точка координат (3 точки с разными координатами)");
      System.out.println("2. Прямая (5 пунктов с линиями)");
      System.out.println("3. Студент (копирование оценок)");
      System.out.println("4. Создаем Точку (обязательные координаты)");
      System.out.println("5. Создаем Студента (разные конструкторы)");
      System.out.println("6. Студент отличник (средняя оценка и отличник)");
      System.out.println("0. Выход");

      int choice = Validator.getMenuChoice();

      switch (choice) {
        case 1:
          task1();
          break;
        case 2:
          task2();
          break;
        case 3:
          task3();
          break;
        case 4:
          task4();
          break;
        case 5:
          task5();
          break;
        case 6:
          task6();
          break;
        case 0:
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    }
  }

//ТОЧКА КООРДИНАТ

  private static void task1() {
    System.out.println("\nЗАДАНИЕ 1 - ТОЧКА КООРДИНАТ");
    System.out.println("Создание трех точек с разными координатами");
    System.out.println("Введите координаты с клавиатуры:\n");

    System.out.println("Точка 1:");
    int x1 = Validator.getNumber("Введите X: ");
    int y1 = Validator.getNumber("Введите Y: ");
    point1 = new Point(x1, y1);

    System.out.println("\nТочка 2:");
    int x2 = Validator.getNumber("Введите X: ");
    int y2 = Validator.getNumber("Введите Y: ");
    point2 = new Point(x2, y2);

    System.out.println("\nТочка 3:");
    int x3 = Validator.getNumber("Введите X: ");
    int y3 = Validator.getNumber("Введите Y: ");
    point3 = new Point(x3, y3);

    System.out.println("\nТочки успешно созданы!");
    System.out.println("Текстовое представление:");
    System.out.println("Точка 1: " + point1.toString());
    System.out.println("Точка 2: " + point2.toString());
    System.out.println("Точка 3: " + point3.toString());
  }

  //ПРЯМАЯ

  private static void task2() {
    System.out.println("\nЗАДАНИЕ 2 - ПРЯМАЯ");

    System.out.println("1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}");
    Point start1 = new Point(1, 3);
    Point end1 = new Point(23, 8);
    line1 = new Line(start1, end1);
    System.out.println("   " + line1);

    System.out.println("2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25");
    line2 = new Line(10, 5, 25);
    System.out.println("   " + line2);

    System.out.println("3. Линия 3 (начинается там же, где линия 1, заканчивается там же, где линия 2)");
    line3 = new Line(line1.getStart(), line2.getEnd());
    System.out.println("   " + line3);

    System.out.println("\n4. Изменение координат первой и второй линий");
    System.out.println("Текущее состояние линии 3: " + line3);

    System.out.println("\n--- Изменение Линии 1 ---");
    changeLineFromInput(line1);

    System.out.println("\n--- Изменение Линии 2 ---");
    changeLineFromInput(line2);

    System.out.println("\nПосле изменения линий 1 и 2:");
    System.out.println("Линия 1: " + line1);
    System.out.println("Линия 2: " + line2);
    System.out.println("Линия 3: " + line3);

    boolean line3ChangedCorrectly =
            line3.getStart().equals(line1.getStart()) &&
                    line3.getEnd().equals(line2.getEnd());

    if (line3ChangedCorrectly) {
      System.out.println("Линия 3 корректно изменилась согласно требованиям пункта 3");
    }

    System.out.println("\n5. Изменение координат первой линии без изменения третьей линии");
    changeLine1WithoutAffectingLine3();

    System.out.println("\nФинальное состояние:");
    System.out.println("Линия 1: " + line1);
    System.out.println("Линия 2: " + line2);
    System.out.println("Линия 3: " + line3);
  }

  private static void changeLine1WithoutAffectingLine3() {
    boolean success = false;

    while (!success) {
      System.out.println("\n--- Изменение Линии 1 без влияния на Линию 3 ---");
      System.out.println("Текущая Линия 1: " + line1);
      System.out.println("Текущая Линия 3: " + line3);

      Point originalFirstPoint = line1.getStart();
      Point line3StartBefore = new Point(line3.getStart().getX(), line3.getStart().getY());

      System.out.println("Введите новые координаты для Линии 1:");

      System.out.println("Начальная точка:");
      int startX = Validator.getNumber("Введите X начала: ");
      int startY = Validator.getNumber("Введите Y начала: ");

      System.out.println("Конечная точка:");
      int endX = Validator.getNumber("Введите X конца: ");
      int endY = Validator.getNumber("Введите Y конца: ");

      Point newStart1 = new Point(startX, startY);
      Point newEnd1 = new Point(endX, endY);

      line1.setStart(newStart1);
      line1.setEnd(newEnd1);

      System.out.println("После изменения:");
      System.out.println("Линия 1: " + line1);
      System.out.println("Линия 3: " + line3);

      boolean firstPointChanged = !originalFirstPoint.equals(line1.getStart());

      if (firstPointChanged) {
        System.out.println("\nОШИБКА: Первая точка первой линии изменилась!");
        System.out.println("Первая точка до: " + originalFirstPoint);
        System.out.println("Первая точка после: " + line1.getStart());
        System.out.println("Пожалуйста, введите координаты заново...");

        line1.setStart(originalFirstPoint);
        line1.setEnd(new Point(endX, endY));
      } else {
        System.out.println("\nПервая точка первой линии не изменилась!");
        success = true;
      }
    }
  }

  private static void changeLineFromInput(Line line) {
    System.out.println("Введите новые координаты:");

    System.out.println("Начальная точка:");
    int startX = Validator.getNumber("Введите X начала: ");
    int startY = Validator.getNumber("Введите Y начала: ");

    System.out.println("Конечная точка:");
    int endX = Validator.getNumber("Введите X конца: ");
    int endY = Validator.getNumber("Введите Y конца: ");

    line.getStart().setX(startX);
    line.getStart().setY(startY);
    line.getEnd().setX(endX);
    line.getEnd().setY(endY);

    System.out.println("Линия изменена: " + line);
  }

  //СТУДЕНТ
  private static void task3() {
    System.out.println("\n=== ЗАДАНИЕ 3 - СТУДЕНТ ===");

    System.out.println("1. Создать студента Васю с оценками: 3,4,5");
    int[] vasyaGrades = {3, 4, 5};
    studentVasya = new Student("Вася");
    studentVasya.setGradesDirect(vasyaGrades);
    System.out.println("   " + studentVasya);

    System.out.println("2. Создать студента Петю и скопировать оценки Васи");
    studentPetya = new Student("Петя");
    studentPetya.setGradesDirect(vasyaGrades);
    System.out.println("   " + studentPetya);

    System.out.println("3. Заменить первую оценку Пети на число 5");
    vasyaGrades[0] = 5;

    System.out.println("После изменения:");
    System.out.println("   " + studentVasya);
    System.out.println("   " + studentPetya);

    System.out.println("\nОбъяснение результата:");
    System.out.println("Оба студента имеют одинаковые оценки, потому что при копировании");
    System.out.println("мы скопировали ссылку на один и тот же массив оценок.");
    System.out.println("Изменение оценок у одного студента влияет на другого.");

    System.out.println("\n4. Создать студента Андрея с независимой копией оценок");
    int[] independentGrades = vasyaGrades.clone();
    studentAndrey = new Student("Андрей", independentGrades);
    System.out.println("   " + studentAndrey);

    vasyaGrades[1] = 2;
    System.out.println("После изменения второй оценки Васи:");
    System.out.println("   " + studentVasya);
    System.out.println("   " + studentPetya);
    System.out.println("   " + studentAndrey);
  }

  //СОЗДАЕМ ТОЧКУ
  private static void task4() {
    System.out.println("\n=== ЗАДАНИЕ 4 - СОЗДАЕМ ТОЧКУ ===");
    System.out.println("Создание точек с обязательными координатами:");

    Point point1 = new Point(3, 5);
    System.out.println("1. Точка с координатами 3;5: " + point1);

    Point point2 = new Point(25, 6);
    System.out.println("2. Точка с координатами 25;6: " + point2);

    Point point3 = new Point(7, 8);
    System.out.println("3. Точка с координатами 7;8: " + point3);

  }


  //Создаем Студента

  private static void task5() {
    System.out.println("\n=== ЗАДАНИЕ 5 - СОЗДАЕМ СТУДЕНТА ===");

    System.out.println("1. Студент Вася с оценками: 3,4,5");
    int[] vasyaGrades = {3, 4, 5};
    studentVasya = new Student("Вася", vasyaGrades);
    System.out.println("   " + studentVasya);

    System.out.println("2. Студент Максим без оценок");
    studentMaxim = new Student("Максим");
    System.out.println("   " + studentMaxim);

  }


  //Студент отличник

  private static void task6() {
    System.out.println("\n=== ЗАДАНИЕ 6 - СТУДЕНТ ОТЛИЧНИК ===");

    System.out.println("1. Студент Вася с оценками 3,4,5,4");
    int[] vasyaGrades = {3, 4, 5, 4};
    studentVasya = new Student("Вася", vasyaGrades);
    System.out.println("   " + studentVasya);

    System.out.println("2. Студент Петя с оценками 5,5,5,5");
    int[] petyaGrades = {5, 5, 5, 5};
    studentPetya = new Student("Петя", petyaGrades);
    System.out.println("   " + studentPetya);

    System.out.println("\n3. Информация о студентах:");

    System.out.println("Вася:");
    System.out.println("   Средний балл: " + studentVasya.getAverageGrade());
    System.out.println("   Отличник: " + (studentVasya.isExcellentStudent() ? "Да" : "Нет"));

    System.out.println("Петя:");
    System.out.println("   Средний балл: " + studentPetya.getAverageGrade());
    System.out.println("   Отличник: " + (studentPetya.isExcellentStudent() ? "Да" : "Нет"));
  }
}