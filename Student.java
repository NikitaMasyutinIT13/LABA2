import java.util.Arrays;


public class Student {
  private String name;
  private int[] grades;

  // Конструктор
  public Student(String name, int[] grades) {
    this.name = name;
    this.grades = grades != null ? grades.clone() : new int[0];
  }

  // Конструктор
  public Student(String name) {
    this(name, new int[0]);
  }

  // Геттеры
  public String getName() {
    return name;
  }

  public int[] getGrades() {
    return grades.clone(); // возвращаем копию для безопасности
  }

  // Сеттеры
  public void setName(String name) {
    this.name = name;
  }

  public void setGrades(int[] grades) {
    this.grades = grades != null ? grades.clone() : new int[0];
  }
  public void setGradesDirect(int[] grades) {
    this.grades = grades;
}
  @Override
  public String toString() {
    return name + ": " + Arrays.toString(grades);
  }

  public double getAverageGrade() {
    if (grades.length == 0) {
      return 0.0;
    }

    int sum = 0;
    for (int grade : grades) {
      sum += grade;
    }
    return (double) sum / grades.length;
  }

  public boolean isExcellentStudent() {
    if (grades.length == 0) {
      return false;
    }

    for (int grade : grades) {
      if (grade != 5) {
        return false;
      }
    }
    return true;
  }
}