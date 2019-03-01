package sweeper;

public class Bomb
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs)
    {
        this.totalBombs = totalBombs;
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);

        fixBombCount();
        for (int j = 0; j < totalBombs; j++)
            placeBomb ();
    }

    private void fixBombCount() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    private void placeBomb() {

        while (true) {
            Coord coord = Ranges.getRandmomCoord();
            if (bombMap.get(coord) == Box.BOMB)
                continue;
            bombMap.set(Box.BOMB, coord);
            incNumbersAroundBomb(coord);
            break;
        }
    }

    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord)) {
            if (bombMap.get(around) != Box.BOMB)
                bombMap.set(bombMap.get(around).getNextNumberBox(), around);
        }
    }
}
