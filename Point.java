
public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Геттеры
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  // Сеттеры
  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }

  // Проверка равенства точек
  public boolean equals(Point other) {
    return this.x == other.x && this.y == other.y;
  }
}