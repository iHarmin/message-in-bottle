public class OceanCurrents {
    private char currentDirection;
    private int xCurrent;
    private int yCurrent;

    public OceanCurrents(int xCurrent, int yCurrent, char currentDirection) {
        this.xCurrent = xCurrent;
        this.yCurrent = yCurrent;
        this.currentDirection = currentDirection;
    }

    public char getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(char currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getxCurrent() {
        return xCurrent;
    }

    public int getyCurrent() {
        return yCurrent;
    }

    public char direction(int xCurrent, int yCurrent){
        return currentDirection;
    }
}
