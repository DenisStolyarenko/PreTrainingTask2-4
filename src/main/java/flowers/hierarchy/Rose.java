package flowers.hierarchy;

public class Rose extends Flower {
    private static final String flowerName = "Rose";
    private static final double defaultLength = 55;
    public Rose() {
        this.setName(flowerName);
        this.setColor("Red");
        this.setLength(defaultLength);
        this.setPrice(150);
    }

    public Rose(String color, double price) {
        this.setName(flowerName);
        this.setColor(color);
        this.setLength(defaultLength);
        this.setPrice(price);
    }

    public Rose(String color, double length, double price) {
        this.setName(flowerName);
        this.setColor(color);
        this.setLength(length);
        this.setPrice(price);
    }

}
