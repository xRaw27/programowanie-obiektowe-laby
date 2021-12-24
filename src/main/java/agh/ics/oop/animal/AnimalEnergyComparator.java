//package agh.ics.oop.animal;
//
//import java.util.Comparator;
//
//public class AnimalEnergyComparator implements Comparator<Animal> {
//
//    @Override
//    public int compare(Animal animal1, Animal animal2) {
//        int energyCompare = Integer.compare(animal1.getEnergy(), animal2.getEnergy());
//
//        if (energyCompare == 0) {
//            return Integer.compare(animal1.id, animal2.id);
//        }
//        else {
//            return energyCompare;
//        }
//    }
//}
