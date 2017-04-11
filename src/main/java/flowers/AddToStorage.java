package flowers;


import flowers.hierarchy.Flower;
import flowers.hierarchy.Lily;
import flowers.hierarchy.Peony;
import flowers.hierarchy.Rose;
import flowers.interfaces.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddToStorage implements Storage{
    List<Flower> list;

    public AddToStorage(){
        list = new ArrayList<>();
    }

    @Override
    public List<Flower> CreateStorage(Map<Integer,String[]> map) {
        for (Map.Entry<Integer,String[]> s : map.entrySet()) {
            String[] masString = s.getValue();
            if (masString.length != 4) {
                continue;
            }
            String str = masString[0].toLowerCase();
            if (str.equals("rose")){
                Flower rose = new Rose();
                rose.setColor(masString[1]);
                rose.setLength(Double.parseDouble(masString[2]));
                rose.setPrice(Double.parseDouble(masString[3]));
                list.add(rose);
                continue;
            }
            if (str.equals("peony")){
               Flower peony = new Peony();
               list.add(peony);
               continue;
            }
            if (str.equals("lily")){
               Flower lily = new Lily();
               list.add(lily);
               continue;
            }

        }
        return list;
    }
}
