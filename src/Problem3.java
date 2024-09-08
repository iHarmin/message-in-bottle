import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int height = in.nextInt();
        int width = in.nextInt(); in.nextLine();

        char[][] surfaceEarth = new char[height][width];
        EarthMap earthmap = new EarthMap(surfaceEarth, height, width);
        earthmap.initialEarth();

        String input = in.nextLine();
        String[] array = input.split(" ");
        int[][] coordinates = new int[array.length][2];
        for(int i = 0; i < array.length; i++) {
            String a = array[i];
            String[] b = a.split(",");
            coordinates[i][0] = Integer.parseInt(b[0]);
            coordinates[i][1] = Integer.parseInt(b[1]);
        }

        for(int i = 0; i < coordinates.length; i++) {
            earthmap.coordinatesOfLand(coordinates[i][0], coordinates[i][1]);
        }


        ArrayList<OceanCurrents> currents = new ArrayList<>();
        for (int i = 0; i < surfaceEarth.length; i++) {
            for (int j = 0; j < surfaceEarth[i].length; j++) {
                if(surfaceEarth[i][j] == 'L') {
                    surfaceEarth[i][j] = 'X';
                } else {
                    char c = in.next().charAt(0);
                    surfaceEarth[i][j] = c;
                    OceanCurrents c1 = new OceanCurrents(i,j,c);
                    currents.add(c1);
                }
            }
        }
        earthmap.setFinalMap(surfaceEarth);

        int numberOfBottles = in.nextInt(); in.nextLine();
        ArrayList<Bottles> bottles = new ArrayList<>();
        for(int i = 0; i < numberOfBottles; i++) {
            int bottleX = in.nextInt();
            int bottleY = in.nextInt();
            String bottleName = in.nextLine();
            String message = in.nextLine();
            Bottles bottle = new Bottles(bottleName, bottleX, bottleY, message);
            bottles.add(bottle);
        }

        for(int i = 0; i < numberOfBottles; i++) {
            System.out.println(bottles.get(i).getName() + ": Starting at (" + bottles.get(i).getxStarting() + ", " + bottles.get(i).getyStarting() + ")");
        }
        int k = 0;
        while(bottles.size() != 0) {
            int i = k%bottles.size();

            bottles.get(i).updateLocation(earthmap.getSurfaceEarth());

            if(bottles.get(i).reachedLand() == true || bottles.get(i). stillOcean() == true) {
                bottles.remove(i);
                k++;
                continue;
            }
            k++;
        }
    }
}