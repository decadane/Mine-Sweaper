package sweeper;

class Matrix
{
    private Box [][] matrix;

    Matrix(Box defaultBox) {
        matrix = new Box [Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix[coord.x][coord.y] = defaultBox;
        }
    }

    void set(Box box, Coord coord) {
        if (Ranges.inRange(coord)) {
            matrix[coord.x][coord.y] = box;
        }
    }

    Box get(Coord coord) {
        if (Ranges.inRange(coord)) {
            return matrix[coord.x][coord.y];
        }
        return null;
    }
}