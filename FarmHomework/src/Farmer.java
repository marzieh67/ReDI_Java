import java.util.ArrayList;
import java.util.Scanner;

public class Farmer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Farm littleFarm = new Farm();
        Field ourAvailableField = new Field();

        Animal sheep = new Animal("Gitta", 12, 50, "gray");
        Animal giraffe = new Animal("Dolly", 3, 600, "orange");
        Animal cow = new Animal("Hans", 4, 750, "black");
        Animal pig = new Animal("Pika", 1, 100, "Pink");
        Animal chicken = new Animal("Chiki", 2, 1.2, "yellow");

        //here I tried to use array for location of my field, but I got error. so I defined it as default value.

        Field upperField = new Field(100, 75, true);
        Field middleField = new Field(300, 125, false);
        Field lowerField = new Field(700, 375, true);

        //using array list for fields names.
        ArrayList<Animal> myAnimals = littleFarm.getAnimals();
        ArrayList<Field> myFields = ourAvailableField.getListOfFields();

        myAnimals.add(sheep);
        myAnimals.add(giraffe);
        myAnimals.add(cow);
        myAnimals.add(chicken);

        myFields.add(upperField);
        myFields.add(middleField);
        myFields.add(lowerField);

        //adding two new animals
        littleFarm.addCow("Franzi", 900);
        littleFarm.addChicken("Lili", 1);   //Lili is a new chicken in our farm


        System.out.println("*Animals in this farm area:");
        for (Animal a : myAnimals) {
            System.out.println(a.getName());
        }
        System.out.println("----------------------------------------------");
        System.out.println("*Checking truck capacity for animal movement");
        Animal newAnimal = giraffe;
        Field newField = middleField;


        //using a truck for moving animals
        if (newAnimal.getWeight() > newField.getTruckCapacity()) {
            System.out.println(newAnimal.getName() + " can not come with this truck!");
        } else {
            System.out.println(newAnimal.getName() + " can come with this truck!");
        }
        System.out.println("----------------------------------------------");
        System.out.println("current Harvest: " + newField.getHarvest());
        //suggesting harvest for the next year
        if (newField.isfree()) {
            System.out.println("What will be the crop of next year?");
            String newHarvest = scanner.nextLine();
            newField.setHarvest(newHarvest);
            System.out.println("New Harvest: " + newField.getHarvest());
        }

        if (newField.isLargeEnough()) {
            System.out.println("Use Sprinkler irrigation for " + newField.getHarvest() + " in " + newField.area() + " m2");
        }

    }
}