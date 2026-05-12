
public class Line {
  private Point start;
  private Point end;
//FIXME: Код не должен содержать комментариев по типу "конструктор, геттер", не использовать сокращения
  // // Конструктор
  // public Line(Point start, Point end) {
  //   this.start = start;
  //   this.end = end;
  // }

  // // Конструктор для горизонтальной линии
  // public Line(int y, int start_X, int end_X) {
  //   this.start = new Point(start_X, y);
  //   this.end = new Point(end_X, y);
  // }
//FIXTO:
  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }
  //FIXME: не использовать сокращения
  // public Line(int y, int x1, int x2) {
  //   this.start = new Point(x1, y);
  //   this.end = new Point(x2, y);
  //FIXTO:
   public Line(int y, int start_X, int end_X) {
    this.start = new Point(start_X, y);
    this.end = new Point(end_X, y);
  }
  //FIXME: Код не должен содержать комментариев по типу "конструктор, геттер", методы пишутся в PascalCase

  // // Геттеры
  // public Point getStart() {
  //   return start;
  // }

  // public Point getEnd() {
  //   return end;
  // }

  // // Сеттеры
  // public void setStart(Point start) {
  //   this.start = start;
  // }

  // public void setEnd(Point end) {
  //   this.end = end;
  // }
  //FIXTO:
  public Point GetStart() {
    return start;
  }

  public Point GetEnd() {
    return end;
  }

  public void SetStart(Point start) {
    this.start = start;
  }

  public void SetEnd(Point end) {
    this.end = end;
  }

  @Override
  public String toString() {
    return "Линия от " + start.toString() + " до " + end.toString();
  }
//FIXME: Код не должен содержать комментариев по типу "конструктор, геттер", методы пишутся в PascalCase, 
//сокращения в названиях не допустимы
  // // Метод для вычисления длины линии
  // public double getLength() {
  //   int dx = end.getX() - start.getX();
  //   int dy = end.getY() - start.getY();
  //   return Math.sqrt(dx * dx + dy * dy);
  // }
  //FIXTO:
  public double GetLength() {
    int delta_X = end.getX() - start.getX();
    int delta_Y = end.getY() - start.getY();
    return Math.sqrt(delta_X * delta_X + delta_Y * delta_Y);
  }
}
