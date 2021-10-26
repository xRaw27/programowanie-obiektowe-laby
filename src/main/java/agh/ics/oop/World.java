package agh.ics.oop;

import java.util.ArrayList;

public class World {
    static void run(ArrayList<MoveDirection> moveDirections, Animal animal) {
        System.out.println("Start" + "\n");

        for (MoveDirection moveDirection : moveDirections) {
            System.out.println(moveDirection.getMessage());

            System.out.println(animal);
            animal.move(moveDirection);
            System.out.println(animal + "\n");
        }

        System.out.println("Stop");
    }

    public static void main(String[] args) {
        Animal testAnimal = new Animal();
        System.out.println(testAnimal + "\n");

//        String[] testStringArray = {"f", "b", "forward", "backward", "bakwaardwad", "bb", "leeft", "left", "r"};
//        r f f f l b b b b r r r f f f f f f

        ArrayList<MoveDirection> moveDirections = OptionsParser.parse(new String[]{"r", "f", "f", "f"});

        System.out.println(moveDirections + "\n");
        run(moveDirections, testAnimal);
    }
}
