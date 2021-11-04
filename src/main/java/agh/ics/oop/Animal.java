package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;

    private final IWorldMap map;

//    private final static Vector2d topRightCorner = new Vector2d(4, 4);
//    private final static Vector2d bottomLeftCorner = new Vector2d(0, 0);

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (this.map.canMoveTo(newPosition)) this.position = newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(newPosition)) this.position = newPosition;
            }
        }
    }

//    public void move(MoveDirection moveDirection) {
//        switch (moveDirection) {
//            case RIGHT -> this.direction = this.direction.next();
//            case LEFT -> this.direction = this.direction.previous();
//            case FORWARD -> {
//                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
//                if (newPosition.precedes(topRightCorner) && newPosition.follows(bottomLeftCorner)) {
//                    this.position = newPosition;
//                }
//            }
//            case BACKWARD -> {
//                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
//                if (newPosition.precedes(topRightCorner) && newPosition.follows(bottomLeftCorner)) {
//                    this.position = newPosition;
//                }
//            }
//        }
//    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
//        return "position = " + position + ", direction = " + direction;
//        return direction.getSymbol() + " " + position;
        return direction.getSymbol();
    }
}
