package agh.ics.oop;

public class World {
    static void run(String[] args) {
        System.out.println("zwierzak idzie do przodu");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(", ");
        }
        result.append(args[args.length - 1]);

        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");

        String[] test = {"sadafas", "safsdf"};
        run(test);

        System.out.println("system zakończył działanie");
    }
}
