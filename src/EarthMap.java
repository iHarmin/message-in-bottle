public class EarthMap {
    private char[][] surfaceEarth;
    private int height;
    private int width;

    public EarthMap(char[][] surfaceEarth, int height, int width) {
        this.surfaceEarth = surfaceEarth;
        this.height = height;
        this.width = width;
    }

    public void coordinatesOfLand(int xCoordinate, int yCoordinate) {
        surfaceEarth[xCoordinate][yCoordinate] = 'L';
    }


    public char[][] getSurfaceEarth() {
        return surfaceEarth;
    }

    public void initialEarth() {
        for(int i = 0; i < this.surfaceEarth.length; i++) {
            for(int j = 0; j < this.surfaceEarth[i].length; j++) {
                this.surfaceEarth[i][j] = 'O';
            }
        }
    }

    public void setFinalMap(char[][] surfaceEarth) {
        this.surfaceEarth = surfaceEarth;
    }
}
