public class Animal {
    static int Default_Age = 2;
    static String Default_Color = "White";

    private String name;
    private int age;
    private String color;
    private double weight;

    Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    Animal(String name, double weight) {
        this.name = name;
        this.age = Default_Age;
        this.color = Default_Color;
    }

    public String getName() {
        return name;
    }
    public double getWeight(){
        return weight;
    }
}