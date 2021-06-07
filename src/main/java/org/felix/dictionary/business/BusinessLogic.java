package org.felix.dictionary.business;

import org.felix.dictionary.database.CityCrud;
import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.CityComparator;
import org.felix.dictionary.utils.Parser;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessLogic {
    private List<City> cities;
    private static CityCrud<City> base;
    public BusinessLogic() throws FileNotFoundException {
        Parser p = new Parser();
        cities = p.parse();
        base = new CityCrud<City>();
    }

    public BusinessLogic(String s) throws FileNotFoundException {
        Parser p = new Parser(s);
        cities = p.parse();
        base = new CityCrud<City>();
    }
    public static void createTable() throws SQLException {
        base.createCity();
    }
    public static void insertInTable() throws SQLException {
        base.insertCity();
    }
    public static void deleteInTable( ) throws SQLException {
        base.deleteCity();
    }
    public static void updateInTable( ) throws SQLException {
        base.updateCity();
    }
    public static void readFromTable( ) throws SQLException {
        base.readCity();
    }
    public static void display(List<City> cities) {
        System.out.println("display");
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
    public static void sorter(List<City> cities) {
        System.out.println("sorter 2.1");
        Collections.sort(cities, new CityComparator());
        for (City city : cities) {
            System.out.println(city.toString());
        }
        System.out.println("sorter 2.2");
        cities.sort((p1, p2) -> {
            if (p1.getDistrict().compareTo(p2.getDistrict()) == 0) {
                return -p1.getName().compareTo(p2.getName());
            } else {
                return -p1.getDistrict().compareTo(p2.getDistrict());
            }
        });
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
    public static void maxPop(List<City> cities) {
        System.out.println("maxPop");
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
        System.out.println("[" + i + "] = " + max);
    }
    public static void kolNameInReg(List<City> cities) {
        System.out.println("kolNameInReg");
        Map<String, Integer> mapCity = new HashMap<>();
        for (City city : cities) {
            if (mapCity.containsKey(city.getRegion())) {
                int tmp = mapCity.get(city.getRegion());
                mapCity.put(city.getRegion(), tmp + 1);
            } else {
                mapCity.put(city.getRegion(), 1);
            }
        }
        for (String key : mapCity.keySet()) {
            System.out.println(key + " - " + mapCity.get(key));
        }
    }

    public  List<City> getCities() {
        return cities;
    }

}
