package tests;

import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class Module3Test {
    @Test
    public void main_max_SUCESS() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        City[] cityMass = cities.toArray(new City[0]);
        //   int[] cityMas = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            cityMass[i] = city;
            i++;
        }
        i = 0;
        int max = cityMass[0].getPopulation();
        while (i < cities.size()) {
            if (max < cityMass[i].getPopulation()) {
                max = cityMass[i].getPopulation();
                break;
            }
            i++;
        }
        Assert.assertEquals(i,5);
        Assert.assertEquals(max,12929922);
    }

    @Test
    public void main_max_FAIL() throws FileNotFoundException {
        List<City> cities = Parser.parse();
        City[] cityMass = cities.toArray(new City[0]);
        //   int[] cityMas = new int[cities.size()];
        int i = 0;
        for (City city : cities) {
            cityMass[i] = city;
            i++;
        }
        i = 0;
        int max = cityMass[0].getPopulation();
        while (i < cities.size()) {
            if (max < cityMass[i].getPopulation()) {
                max = cityMass[i].getPopulation();
                break;
            }
            i++;
        }
        Assert.assertEquals(i,5);
        Assert.assertEquals(max,1292922);
    }
}