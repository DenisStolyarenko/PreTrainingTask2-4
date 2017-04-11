package flowers.hierarchy;

public class Chrysanthemum extends Flower{
    private static final String flowerName = "Chrysanthemum";
    public Chrysanthemum() {
        this.setName(flowerName);
        this.setColor("yellow");
        this.setLength(80);
        this.setPrice(230);
    }

    public Chrysanthemum(String color, double length, double price) {
        this.setName(flowerName);
        this.setColor(color);
        this.setLength(length);
        this.setPrice(price);

    }
}
