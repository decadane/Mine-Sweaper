package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges
{
    private static Coord size;
    private static ArrayList<Coord> allCoords;
    private static Random rand = new Random();

    public static void setSize(Coord _size) {
        size = _size;
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord (x, y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static ArrayList<Coord> getAllCoords()
    {
        return allCoords;
    }

    static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x && coord.y >= 0 && coord.y < size.y;
    }

    static Coord getRandmomCoord() {
        return new Coord(rand.nextInt(size.x), rand.nextInt(size.y));
    }

    static ArrayList<Coord> getCoordsAround(Coord pivot) {
        Coord coord;
        ArrayList<Coord> list = new ArrayList<Coord>();

        for (int i = pivot.x - 1; i <= pivot.x + 1; i++) {
            for (int j = pivot.y - 1; j <= pivot.y + 1; j++) {
                if (inRange(coord = new Coord(i, j)) && !coord.equals(pivot))
                    list.add(coord);
            }
        }
        return list;
    }
}
