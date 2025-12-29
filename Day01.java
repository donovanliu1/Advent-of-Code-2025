import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01{
    public static void main(String[] args){
        ArrayList<String> fileData = getFileData("inputs/input01.txt");

        System.out.println("Part 1: " + doPartOne(fileData));
        System.out.println("Part 2: " + doPartTwo(fileData));
    }

    public static int doPartOne(ArrayList<String> fileData){
        int count = 0;
        int current = 50;
        for (String s : fileData){
            int clicks = Integer.parseInt(s.substring(1));
            if (s.charAt(0) == 'R') current = (current + clicks) % 100;
            else current = (current - clicks) % 100;
            if (current == 0) count++;
        }
        return count;
    }

    public static int doPartTwo(ArrayList<String> fileData){
        int count = 0;
        int current = 50;
        for (String s : fileData){
            int clicks = Integer.parseInt(s.substring(1));
            int direction = s.charAt(0) == 'L' ? 0 : 1;
            for (int i = 0; i < clicks; i++){
                current = moveOnce(direction, current) % 100;
                if (current == 0) count++;
            }
        }
        return count;
    }

    public static int moveOnce(int direction, int current){
        return (direction == 0) ? --current : ++current;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
