package agh.ics.oop;

import java.util.ArrayList;

public class World {
    static void run(ArrayList<MoveDirection> moveDirections, Animal animal) {
        for (MoveDirection moveDirection : moveDirections) {
            System.out.println(moveDirection.getMessage());
            System.out.println(animal);

            animal.move(moveDirection);
            System.out.println(animal + "\n");
        }
    }

    public static void main(String[] args) {
        Animal testAnimal = new Animal();
        System.out.println(testAnimal + "\n");

        ArrayList<MoveDirection> moveDirections = OptionsParser.parse(new String[]{"r", "f", "f", "f"});
        System.out.println(moveDirections + "\n");

        run(moveDirections, testAnimal);
        System.out.println(testAnimal + "\n");
    }
}
