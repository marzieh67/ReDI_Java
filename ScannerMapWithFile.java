package Java_1;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerMapWithFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "scannerMap.data";
        File f = new File(fileName);
        HashMap<String, String> ourMap = new HashMap<>();

        if (f.exists()) {
            FileInputStream inFile = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(inFile);
            ourMap = (HashMap<String, String>) ois.readObject();
            inFile.close();
            System.out.println("Read from file, all is good!");
        }

        Scanner scanner = new Scanner(System.in);
        char command;
        do {

            System.out.println("[A]dd , [R]emove, [S]each or [L]ist? [Q]uit");
            command = scanner.nextLine().toUpperCase().charAt(0);
            switch (command) {
                case 'A':
                case 'R':
                    System.out.println("And what would be the key?");
                    String key = scanner.nextLine();
                    if (command == 'A') {
                        System.out.println("And what would be the value?");
                        String value = scanner.nextLine();
                        ourMap.put(key, value);
                    } else {
                        ourMap.remove(key);
                    }
                    break;
                case 'L':
                    for (String mapKey : ourMap.keySet()) {
                        System.out.println(mapKey + ":" + ourMap.get(mapKey));
                    }
                    break;
                case 'S':
                    System.out.println("And what would be the key?");

                    String searchKey = scanner.nextLine();
                    String searchKeyUpper = searchKey.toUpperCase();
                    boolean isFound = false;
                    for (String mapKey : ourMap.keySet()) {
                        if (mapKey.toUpperCase().contains(searchKeyUpper)) {
                            System.out.println(mapKey + ":" + ourMap.get(mapKey));
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.out.printf("%s not found \n", searchKey);
                    }

                    break;
            }
        } while (command != 'Q');


        FileOutputStream outFile;
        outFile = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(outFile);
        oos.writeObject(ourMap);
        System.out.println("Going out");
        outFile.close();
    }
}