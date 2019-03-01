package sweeper;

public class Flag {

    private Matrix flagMap;

    Flag() {
        flagMap = new Matrix(Box.CLOSED);
        flagMap.set(Box.OPENED, new Coord(4, 4));
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(Box.OPENED, coord);
    }

    public void setClosedToBox(Coord coord) {
        flagMap.set(Box.CLOSED, coord);
    }

    public void setFlagedToBox(Coord coord) {
        flagMap.set(Box.FLAGED, coord);
    }

    public void toggleFlaggedToBox(Coord coord) {
        if (flagMap.get(coord) != Box.FLAGED)
            setFlagedToBox(coord);
        else
            setClosedToBox(coord);
    }
}
