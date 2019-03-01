package sweeper;

public class Game
{
    private Bomb bomb;
    private Flag flag;

    public Game(int cols, int rows, int totalBombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(totalBombs);
        flag = new Flag();
    }

    public void start()
    {
        bomb.start();
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void pressLeftButton(Coord coord) {
        flag.setOpenedToBox(coord);
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlaggedToBox(coord);
    }
}
