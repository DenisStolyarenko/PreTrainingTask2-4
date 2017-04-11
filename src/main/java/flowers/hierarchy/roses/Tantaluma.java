package flowers.hierarchy.roses;

import flowers.hierarchy.Rose;

public class Tantaluma extends Rose {
    private static final String flowerName = "Rose";
    private static final String flowerSubname = "Tantaluma";

    protected String type;

    public Tantaluma() {
        this.setName(flowerName);
        this.type = flowerSubname;
        this.setColor("Red");
        this.setLength(50);
        this.setPrice(150);

    }

}
