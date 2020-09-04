package lesson_three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Home {
    private static final String[] citiesArr = {"Арзамас", "Баку", "Владимир", "Донецк", "Ереван", "Жуковский",
                                "Залещенск", "Ижевск", "ЙошкарОла", "Калининдрад", "Баку","Ереван"};

    private static TreeSet getCities (String[] arr) {
        return new TreeSet<>(Arrays.asList(arr));
    }

    private static HashMap<String, Integer> getCitiesCount (String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String city = arr[i];
            if (map.containsKey(city)) {
                map.put(city, map.get(city) + 1);
            }
            else map.put(city, 1);
        }
        return map;
    }



    public static void main (String[] args) {
        System.out.println(getCities(citiesArr));
        System.out.println(getCitiesCount(citiesArr));
    }

}
