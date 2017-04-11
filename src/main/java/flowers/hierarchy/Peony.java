package flowers.hierarchy;

public class Peony extends Flower {
    private static final String flowerName = "Peony";

    public Peony() {
        this.setName(flowerName);
        this.setColor("Lilac");
        this.setLength(70);
        this.setPrice(200);
    }

    public Peony(String color, double length, double price) {
        this.setName(flowerName);
        this.setColor(color);
        this.setLength(length);
        this.setPrice(price);
    }
}
