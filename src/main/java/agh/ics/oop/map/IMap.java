package agh.ics.oop.map;

import agh.ics.oop.animal.Animal;
import agh.ics.oop.Vector2d;

import java.util.List;

public interface IMap {

    public static final double BOUNDARY_OCCUPIED_RATIO = 0.95;

    boolean canMoveTo(Vector2d position);

    Vector2d randomUnoccupiedMapPosition();

    boolean place(Animal animal);

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);
}