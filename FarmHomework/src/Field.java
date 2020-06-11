import java.util.ArrayList;

public class Field {
    static double Default_Latitude = 50.8;
    static double Default_Longitude = 37.5;
    String Default_Harvest = "corn";

    private double latitude;
    private double longitude;
    private double width;
    private double height;
    private static String harvest;

    private Boolean freeForNextYear;
    static double truckCapacity = 650;

    double[] location = {latitude, longitude};

    private static ArrayList<Field> ListOfFields;

    Field() {
        ListOfFields = new ArrayList<>();
    }

    public ArrayList<Field> getListOfFields() {
        return ListOfFields;
    }


    Field(double width, double height, String harvest, double[] location, boolean freeForNextYear) {
        this.width = width;
        this.height = height;
        this.harvest = harvest;
        this.location = location;
    }

    Field(double width, double height, boolean freeForNextYear) {
        this.width = width;
        this.height = height;
        this.harvest = Default_Harvest;
        this.latitude = Default_Latitude;
        this.longitude = Default_Longitude;
        this.freeForNextYear = true;
    }

    double area() {
        return width * height;
    }

    public double getTruckCapacity() {
        return truckCapacity;
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String newHarvest) {
        this.harvest = newHarvest;
    }

    public boolean isfree() {
        return freeForNextYear;
    }

    public boolean isLargeEnough() {
        return area() > 10000;
    }

}
