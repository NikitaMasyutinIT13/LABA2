public class Line {
    private Point start;
    private Point end;

    //FIXME: п.13 Конструктор не валидирует данные (нет проверки на null)
    // public Line(Point start, Point end) {
    //     this.start = start;
    //     this.end = end;
    // }
    //FIXTO:
    public Line(Point start, Point end) {
        
        if (start == null || end == null) {
            throw new IllegalArgumentException("Начальная и конечная точки не могут быть null");
        }
        this.start = new Point(start.GetX(), start.GetY());
        this.end = new Point(end.GetX(), end.GetY());
    }

    //FIXME: п.11 Использованы сокращения x1, x2
    // public Line(int y, int x1, int x2) {
    //     this.start = new Point(x1, y);
    //     this.end = new Point(x2, y);
    // }
    //FIXTO:
    public Line(int y, int start_X, int end_X) {
        this.start = new Point(start_X, y);
        this.end = new Point(end_X, y);
    }

    //FIXME: п.7 Методы в PascalCase, п.14 возвращает копию
    // public Point getStart() {
    //     return start;
    // }
    //FIXTO:
    public Point GetStart() {
        return new Point(start.GetX(), start.GetY());
    }

    //FIXME: п.7 Методы в PascalCase, п.14 возвращает копию
    // public Point getEnd() {
    //     return end;
    // }
    //FIXTO:
    public Point GetEnd() {
        return new Point(end.GetX(), end.GetY());
    }

    //FIXME: п.13 Сеттер не валидирует данные, п.7 методы в PascalCase
    // public void setStart(Point start) {
    //     this.start = start;
    // }
    //FIXTO:
    public void SetStart(Point start) {
        if (start == null) {
            throw new IllegalArgumentException("Начальная точка не может быть null");
        }
        this.start = new Point(start.GetX(), start.GetY());
    }

    //FIXME: п.13 Сеттер не валидирует данные, п.7 методы в PascalCase
    // public void setEnd(Point end) {
    //     this.end = end;
    // }
    //FIXTO:
    public void SetEnd(Point end) {
        if (end == null) {
            throw new IllegalArgumentException("Конечная точка не может быть null");
        }
        this.end = new Point(end.GetX(), end.GetY());
    }

    @Override
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }

    //FIXME: п.8 Переменные в camel_Case (dx, dy), п.7 методы в PascalCase
    // public double getLength() {
    //     int dx = end.getX() - start.getX();
    //     int dy = end.getY() - start.getY();
    //     return Math.sqrt(dx * dx + dy * dy);
    // }
    //FIXTO:
    public double GetLength() {
        int delta_X = end.GetX() - start.GetX();
        int delta_Y = end.GetY() - start.GetY();
        return Math.sqrt(delta_X * delta_X + delta_Y * delta_Y);
    }
}
