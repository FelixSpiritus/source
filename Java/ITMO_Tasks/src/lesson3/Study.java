package lesson3;

public class Study {
    private String course;

    //TODO

    public String printCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }



    public static void main(String[] args) {
        Study stud = new Study();
        stud.setCourse("Изучение Java - это просто!");
        System.out.println(stud.printCourse());
    }

}
