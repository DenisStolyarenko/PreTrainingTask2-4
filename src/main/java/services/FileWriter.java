package services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    public static void writeToFile(String fileName, String content) {
        String text = content + "\n";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(text);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
