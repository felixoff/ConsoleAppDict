package tests;
import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.CityComparator;
import org.felix.dictionary.utils.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class Module2Test {

    @Test

    public void main_sort1_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        Collections.sort(cities);
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Адыгейск", "Брянск", "Горно-Алтайск", "Майкоп", "Москва"};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void main_sort1_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        Collections.sort(cities, new CityComparator());
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Брянск", "Адыгейск", "Горно-Алтайск", "Майкоп", "Москва"};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void main_sort2_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        cities.sort((p1, p2) -> {
            if (p1.getDistrict().compareTo(p2.getDistrict()) == 0) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getDistrict().compareTo(p2.getDistrict());
            }
        });
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Горно-Алтайск", "Брянск", "Москва", "Адыгейск", "Майкоп"};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void main_sort2FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        cities.sort((p1, p2) -> {
            if (p1.getDistrict().compareTo(p2.getDistrict()) == 0) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getDistrict().compareTo(p2.getDistrict());
            }
        });
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Горно-Алтайск", "Москва", "Брянск", "Адыгейск", "Майкоп"};
        Assert.assertArrayEquals(expected, actual);
    }

}
