package flowers.interfaces;

import flowers.hierarchy.Flower;

import java.util.List;
import java.util.Map;

public interface Storage {
    List<Flower> CreateStorage(Map<Integer,String[]> map);
}
