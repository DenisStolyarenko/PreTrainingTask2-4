package flowers.hierarchy.peonies;

import flowers.hierarchy.Peony;

public class Glory extends Peony {
    private static final String flowerName = "Peony";
    private static final String flowerSubname = "Glory";

    protected String type;

    public Glory() {
        this.setName(flowerName);
        this.type = flowerSubname;
        this.setColor("Lilac");
        this.setLength(50);
        this.setPrice(150);
    }

}
