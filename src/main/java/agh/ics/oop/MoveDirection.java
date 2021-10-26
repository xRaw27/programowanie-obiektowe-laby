package agh.ics.oop;

public enum MoveDirection {
    FORWARD ("Zwierzak idzie do przodu"),
    BACKWARD ("Zwierzak idzie do tyłu"),
    RIGHT ("Zwierzak skręca w prawo"),
    LEFT ("Zwierzak skręca w lewo");

    private final String message;

    MoveDirection(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
