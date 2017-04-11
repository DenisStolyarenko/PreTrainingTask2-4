package services;


import flowers.interfaces.ReaderData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFromFile {

    public static Map<Integer,String[]> readFile(String filePath){
        File file = new File(filePath);
        Scanner scanner = null;
        Map<Integer,String[]> flowerValueMap = new HashMap<>();
        int keyMap = 0;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] mas = line.split(";");
                flowerValueMap.put(keyMap++,mas);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + filePath + " was not found");
        } finally {
            scanner.close();
        }
    return flowerValueMap;
    }
}
