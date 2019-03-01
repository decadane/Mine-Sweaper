package sweeper;

public class Flag {

    private Matrix flagMap;

    Flag() {
        flagMap = new Matrix(Box.CLOSED);
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

    public void setFlaggedToBox(Coord coord) {
        flagMap.set(Box.FLAGED, coord);
    }

    public void toggleFlaggedToBox(Coord coord) {
        if (flagMap.get(coord) != Box.FLAGED)
            setFlaggedToBox(coord);
        else
            setClosedToBox(coord);
    }
}
