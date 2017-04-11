package flowers.hierarchy;

public class Lily extends Flower {
    private static final String flowerName = "Lily";
    public Lily() {
        this.setName(flowerName);
        this.setColor("white");
        this.setLength(60);
        this.setPrice(230);
    }

    public Lily(String color, double length, double price) {
        this.setName(flowerName);
        this.setColor(color);
        this.setLength(length);
        this.setPrice(price);
    }
}
