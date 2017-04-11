package flowers;

import flowers.hierarchy.Flower;
import flowers.interfaces.CreateBouquet;

import java.util.ArrayList;
import java.util.List;

public class Bouquet implements CreateBouquet{
    public List<Flower> getBouquet() {
        return bouquet;
    }

    List<Flower> bouquet;

    public Bouquet() {
        bouquet = new ArrayList<>();
    }

    @Override
    public double getCost()
    {
        double result = 0;
        for (int i = 0; i < bouquet.size(); i++) {
            result = result + bouquet.get(i).getPrice();
        }
        return result;
    }

    @Override
    public void gatherBouquet(Flower flower) {
        bouquet.add(flower);

    }

    @Override
    public String toString() {
        String text = "bouquet = ";
        for (Flower item: bouquet) {
            text += item.getName() + " " + item.getColor() + ",";
        }
        return text;
    }
}
