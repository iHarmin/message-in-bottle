import java.util.*;

public class Bottles {
    private String name;
    private int xStarting;
    private int yStarting;
    private String message;
    private ArrayList<String> driftPath = new ArrayList<>();
    private char direction;
    private boolean isStuck = false;

    public Bottles(String name, int xStarting, int yStarting, String message) {
        this.name = name;
        this.xStarting = xStarting;
        this.yStarting = yStarting;
        this.message = message;
    }

    public void setDirection(char[][] surfaceEarth){
        this.direction = surfaceEarth[xStarting][yStarting];
    }
    public String getName() {
        return name;
    }

    public int getxStarting() {
        return xStarting;
    }

    public int getyStarting() {
        return yStarting;
    }

    public void updateLocation(char[][] surfaceEarth) {
        setDirection(surfaceEarth);
        int step = driftPath.size();
        char current = direction;
        if (current != 'X') {
            if(driftPath.contains("(" + xStarting + ", " + yStarting + ")")) {
                System.out.println(step + ": " + name + " at (" + xStarting + ", " + yStarting + "): <<NOW STUCK IN MID-OCEAN GYRE!>>");
                isStuck = true;
            } else {
                System.out.println(step + ": " + name + " at (" + xStarting + ", " + yStarting + "): In ocean, current taking it " + current);
                driftPath.add("(" + xStarting + ", " + yStarting + ")");
                if (current == 'N') {
                    xStarting = xStarting - 1;
                } else if (current == 'S') {
                    xStarting = xStarting + 1;
                } else if (current == 'W') {
                    yStarting = yStarting - 1;
                } else {
                    yStarting = yStarting + 1;
                }
            }
        } else {
            System.out.println(step + ": " + name + " at (" + xStarting + ", " + yStarting + "): LANDED!");
            System.out.println("<<MESSAGE RECEIVED: " + message + ">>");
        }

    }

    public boolean reachedLand() {
        if(direction == 'X'){
            return true;
        }
        return false;
    }

    public boolean stillOcean() {
        return isStuck;
    }
}