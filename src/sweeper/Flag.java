package sweeper;

public class Flag {

    private Matrix flagMap;
    private int closedBoxesCount;

    Flag() {
        flagMap = new Matrix(Box.CLOSED);
        closedBoxesCount = Ranges.getSize().x * Ranges.getSize().y;
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(Box.OPENED, coord);
        closedBoxesCount--;
    }

    public void setClosedToBox(Coord coord) {
        flagMap.set(Box.CLOSED, coord);
    }

    public void setFlaggedToBox(Coord coord) {
        flagMap.set(Box.FLAGED, coord);
    }

    public void toggleFlaggedToBox(Coord coord) {
        if (flagMap.get(coord) != Box.FLAGED)
            setFlaggedToBox(coord);
        else
            setClosedToBox(coord);
    }

    public int getCountOfClosedBoxes() {
        return closedBoxesCount;
    }

    public void setBombedToBox(Coord coord) {
        flagMap.set(Box.BOMBED, coord);
    }

    public void setFalseFlag(Coord coord) {
        flagMap.set(Box.NOBOMB, coord);
    }
}
