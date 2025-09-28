
public class Line {
  private Point start;
  private Point end;

  // Конструктор
  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  // Конструктор для горизонтальной линии
  public Line(int y, int x1, int x2) {
    this.start = new Point(x1, y);
    this.end = new Point(x2, y);
  }

  // Геттеры
  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  // Сеттеры
  public void setStart(Point start) {
    this.start = start;
  }

  public void setEnd(Point end) {
    this.end = end;
  }

  @Override
  public String toString() {
    return "Линия от " + start.toString() + " до " + end.toString();
  }

  // Метод для вычисления длины линии
  public double getLength() {
    int dx = end.getX() - start.getX();
    int dy = end.getY() - start.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }
}