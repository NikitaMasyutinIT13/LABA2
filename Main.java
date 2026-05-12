import java.util.Arrays;

public class Main {
    //FIXME: п.11 Использованы сокращения 
    // private static Point point1, point2, point3;
    // private static Line first_Line, second_Line, third_Line;
    //FIXTO:
    private static Point first_Point, second_Point, third_Point;
    private static Line first_Line, second_Line, third_Line;
    private static Student student_Vasya, student_Petya, student_Andrey, student_Maxim;

    public static void main(String[] args) {
        System.out.println("ПРОГРАММА ДЛЯ ВЫПОЛНЕНИЯ 6 ЗАДАНИЙ");

        ShowMenu();
        Validator.closeScanner();

        System.out.println("\nПРОГРАММА ЗАВЕРШЕНА");
    }

    //FIXME: п.7 Методы должны быть в PascalCase 
    // private static void showMenu() {
    //FIXTO:
    private static void ShowMenu() {
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
                    First_Task();
                    break;
                case 2:
                    Second_Task();
                    break;
                case 3:
                    Third_Task();
                    break;
                case 4:
                    Fourth_Task();
                    break;
                case 5:
                    Fifth_Task();
                    break;
                case 6:
                    Sixth_Task();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    //FIXME: п.7 Методы в PascalCase , п.11 без сокращений
    // private static void task1() {
    //FIXTO:
    private static void First_Task() {
        System.out.println("\nЗАДАНИЕ 1 - ТОЧКА КООРДИНАТ");
        System.out.println("Создание трех точек с разными координатами");
        System.out.println("Введите координаты с клавиатуры:\n");

        System.out.println("Точка 1:");
        //FIXME: п.11 Использованы сокращения 
        // int x1 = Validator.getNumber("Введите X: ");
        // int y1 = Validator.getNumber("Введите Y: ");
        // first_Point = new Point(x1, y1);
        //FIXTO:
        int first_X = Validator.getNumber("Введите X: ");
        int first_Y = Validator.getNumber("Введите Y: ");
        first_Point = new Point(first_X, first_Y);

        System.out.println("\nТочка 2:");
        //FIXME: п.11 Использованы сокращения 
        // int x2 = Validator.getNumber("Введите X: ");
        // int y2 = Validator.getNumber("Введите Y: ");
        // second_Point = new Point(x2, y2);
        //FIXTO:
        int second_X = Validator.getNumber("Введите X: ");
        int second_Y = Validator.getNumber("Введите Y: ");
        second_Point = new Point(second_X, second_Y);

        System.out.println("\nТочка 3:");
        //FIXME: п.11 Использованы сокращения 
        // int x3 = Validator.getNumber("Введите X: ");
        // int y3 = Validator.getNumber("Введите Y: ");
        // third_Point = new Point(x3, y3);
        //FIXTO:
        int third_X = Validator.getNumber("Введите X: ");
        int third_Y = Validator.getNumber("Введите Y: ");
        third_Point = new Point(third_X, third_Y);

        System.out.println("\nТочки успешно созданы!");
        System.out.println("Текстовое представление:");
        System.out.println("Точка 1: " + first_Point.toString());
        System.out.println("Точка 2: " + second_Point.toString());
        System.out.println("Точка 3: " + third_Point.toString());
    }

    //FIXME: п.7 Методы в PascalCase , п.11 названия без сокращений
    // private static void task2() {
    //FIXTO:
    private static void Second_Task() {
        System.out.println("\nЗАДАНИЕ 2 - ПРЯМАЯ");

        System.out.println("1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}");
        //FIXME: п.11 Использованы сокращения
        // Point start1 = new Point(1, 3);
        // Point end1 = new Point(23, 8);
        // first_Line = new Line(start1, end1);
        //FIXTO:
        Point first_Start_Point = new Point(1, 3);
        Point first_End_Point = new Point(23, 8);
        first_Line = new Line(first_Start_Point, first_End_Point);
        System.out.println("   " + first_Line);

        System.out.println("2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25");
        second_Line = new Line(10, 5, 25);
        System.out.println("   " + second_Line);

        System.out.println("3. Линия 3 (начинается там же, где линия 1, заканчивается там же, где линия 2)");
        third_Line = new Line(first_Line.GetStart(), second_Line.GetEnd());
        System.out.println("   " + third_Line);

        System.out.println("\n4. Изменение координат первой и второй линий");
        System.out.println("Текущее состояние линии 3: " + third_Line);

        System.out.println("\n--- Изменение Линии 1 ---");
        ChangeLineFromInput(first_Line);

        System.out.println("\n--- Изменение Линии 2 ---");
        ChangeLineFromInput(second_Line);

        System.out.println("\nПосле изменения линий 1 и 2:");
        System.out.println("Линия 1: " + first_Line);
        System.out.println("Линия 2: " + second_Line);
        System.out.println("Линия 3: " + third_Line);

        //FIXME: п.8 Переменные должны быть в camel_Case 
        // boolean ThirdLineChangedCorrectly =
        //FIXTO:
        boolean third_Line_Changed_Correctly =
            third_Line.GetStart().equals(first_Line.GetStart()) &&
            third_Line.GetEnd().equals(second_Line.GetEnd());

        if (third_Line_Changed_Correctly) {
            System.out.println("Линия 3 корректно изменилась согласно требованиям пункта 3");
        }

        System.out.println("\n5. Изменение координат первой линии без изменения третьей линии");
        ChangeFirstLineWithoutAffectingThird_Line();

        System.out.println("\nФинальное состояние:");
        System.out.println("Линия 1: " + first_Line);
        System.out.println("Линия 2: " + second_Line);
        System.out.println("Линия 3: " + third_Line);
    }

    //FIXME: п.7 Методы в PascalCase, п.8 переменные в camel_Case 
    // private static void ChangeFirstLineWithoutAffectingthird_Line() {
    //FIXTO:
    private static void ChangeFirstLineWithoutAffectingThird_Line() {
        //FIXME: п.8 переменные в camel_Case 
        // boolean success = false;
        //FIXTO:
        boolean success = false;

        while (!success) {
            System.out.println("\n--- Изменение Линии 1 без влияния на Линию 3 ---");
            System.out.println("Текущая Линия 1: " + first_Line);
            System.out.println("Текущая Линия 3: " + third_Line);

            //FIXME: п.8 Переменные пишутся в camel_Case 
            // Point originalFirstPoint = first_Line.GetStart();
            // Point third_LineStartBefore = new Point(third_Line.GetStart().getX(), third_Line.GetStart().getY());
            //FIXTO:
            Point original_First_Point = first_Line.GetStart();
            Point third_Line_Start_Before = new Point(third_Line.GetStart().getX(), third_Line.GetStart().getY());

            System.out.println("Введите новые координаты для Линии 1:");

            System.out.println("Начальная точка:");
            int start_X = Validator.getNumber("Введите X начала: ");
            int start_Y = Validator.getNumber("Введите Y начала: ");

            System.out.println("Конечная точка:");
            int end_X = Validator.getNumber("Введите X конца: ");
            int end_Y = Validator.getNumber("Введите Y конца: ");

            Point new_First_Point = new Point(start_X, start_Y);
            Point new_End_Point = new Point(end_X, end_Y);

            first_Line.SetStart(new_First_Point);
            first_Line.SetEnd(new_End_Point);

            System.out.println("После изменения:");
            System.out.println("Линия 1: " + first_Line);
            System.out.println("Линия 3: " + third_Line);

            //FIXME: п.8 Переменные пишутся в camel_Case 
            // boolean firstPointChanged = !originalFirstPoint.equals(first_Line.GetStart());
            //FIXTO:
            boolean first_Point_Changed = !original_First_Point.equals(first_Line.GetStart());

            if (first_Point_Changed) {
                System.out.println("\nОШИБКА: Первая точка первой линии изменилась!");
                System.out.println("Первая точка до: " + original_First_Point);
                System.out.println("Первая точка после: " + first_Line.GetStart());
                System.out.println("Пожалуйста, введите координаты заново...");

                first_Line.SetStart(original_First_Point);
                first_Line.SetEnd(new_End_Point);
            } else {
                System.out.println("\nПервая точка первой линии не изменилась!");
                success = true;
            }
        }
    }

    //FIXME: п.7 Методы в PascalCase 
    // private static void changeLineFromInput(Line line) {
    //FIXTO:
    private static void ChangeLineFromInput(Line line) {
        System.out.println("Введите новые координаты:");

        System.out.println("Начальная точка:");
        int start_X = Validator.getNumber("Введите X начала: ");
        int start_Y = Validator.getNumber("Введите Y начала: ");

        System.out.println("Конечная точка:");
        int end_X = Validator.getNumber("Введите X конца: ");
        int end_Y = Validator.getNumber("Введите Y конца: ");

        line.GetStart().setX(start_X);
        line.GetStart().setY(start_Y);
        line.GetEnd().setX(end_X);
        line.GetEnd().setY(end_Y);

        System.out.println("Линия изменена: " + line);
    }

    //FIXME: п.7 Методы в PascalCase 
    // private static void task3() {
    //FIXTO:
    private static void Third_Task() {
        System.out.println("\n=== ЗАДАНИЕ 3 - СТУДЕНТ ===");

        System.out.println("1. Создать студента Васю с оценками: 3,4,5");
        //FIXME: п.8 переменные в camel_Case
        // int[] vasyaGrades = {3, 4, 5};
        //FIXTO:
        int[] vasya_Grades = {3, 4, 5};
        student_Vasya = new Student("Вася");
        student_Vasya.setGradesDirect(vasya_Grades);
        System.out.println("   " + student_Vasya);

        System.out.println("2. Создать студента Петю и скопировать оценки Васи");
        student_Petya = new Student("Петя");
        student_Petya.setGradesDirect(vasya_Grades);
        System.out.println("   " + student_Petya);

        System.out.println("3. Заменить первую оценку Пети на число 5");
        vasya_Grades[0] = 5;

        System.out.println("После изменения:");
        System.out.println("   " + student_Vasya);
        System.out.println("   " + student_Petya);

        System.out.println("\nОбъяснение результата:");
        System.out.println("Оба студента имеют одинаковые оценки, потому что при копировании");
        System.out.println("мы скопировали ссылку на один и тот же массив оценок.");
        System.out.println("Изменение оценок у одного студента влияет на другого.");

        System.out.println("\n4. Создать студента Андрея с независимой копией оценок");
        //FIXME: п.8 переменные в camel_Case 
        // int[] independentGrades = vasya_Grades.clone();
        //FIXTO:
        int[] independent_Grades = vasya_Grades.clone();
        student_Andrey = new Student("Андрей", independent_Grades);
        System.out.println("   " + student_Andrey);

        vasya_Grades[1] = 2;
        System.out.println("После изменения второй оценки Васи:");
        System.out.println("   " + student_Vasya);
        System.out.println("   " + student_Petya);
        System.out.println("   " + student_Andrey);
    }

    //FIXME: п.7 Методы в PascalCase 
    // private static void task4() {
    //FIXTO:
    private static void Fourth_Task() {
        System.out.println("\n=== ЗАДАНИЕ 4 - СОЗДАЕМ ТОЧКУ ===");
        System.out.println("Создание точек с обязательными координатами:");

        Point point1 = new Point(3, 5);
        System.out.println("1. Точка с координатами 3;5: " + point1);

        Point point2 = new Point(25, 6);
        System.out.println("2. Точка с координатами 25;6: " + point2);

        Point point3 = new Point(7, 8);
        System.out.println("3. Точка с координатами 7;8: " + point3);
    }

    //FIXME: п.7 Методы в PascalCase
    // private static void task5() {
    //FIXTO:
    private static void Fifth_Task() {
        System.out.println("\n=== ЗАДАНИЕ 5 - СОЗДАЕМ СТУДЕНТА ===");

        System.out.println("1. Студент Вася с оценками: 3,4,5");
        //FIXME: п.8 переменные в camel_Case 
        // int[] vasyaGrades = {3, 4, 5};
        //FIXTO:
        int[] vasya_Grades = {3, 4, 5};
        student_Vasya = new Student("Вася", vasya_Grades);
        System.out.println("   " + student_Vasya);

        System.out.println("2. Студент Максим без оценок");
        student_Maxim = new Student("Максим");
        System.out.println("   " + student_Maxim);
    }

    //FIXME: п.7 Методы в PascalCase 
    // private static void task6() {
    //FIXTO:
    private static void Sixth_Task() {
        System.out.println("\n=== ЗАДАНИЕ 6 - СТУДЕНТ ОТЛИЧНИК ===");

        System.out.println("1. Студент Вася с оценками 3,4,5,4");
        //FIXME: п.8 переменные в camel_Case 
        // int[] vasyaGrades = {3, 4, 5, 4};
        //FIXTO:
        int[] vasya_Grades = {3, 4, 5, 4};
        student_Vasya = new Student("Вася", vasya_Grades);
        System.out.println("   " + student_Vasya);

        System.out.println("2. Студент Петя с оценками 5,5,5,5");
        //FIXME: п.8 переменные в camel_Case 
        // int[] petyaGrades = {5, 5, 5, 5};
        //FIXTO:
        int[] petya_Grades = {5, 5, 5, 5};
        student_Petya = new Student("Петя", petya_Grades);
        System.out.println("   " + student_Petya);

        System.out.println("\n3. Информация о студентах:");

        System.out.println("Вася:");
        System.out.println("   Средний балл: " + student_Vasya.getAverageGrade());
        System.out.println("   Отличник: " + (student_Vasya.isExcellentStudent() ? "Да" : "Нет"));

        System.out.println("Петя:");
        System.out.println("   Средний балл: " + student_Petya.getAverageGrade());
        System.out.println("   Отличник: " + (student_Petya.isExcellentStudent() ? "Да" : "Нет"));
    }
}
