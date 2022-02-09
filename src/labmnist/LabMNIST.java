
package labmnist;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
/**
 *
 * @author DOSIEAH
 */
public class LabMNIST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] array = loadFile("digits.csv");
        //printArray(array);
        determineClosest(array);
        
    }
    
    public static int[][] loadFile(String filename){
        //Reading data from file
        ArrayList<String> fileList = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                fileList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        int[][] data = new int[fileList.size()][65];
        for (int row = 0; row < fileList.size(); row++) {
            String fileLine = fileList.get(row);
            String[] indivLineVal = fileLine.split(",");
            for (int column = 0; column < indivLineVal.length; column++) {
                data[row][column] = Integer.valueOf(indivLineVal[column]);
            }
        }
        return data;
        
    }
    
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < 64; j++){
                if (array[i][j] < 6){
                    System.out.print("." + " ");
                }else if (array[i][j] < 11){
                    System.out.print("o" + " ");
                }else{
                    System.out.print("O" + " ");
                }
                //System.out.print(array[0][j]);
                if (((j+1) % 8) == 0){
                    System.out.print('\n');
                }
            }
            System.out.println("       ");
        }
    }
    
    public static void determineClosest(int[][]array)
    {
        for (int i=10; i < array.length; i++){
            System.out.println("Row " + (i+1) + " is closest to number " + getClosest(i, array));
        }
        //System.out.println("Row " + (11) + " is closest to number " + getClosest(11, array));
    }
     
    public static int getClosest(int row, int[][]array){
        int number = -1;
        int distance = 0;
        double lowestDistance = 100000000;
        for (int i=0; i < 10; i++){
            distance = 0;
            for (int j= 0; j < 64; j++){
                //System.out.println(Math.pow(array[row][j] - array[i][j],2) + " ");
                distance += Math.pow(array[row][j] - array[i][j],2);
            }
            //System.out.println(distance);
            if (Math.sqrt(distance) < lowestDistance){
                lowestDistance = Math.sqrt(distance);
                number = array[i][64];
            }
        }
        
        return number;
        
    }

}
    
