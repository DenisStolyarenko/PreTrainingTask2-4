package flowers.hierarchy.roses;

import flowers.hierarchy.Rose;

public class BurgundyIceberg extends Rose {
    private static final String flowerName = "Rose";
    private static final String flowerSubname = "BurgundyIceberg";
    protected String type;

    public BurgundyIceberg() {
        this.setName(flowerName);
        this.type = flowerSubname;
        this.setColor("Red");
        this.setLength(50);
        this.setPrice(150);
    }
}
