package tests;
import org.felix.dictionary.business.BusinessLogic;
import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Module1Test {
    @Test
    public void main_Foundation_SUCESS() throws FileNotFoundException {
        BusinessLogic busiiness = new BusinessLogic();
        List<City> cities = busiiness.getCities();
        int[] expected = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getFoundation();
            i++;
        }
        int[] actual = {1147,1973,1857,1830,891};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void module1_SUCESS() throws FileNotFoundException {
        BusinessLogic busiiness = new BusinessLogic();
        List<City> expected = busiiness.getCities();
        City city1 = new City("1;Москва;Москва;Центральный;12929922;1147".split(";"));
        City city2 = new City("2;Адыгейск;Адыгея;Южный;12938;1973".split(";"));
        City city3 = new City("3;Майкоп;Адыгея;Южный;144321;1857".split(";"));
        City city4 = new City("4;Горно-Алтайск;Алтай;Сибирский;56943;1830".split(";"));
        City city5 = new City("5;Брянск;Брянск;Центральный;538822;891".split(";"));
        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);
        actual.add(city4);
        actual.add(city5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void module1_FAIL() throws FileNotFoundException {
        BusinessLogic busiiness = new BusinessLogic();
        List<City> expected = busiiness.getCities();
        City city1 = new City("1;Москва;Мосва;Центральный;12929922;1147".split(";"));
        City city2 = new City("2;Адыгейск;Адыгея;Южный;12938;1973".split(";"));
        City city3 = new City("3;Майкоп;Адыгея;Южный;144321;1857".split(";"));
        City city4 = new City("4;Горно-Алтайск;Алтай;Сибирский;56943;1830".split(";"));
        City city5 = new City("5;Брянск;Брянск;Центральный;538822;891".split(";"));
        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);
        actual.add(city4);
        actual.add(city5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void main_Foundation_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        int[] expected = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getFoundation();
            i++;
        }
        int[] actual = {1147,1973,1857,1830,91};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void main_Population_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        int[] expected = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getPopulation();
            i++;
        }
        int[] actual = {12929922,12938,144321,56943,538822};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void main_Population_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        int[] expected = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getPopulation();
            i++;
        }
        int[] actual = {12938,12929922,144321,56943,538822};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void main_Name_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Москва","Адыгейск","Майкоп","Горно-Алтайск","Брянск"};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void main_Name_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        String[] expected = new String[cities.size()];
        int i = 0;
        for (City city : cities) {
            expected[i] = city.getName();
            i++;
        }
        String[] actual = {"Москва","Адыгейск","Майоп","Горно-Алтайск","Брянск"};
        Assert.assertArrayEquals(expected,actual);
    }

}