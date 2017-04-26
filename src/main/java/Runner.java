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
        Runner app = new Runner();
        String baseDir = new File(".").getCanonicalPath();

        String fileDBPath = "jdbc:h2:~/test";

        String filePath = baseDir + "\\src\\main\\resources\\Flowers.txt";
        String fileXMLPath = baseDir + "\\src\\main\\resources\\flowersXML.xml";
        String fileOutput = baseDir + "\\src\\main\\resources\\Bouquets.txt";

        Map<Integer,String[]> flowerMapping = new HashMap<>();
        System.out.println("Input source of data:");
        System.out.println("1 - File(default), 2 - XML, 3 - DB");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numb = reader.readLine();

        if (numb.equals("1")) {
            flowerMapping = ReadFromFile.readFile(filePath);
        } else if (numb.equals("2")) {
            flowerMapping = new ReadFromXML().readFile(fileXMLPath);
        } else if (numb.equals("3")) {
            flowerMapping = new ReadFromDB().readFile(fileDBPath);
        } else {
            flowerMapping = ReadFromFile.readFile(filePath);
        }
//        printFlowerList(flowerMapping);

        List<Flower> flowerStorage = new AddToStorage().CreateStorage(flowerMapping);
        List<Bouquet> listBouquets = new ArrayList<>();

        listBouquets.add(app.createBouquet(flowerStorage,"rose"));
        listBouquets.add(app.createBouquet(flowerStorage,"peony"));
        listBouquets.add(app.createBouquet(flowerStorage,"lily"));

        int m = 1;
        String content = "";
        for (Bouquet item: listBouquets
                ) {
            content+= m + " " + item + "\n";
            content+= "Cost of bouquet = " + item.getCost() + " " + currency + "\n";

        }
        services.FileWriter.writeToFile(fileOutput,content);

    }

    public Bouquet createBouquet(List<Flower> flowerStorage, String name) {
        Bouquet bouquet = new Bouquet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < flowerStorage.size(); j++) {
                if (flowerStorage.get(j).getName().toLowerCase().equals(name)) {
                    bouquet.gatherBouquet(flowerStorage.get(j));
                    break;
                }
            }
        }

        return bouquet;
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
