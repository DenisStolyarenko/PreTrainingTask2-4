package flowers.hierarchy.peonies;

import flowers.hierarchy.Peony;

public class PearlDust extends Peony{
    private static final String flowerName = "Peony";
    private static final String flowerSubname = "PearlDust";

    protected String type;

    public PearlDust() {
        this.setName(flowerName);
        this.type = flowerSubname;
        this.setColor("Lilac");
        this.setLength(50);
        this.setPrice(150);
    }
}
