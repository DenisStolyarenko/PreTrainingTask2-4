import flowers.AddToStorage;
import flowers.Bouquet;
import flowers.hierarchy.Flower;
import org.xml.sax.SAXException;
import services.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

/* Application contains decision of task 2, task 3, task 4 */
// Denis Stolyarenko
public class Runner {
    public static String currency = "KZT";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        String filePath = "D:\\sandbox\\PreTrainingTasks\\task4\\src\\main\\resources\\Flowers.txt";
        String fileOutput = "D:\\sandbox\\PreTrainingTasks\\task4\\src\\main\\resources\\Bouquets.txt";
        String fileXMLPath = "D:\\sandbox\\PreTrainingTasks\\task4\\src\\main\\resources\\flowersXML.xml";
        String fileDBPath = "jdbc:h2:~/test";

        Map<Integer,String[]> flowerMap = ReadFromFile.readFile(filePath);
        Map<Integer,String[]> flowerMap2 = new ReadFromXML().readFile(fileXMLPath);
        Map<Integer,String[]> flowerMap3 = new ReadFromDB().readFile(fileDBPath);
        Map<Integer,String[]> flowerMapping = new HashMap<>();
        System.out.println("Input source of data:");
        System.out.println("1 - File(default), 2 - XML, 3 - DB");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numb = reader.readLine();

        if (numb.equals("1")) {
            flowerMapping = flowerMap;
        } else if (numb.equals("2")) {
            flowerMapping = flowerMap2;
        } else if (numb.equals("3")) {
            flowerMapping = flowerMap3;
        } else {
            flowerMapping = flowerMap;
        }
//        printFlowerList(flowerMapping);

        List<Flower> flowerStorage = new AddToStorage().CreateStorage(flowerMapping);
        List<Bouquet> listBouquets = new ArrayList<>();



        Bouquet bouquet1 = new Bouquet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < flowerStorage.size(); j++){
                if (flowerStorage.get(j).getName().toLowerCase().equals("rose")){
                    bouquet1.gatherBouquet(flowerStorage.get(j));
                    break;
                }
            }
        }

        listBouquets.add(bouquet1);

        Bouquet bouquet2 = new Bouquet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < flowerStorage.size(); j++){
                if (flowerStorage.get(j).getName().toLowerCase().equals("peony")){
                    bouquet2.gatherBouquet(flowerStorage.get(j));
                    break;
                }
            }
        }

        listBouquets.add(bouquet2);

        Bouquet bouquet3 = new Bouquet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < flowerStorage.size(); j++){
                if (flowerStorage.get(j).getName().toLowerCase().equals("lily")){
                    bouquet3.gatherBouquet(flowerStorage.get(j));
                    break;
                }
            }
        }

        listBouquets.add(bouquet3);
        int m = 1;
        String content = "";
        for (Bouquet item: listBouquets
                ) {
            content+= m + " " + item + "\n";
            content+= "Cost of bouquet = " + item.getCost() + " " + currency + "\n";

        }
        services.FileWriter.writeToFile(fileOutput,content);

    }


    public static void printFlowerList(Map<Integer,String[]> map) {
        for (Map.Entry<Integer,String[]> s : map.entrySet()) {
            String[] masString = s.getValue();
            String content = "";
            for (int i = 0; i < masString.length; i++) {
                    content = content + " " + masString[i];
                }
            System.out.println(s.getKey() + " " + content);
        }
    }

}
