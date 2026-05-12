import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    //FIXME: п.13 нет валидации, 
    // public Student(String name, int[] grades) {
    //     this.name = name;
    //     this.grades = grades != null ? grades.clone() : new int[0];
    // }
    //FIXTO:
    public Student(String name, int[] grades) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        this.grades = grades != null ? grades.clone() : new int[0];
    }

    //FIXME: п.13 нет валидации,
    // public Student(String name) {
    //     this(name, new int[0]);
    // }
    //FIXTO:
    public Student(String name) {
        this(name, new int[0]);
    }

    //FIXME: п.7 методы в PascalCase
    // public String getName() {
    //     return name;
    // }
    //FIXTO:
    public String GetName() {
        return name;
    }

    //FIXME: п.7 методы в PascalCase
    // public int[] getGrades() {
    //     return grades.clone();
    // }
    //FIXTO:
    public int[] GetGrades() {
        return grades.clone();
    }

    //FIXME: п.13 нет валидации, п.7 методы в PascalCase
    // public void setName(String name) {
    //     this.name = name;
    // }
    //FIXTO:
    public void SetName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    //FIXME: п.13 нет валидации, п.7 методы в PascalCase
    // public void setGrades(int[] grades) {
    //     this.grades = grades != null ? grades.clone() : new int[0];
    // }
    //FIXTO:
    public void SetGrades(int[] grades) {
        this.grades = grades != null ? grades.clone() : new int[0];
    }

    //FIXME: п.11 лишний метод setGradesDirect (нарушает инкапсуляцию, п.14)
    // public void setGradesDirect(int[] grades) {
    //     this.grades = grades;
    // }
    //FIXTO: метод удалён, использовать SetGrades

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

    //FIXME: п.7 методы в PascalCase
    // public double getAverageGrade() {
    //     if (grades.length == 0) {
    //         return 0.0;
    //     }
    //     int sum = 0;
    //     for (int grade : grades) {
    //         sum += grade;
    //     }
    //     return (double) sum / grades.length;
    // }
    //FIXTO:
    public double GetAverageGrade() {
        if (grades.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    //FIXME: п.7 методы в PascalCase
    // public boolean isExcellentStudent() {
    //     if (grades.length == 0) {
    //         return false;
    //     }
    //     for (int grade : grades) {
    //         if (grade != 5) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    //FIXTO:
    public boolean IsExcellentStudent() {
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
