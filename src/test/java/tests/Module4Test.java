package tests;

import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module4Test {
    @Test
    public void main_map_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        Map<String, Integer> mapCity = new HashMap<>();
        for (City city : cities) {
            if (mapCity.containsKey(city.getRegion())) {
                int tmp = mapCity.get(city.getRegion());
                mapCity.put(city.getRegion(), tmp + 1);
            } else {
                mapCity.put(city.getRegion(), 1);
            }
        }
        Map<String, Integer> actual = new HashMap<>();
        actual.put("Москва", 1);
        actual.put("Адыгея", 2);
        actual.put("Брянск",1);
        actual.put("Алтай", 1);
        Assert.assertEquals(mapCity,actual);
    }

    @Test
    public void main_map_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        Map<String, Integer> mapCity = new HashMap<>();
        for (City city : cities) {
            if (mapCity.containsKey(city.getRegion())) {
                int tmp = mapCity.get(city.getRegion());
                mapCity.put(city.getRegion(), tmp + 1);
            } else {
                mapCity.put(city.getRegion(), 1);
            }
        }
        Map<String, Integer> actual = new HashMap<>();
        actual.put("Москва", 2);
        actual.put("Адыгя", 2);
        actual.put("Брянск",1);
        actual.put("Алтай", 1);
        Assert.assertEquals(mapCity,actual);
    }
}