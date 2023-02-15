public class RottingOranges {

    private static int EMPTY = 0;
    private static int FRESH = 1;
    private static int ROTTEN = 2;

    public int findMinutesUntilAllRotten(int[][] grid) {
        int nFresh = 0;
        var rotten = new LinkedList<Coordinate>(); // [[0, 1]]
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    rotten.add(new Coordinate(i, j));
                }
                if (grid[i][j] == FRESH) {
                    nFresh++;
                }
            }
        }
        
        while (!rotten.isEmpty()) {
            var newlyRotten = new LinkedList<Coordinate>();
            while (!rotten.isEmpty()) {
                var coordinate = rotten.removeFirst();
                for (var neighbor : findNeighbors(grid, coordinate)) {
                    if (grid[neighbor.i][neighbor.j] == FRESH) {
                        grid[neighbor.i][neighbor.j] = ROTTEN;
                        nFresh--;
                        newlyRotten.add(neighbor);
                    }
                }
            }
            rotten.addAll(newlyRotten);
        }
        
        return nFresh == 0;
    }
    
    private List<Coordinate> findNeighbors(int[][] grid, Coordinate coordinate) {
        var neighbors = new LinkedList<Coordinate>();
        if (coordinate.i - 1 >= 0) {
            neighbors.add(new Coordinate(coordinate.i - 1, coordinate.j));
        }
        if (coordinate.i + 1 < grid.length) {
            neighbors.add(new Coordinate(coordinate.i + 1, coordinate.j));
        } 
        if (coordinate.j - 1 >= 0) {
            neighbors.add(new Coordinate(coordinate.i, coordinate.j - 1));
        }
        if (coordinate.j + 1 < grid[0].length) {
            neighbors.add(new Coordinate(coordinate.i, coordinate.j + 1));
        }
        return neighbors;
    }
    
    static class Coordinate {
        int i;
        int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
