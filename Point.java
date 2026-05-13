public class Point {
    private int x;
    private int y;

    
    public Point(int x, int y) {
       
        this.x = x;
        this.y = y;
    }

    //FIXME: п.7 Методы в PascalCase
    // public int getX() {
    //     return x;
    // }
    //FIXTO:
    public int GetX() {
        return x;
    }

    //FIXME: п.7 Методы в PascalCase
    // public int getY() {
    //     return y;
    // }
    //FIXTO:
    public int GetY() {
        return y;
    }

    //FIXME: п.7 методы в PascalCase
    // public void setX(int x) {
    //     this.x = x;
    // }
    //FIXTO:
    public void SetX(int x) {
        this.x = x;
    }

    //FIXME: п.7 методы в PascalCase
    // public void setY(int y) {
    //     this.y = y;
    // }
    //FIXTO:
    public void SetY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    //FIXME: п.19 @Override, неправильная сигнатура 
    // public boolean equals(Point other) {
    //FIXTO:
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }
    
    
}
