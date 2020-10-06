package arrangementOfCircles;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Circle c1 = readCircle("c1");
        Circle c2 = readCircle("c2");

        double distance = calcDistance(c1.x, c1.y, c2.x, c2.y);

        CrossingTypes type = getTypes(c1, c2, distance);

        printType(type);
    }

    static double readDouble(String variable) {
        System.out.printf("Input %s = ", variable);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    static Circle readCircle(String circle) {
        double x = readDouble(String.format("%s.x", circle));
        double y = readDouble(String.format("%s.y", circle));
        double r = readDouble(String.format("%s.r", circle));
        return new Circle(x, y, r);
    }

    static double calcDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static boolean isCrossingIn2Points(Circle c1, Circle c2, double distance)
    {
        return distance < c1.r + c2.r && distance > c1.r - c2.r;
    }

    static boolean isTouchingFromTheInside(Circle c1, Circle c2, double distance)
    {
        return distance == c1.r - c2.r;
    }

    static boolean isTouchingFromTheOutside(Circle c1, Circle c2, double distance)
    {
        return distance == c1.r + c2.r;
    }

    static boolean isNotInscribeding(Circle c1, Circle c2, double distance)
    {
        return distance > c1.r + c2.r;
    }

    static CrossingTypes getTypes(Circle c1, Circle c2, double Distance)
    {
        if (isCrossingIn2Points(c1, c2, Distance)) return CrossingTypes.CrossingIn2Points;
        if (isTouchingFromTheInside(c1, c2, Distance)) return  CrossingTypes.TouchingFromTheInside;
        if (isTouchingFromTheOutside(c1, c2, Distance)) return  CrossingTypes.TouchingFromTheOutside;
        if (isNotInscribeding(c1, c2, Distance)) return  CrossingTypes.NotInscribeding;
        return CrossingTypes.Inscribeding;
    }

    static void printType(CrossingTypes type)
    {
        System.out.println(type);
    }

}
