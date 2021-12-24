package agh.ics.oop.map;

import agh.ics.oop.Rectangle;
import agh.ics.oop.animal.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.Vector2d;

import java.util.*;

abstract class AbstractMap implements IMap {

    private final Vector2d bottomLeftMapCorner;
    private final Vector2d topRightMapCorner;
    private final Vector2d bottomLeftJungleCorner;
    private final Vector2d topRightJungleCorner;

    private final int mapWidth;
    private final int mapHeight;
    private final int jungleWidth;
    private final int jungleHeight;

    private final int mapArea;
    private final int jungleArea;
    private final int steppeArea;
    private final List<Rectangle> mapRectangles;
    private final List<Rectangle> jungleRectangles;
    private final List<Rectangle> steppeRectangles;

    private int numberOfOccupiedJungleCells = 0;
    private int numberOfOccupiedSteppeCells = 0;

    private final RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(this);
    private final Map<Vector2d, SortedSet<Animal>> animals = new HashMap<>();
    private final Map<Vector2d, Grass> plants = new HashMap<>();

    public AbstractMap(int mapWidth, int mapHeight, int jungleWidth, int jungleHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.jungleWidth = jungleWidth;
        this.jungleHeight = jungleHeight;

        this.bottomLeftMapCorner = new Vector2d(0, 0);
        this.topRightMapCorner = new Vector2d(mapWidth - 1, mapHeight - 1);

        this.bottomLeftJungleCorner = new Vector2d((mapWidth - jungleWidth) / 2, (mapHeight - jungleHeight) / 2);
        this.topRightJungleCorner = this.bottomLeftJungleCorner.add(new Vector2d(jungleWidth - 1, jungleHeight - 1));

        Rectangle mapRectangle = new Rectangle(this.bottomLeftMapCorner, this.topRightMapCorner);
        Rectangle jungleRectangle = new Rectangle(this.bottomLeftJungleCorner, this.topRightJungleCorner);

        this.mapArea = mapRectangle.getArea();
        this.jungleArea = jungleRectangle.getArea();
        this.steppeArea = mapRectangle.getArea() - jungleRectangle.getArea();

        this.mapRectangles =  new ArrayList<>(List.of(mapRectangle));
        this.jungleRectangles =  new ArrayList<>(List.of(jungleRectangle));
        this.steppeRectangles = new ArrayList<>();
        this.addSteppeRectangles();

        System.out.println("mapa: " + this.bottomLeftMapCorner + this.topRightMapCorner);
        System.out.println("jungla: " + this.bottomLeftJungleCorner + this.topRightJungleCorner);
        System.out.println("map area: " + this.mapArea);
        System.out.println("jungle area: " + this.jungleArea);
        System.out.println("steppe area: " + this.steppeArea);
        System.out.println(this.jungleRectangles);
        System.out.println(this.steppeRectangles);
    }

    private void addSteppeRectangles() {
        if (this.bottomLeftMapCorner.y != this.bottomLeftJungleCorner.y) {
            this.steppeRectangles.add(new Rectangle(this.bottomLeftMapCorner, new Vector2d(this.topRightMapCorner.x, this.bottomLeftJungleCorner.y - 1)));
        }
        if (this.bottomLeftMapCorner.x != this.bottomLeftJungleCorner.x) {
            this.steppeRectangles.add(new Rectangle(new Vector2d(this.bottomLeftMapCorner.x, this.bottomLeftJungleCorner.y), new Vector2d(this.bottomLeftJungleCorner.x - 1, this.topRightJungleCorner.y)));
        }
        this.steppeRectangles.add(new Rectangle(new Vector2d(this.topRightJungleCorner.x + 1, this.bottomLeftJungleCorner.y), new Vector2d(this.topRightMapCorner.x, this.topRightJungleCorner.y)));
        this.steppeRectangles.add(new Rectangle(new Vector2d(this.bottomLeftMapCorner.x, this.topRightJungleCorner.y + 1), this.topRightMapCorner));
    }


    private Vector2d randomUnoccupiedJunglePosition() {
        return randomPositionGenerator.randomUnoccupiedPositionInRectangles(this.jungleRectangles, this.jungleArea, this.numberOfOccupiedJungleCells);
    }

    private Vector2d randomUnoccupiedSteppePosition() {
        return randomPositionGenerator.randomUnoccupiedPositionInRectangles(this.steppeRectangles, this.steppeArea, this.numberOfOccupiedSteppeCells);
    }

    @Override
    public Vector2d randomUnoccupiedMapPosition() {
        return randomPositionGenerator.randomUnoccupiedPositionInRectangles(this.mapRectangles, this.mapArea, this.numberOfOccupiedJungleCells + this.numberOfOccupiedSteppeCells);
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
