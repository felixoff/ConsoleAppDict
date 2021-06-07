package org.felix.dictionary.model;

import java.util.Objects;

public class City implements Comparable<City> {
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City(String[] s) {
        name = s[1];
        region = s[2];
        district = s[3];
        population = Integer.parseInt(s[4]);
        foundation = Integer.parseInt(s[5]);
    }

    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
    public String getDistrict() {
        return district;
    }
    public int getPopulation() {
        return population;
    }
    public int getFoundation() {
        return foundation;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && Objects.equals(name, city.name)
                && Objects.equals(region, city.region) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }

    @Override
    public String toString() {
        return "City(name='" + this.name + "', region='" + this.region + "',district='" +
                this.district + "',population='" + this.population + "',foundation='" + this.foundation + "')";
    }
    @Override
    public int compareTo(City o) {
        return this.name.compareTo(o.name);
    }

}
