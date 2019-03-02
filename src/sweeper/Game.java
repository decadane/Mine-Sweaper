package sweeper;

public class Game
{
    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public GameState getState() {
        return state;
    }

    public Game(int cols, int rows, int totalBombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(totalBombs);
    }

    public void start()
    {
        bomb.start();
        flag = new Flag();
        state = GameState.PLAYED;
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    private void checkWinner() {
        if (state == GameState.PLAYED && flag.getCountOfClosedBoxes() == bomb.getTotalBombs())
            state = GameState.WINNER;
    }

    public void pressLeftButton(Coord coord) {
        if (state == GameState.PLAYED) {
            openBox(coord);
            checkWinner();
        }
    }

    public void pressRightButton(Coord coord) {
        if (state == GameState.PLAYED && (flag.get(coord) == Box.CLOSED || flag.get(coord) == Box.FLAGED))
            flag.toggleFlaggedToBox(coord);
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED: return;
            case FLAGED: return;
            case CLOSED: switch (bomb.get(coord)) {
                case BOMB: openBombs();
                    return;
                case ZERO: openBoxesAround(coord);
                    return;
                default: flag.setOpenedToBox(coord);
                    return;
            }
        }
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getCoordsAround(coord)) {
            openBox(around);
        }
    }

    private void openBombs() {
        state = GameState.BOMBED;
        for (Coord coord : Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.BOMB && flag.get(coord) == Box.CLOSED)
                flag.setBombedToBox(coord);
            if (flag.get(coord) == Box.FLAGED && bomb.get(coord) != Box.BOMB)
                flag.setFalseFlag(coord);
        }
    }
}
