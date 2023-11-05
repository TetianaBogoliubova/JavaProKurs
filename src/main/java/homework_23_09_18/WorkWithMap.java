package homework_23_09_18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WorkWithMap {

    //1. Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран.
    public void iterateMap(HashMap<Integer, String> hashMap, TreeMap<Integer, String> treeMap) {
        for (Map.Entry<Integer, String> h : hashMap.entrySet()) {
            System.out.println("Key of hashMap: " + h.getKey() + ", values of hashMap - " + h.getValue());
        }
        for (Map.Entry<Integer, String> t : treeMap.entrySet()) {
            System.out.println("Key of treeMap: " + t.getKey() + ", values of treeMap - " + t.getValue());
        }
    }

    //2. Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
    public void getSumOfLongAllKeys1(HashMap<Integer, String> hashMap, TreeMap<Integer, String> treeMap) {

        int keysOfHashmap = 0;
        int keyOfTreeMap = 0;

        for (Integer h : hashMap.keySet()) {
            keysOfHashmap = keysOfHashmap + h.toString().length();
        }
        for (Integer t : treeMap.keySet()) {
            keyOfTreeMap = keyOfTreeMap + t.toString().length();
        }
        int sum_size = keyOfTreeMap + keysOfHashmap;
        System.out.println("Sum all keys (key is Integer): " + sum_size);
    }

    public void getSumOfLongAllKeys2(HashMap<String, Integer> hashMap, TreeMap<String, Integer> treeMap) {
        int stringOfHashMap = 0;
        int stringOfTreeMap = 0;
        for (String i : hashMap.keySet()) {
            stringOfHashMap = stringOfHashMap + i.length();
        }
        for (String j : treeMap.keySet()) {
            stringOfTreeMap = stringOfTreeMap + j.length();
        }
        int sum_size = stringOfHashMap + stringOfTreeMap;
        System.out.println("Sum all keys (key is String): " + sum_size);
    }

    //3. Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
    public void getAverageOfValue(HashMap<String, Integer> hashMap, TreeMap<String, Integer> treeMap) {
        int sumValuesOfHashMap = 0;
        int sumValuesOfTreeMap = 0;
        int averageValueHashMap = 0;
        int averageValueTreeMap = 0;
        for (Integer h : hashMap.values()) {
            sumValuesOfHashMap = sumValuesOfHashMap + h.intValue();
            averageValueHashMap = sumValuesOfHashMap / hashMap.size();
        }
        for (Integer t : treeMap.values()) {
            sumValuesOfTreeMap += t.intValue();
            averageValueTreeMap = sumValuesOfTreeMap / treeMap.size();
        }
        System.out.println("General average values: " + (averageValueHashMap + averageValueTreeMap) / 2);
    }

    //4. Переберите HashMap и найдите ключ с максимальным значением.
    public void getMaxValueOfKeyHashMap(HashMap<String, Integer> hashMap) {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> i : hashMap.entrySet()) {
            if (maxEntry == null || i.getValue() > maxEntry.getValue()) {
                maxEntry = i;
            }
        }
        System.out.println("Max value of key: " + maxEntry);
    }

    //5. Переберите TreeMap и найдите ключ с минимальным значением.
    public void getMinValueOfKeyTreeMap(TreeMap<String, Integer> treeMap) {
        Map.Entry<String, Integer> minEntry = null;
        for (Map.Entry<String, Integer> i : treeMap.entrySet()) {
            if (minEntry == null || i.getValue() < minEntry.getValue()) {
                minEntry = i;
            }
        }
        System.out.println("Min value of key: " + minEntry);
    }

    //6. Переберите HashMap и удалите все элементы с четными значениями.
    public void deleteAllEvenValueHashMap(HashMap<String, Integer> hashMap) {
        Map<String, Integer> newHashMap = new HashMap<>();
        for (Map.Entry<String, Integer> i : hashMap.entrySet()) {
            if (i.getValue() % 2 != 0) {
                newHashMap.put(i.getKey(), i.getValue());
            }
        }
        hashMap.clear();
        hashMap.putAll(newHashMap);
        System.out.println("HashMap without even value: " + hashMap);
    }

    //7.Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы 'A'.
    public void deleteAllKeysWithFirstLetterA(TreeMap<String, Integer> treeMap) {
        Map<String, Integer> newTreeMap = new TreeMap<>();
        char firstLetter = 'A';
        for (Map.Entry<String, Integer> i : treeMap.entrySet()) {
            char currentLetter = i.getKey().charAt(0);
            if (currentLetter != firstLetter) {
                newTreeMap.put(i.getKey(), i.getValue());
            }
        }
        treeMap.clear();
        treeMap.putAll(newTreeMap);
        System.out.println("TreeMap without keys, which has first letter 'A': " + treeMap);
    }

    //8. Переберите TreeMap и найдите наибольший ключ, который меньше или равен заданному ключу.
    public void getLargeKeySetValue(TreeMap<Integer, String> treeMap, int key) {
        Integer currentKey = null;

        for (Integer i : treeMap.keySet()) {
            if (i <= key) {
                if (currentKey == null || i > currentKey) {
                    currentKey = i;
                }
            }
        }
        System.out.println("Max key than greater defined: " + currentKey);
    }

    //9. Переберите HashMap и найдите ключ с максимальной суммой значений в его вложенных HashMap: HashMap<String, HashMap<String, Integer>> nestedHashMap = new HashMap<>();
    public void getMaxSumOfValuesFromDifferentHashMaps(HashMap<String, HashMap<String, Integer>> nestedHashMap) {
        String longerKey = null;
        int maxSum = 0;
        for (Map.Entry<String, HashMap<String, Integer>> i : nestedHashMap.entrySet()) {
            int sum = 0;
            for (Integer val : i.getValue().values()) {
                sum = sum + val;
            }
            if (sum > maxSum) {
                maxSum = sum;
                longerKey = i.getKey();
            }
        }
        System.out.println("Key with max sum all values from all HashMaps: " + longerKey);
    }
}


