package org.felix.dictionary.utils;

import org.felix.dictionary.model.City;

import java.util.Comparator;

public class CityComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return -o1.getName().compareTo(o2.getName());
    }
}