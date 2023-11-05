package homework_23_09_18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        WorkWithMap workWithMap = new WorkWithMap();

        Map mapHash1 = new HashMap<>();
        mapHash1.put(341, "Mikael");
        mapHash1.put(123, "Nik");
        mapHash1.put(458, "Jane");
        mapHash1.put(349, "Paul");
        mapHash1.put(234, "Anna-Maria");
        mapHash1.put(461, "Alla");
        mapHash1.put(162, "Veronika");

        Map mapHash2 = new HashMap<>();
        mapHash2.put("Mik", 15);
        mapHash2.put("Nik", 11);
        mapHash2.put("Jane", 32);
        mapHash2.put("Paul", 8);
        mapHash2.put("Anna", 2);

        Map<Integer, String> mapTree1 = new TreeMap<>();
        mapTree1.put(456, "Mik");
        mapTree1.put(457, "Nikolas");
        mapTree1.put(458, "Jane");
        mapTree1.put(459, "Pol");
        mapTree1.put(460, "Annabella");
        mapTree1.put(461, "Allan");
        mapTree1.put(462, "Vera");

        Map<String, Integer> mapTree2 = new TreeMap<>();
        mapTree2.put("Mikolaj", 82);
        mapTree2.put("Nikol", 41);
        mapTree2.put("Jane", 15);
        mapTree2.put("Pol", 4);
        mapTree2.put("Annabella", 11);


        Map<String, Integer> nestedHashMap1 = new HashMap<>();
        nestedHashMap1.put("Name1", 10);
        nestedHashMap1.put("Name2", 14);
        nestedHashMap1.put("Name3", 17);
        nestedHashMap1.put("Name4", 3);

        Map<String, Integer> nestedHashMap2 = new HashMap<>();
        nestedHashMap2.put("Name1", 10);
        nestedHashMap2.put("Name2", 23);
        nestedHashMap2.put("Name3", 7);
        nestedHashMap2.put("Name4", 8);

        Map<String, Integer> nestedHashMap3 = new HashMap<>();
        nestedHashMap3.put("Name1", 12);
        nestedHashMap3.put("Name2", 24);
        nestedHashMap3.put("Name3", 17);
        nestedHashMap3.put("Name4", 50);

        HashMap<String, HashMap<String, Integer>> nestedHashMap = new HashMap<>();
        nestedHashMap.put("SurName1", (HashMap<String, Integer>) nestedHashMap1);
        nestedHashMap.put("SurName2", (HashMap<String, Integer>) nestedHashMap2);
        nestedHashMap.put("SurName3", (HashMap<String, Integer>) nestedHashMap3);


        workWithMap.iterateMap((HashMap<Integer, String>) mapHash1, (TreeMap<Integer, String>) mapTree1);
        workWithMap.getSumOfLongAllKeys1((HashMap<Integer, String>) mapHash1, (TreeMap<Integer, String>) mapTree1);
        workWithMap.getSumOfLongAllKeys2((HashMap<String, Integer>) mapHash2, (TreeMap<String, Integer>) mapTree2);
        workWithMap.getAverageOfValue((HashMap<String, Integer>) mapHash2, (TreeMap<String, Integer>) mapTree2);
        workWithMap.getMaxValueOfKeyHashMap((HashMap<String, Integer>) mapHash2);
        workWithMap.getMinValueOfKeyTreeMap((TreeMap<String, Integer>) mapTree2);
        workWithMap.deleteAllEvenValueHashMap((HashMap<String, Integer>) mapHash2);
        workWithMap.deleteAllKeysWithFirstLetterA((TreeMap<String, Integer>) mapTree2);
        workWithMap.getLargeKeySetValue((TreeMap<Integer, String>) mapTree1, 463);
        workWithMap.getMaxSumOfValuesFromDifferentHashMaps(nestedHashMap);
    }
}
