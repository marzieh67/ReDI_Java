import java.util.ArrayList;

public class Farm {
    private static ArrayList<Animal> farmAnimals;


    Farm() {
        farmAnimals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return farmAnimals;
    }

    public void addCow(String name, double weight) {
        Animal newCow = new Animal(name, weight);
        farmAnimals.add(newCow);
    }

    public void addChicken(String name, double weight) {
        Animal newChicken = new Animal(name, weight);
        farmAnimals.add(newChicken);
    }
}