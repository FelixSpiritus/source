package lesson3;

public class Building {
    int floorsQty;
    int buildYear;
    String title;

    public Building() {
    }

    public void setBuilding(int floorsQty, int buildYear, String title) {
        this.floorsQty = floorsQty;
        this.buildYear = buildYear;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Building{" +
                "floorsQty=" + floorsQty +
                ", buildYear=" + buildYear +
                ", title='" + title + '\'' +
                '}';
    }

    public int getBuildYear() {
        return buildYear;
    }

    public static void main(String[] args) {
        Building tower1 = new Building();
        tower1.setBuilding(20,2020, "SkyTower");
        Building tower2 = new Building();
        tower2.setBuilding(25,2015, "RedTower");
        System.out.println(tower1);
        System.out.println(tower2);

    }

}
