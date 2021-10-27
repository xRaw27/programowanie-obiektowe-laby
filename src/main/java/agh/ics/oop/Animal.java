package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection direction = MapDirection.NORTH;
    private final Vector2d topRightCorner = new Vector2d(4, 4);
    private final Vector2d bottomLeftCorner = new Vector2d(0, 0);


    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (newPosition.precedes(this.topRightCorner) && newPosition.follows(this.bottomLeftCorner)) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (newPosition.precedes(this.topRightCorner) && newPosition.follows(this.bottomLeftCorner)) {
                    this.position = newPosition;
                }
            }
        }
    }

    public Boolean isPositionAndDirectionEqual(Vector2d p, MapDirection d) {
        return (p.equals(this.position) && d.equals(this.direction));
    }

    @Override
    public String toString() {
        return "position = " + position + ", direction = " + direction;
    }
}
