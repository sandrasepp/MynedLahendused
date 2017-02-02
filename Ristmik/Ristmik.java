package Ristmik;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleksandra on 31/01/2017.
 */

public class Ristmik {
    Map<String, Integer> suunad = new HashMap<>();

    public void lisaAuto(Auto auto) {
        String suund = auto.getSuund();
        Integer suunaCount = suunad.get(suund);
        if (suunaCount == null) {
            suunad.put(suund, 1);
        } else {
            suunad.put(suund, suunaCount + 1);
        }
    }

    public Map<String, Integer> getSuunad() {
        return suunad;
    }

    public String populaarseimSuund() {
        int count = 0;
        String suund = null;
        for (Map.Entry<String, Integer> entry : suunad.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                suund = entry.getKey();
            }
        }
        return suund;
    }

    public int autosidKokku() {
        int count = 0;
        for (Integer integer : suunad.values()) {
            count += integer;
        }
        return count;
    }
}