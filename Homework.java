import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Homework {
    public static void main(String[] args) throws FileNotFoundException{

    }
    
    // Метод считывания файла:
    public static int[] readFile() throws FileNotFoundException {
        File infile = new File("input.txt");
        Scanner scanner = new Scanner(infile);
        String line = scanner.nextLine();
        int[] intArray = new int[2];
        String[] stringArray = line.split(" ");
        
        if(stringArray[0] == "a"){
            intArray[0] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[1] = Integer.parseInt(stringArray[1]);
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        
        scanner.close();
        return intArray;
    }
}