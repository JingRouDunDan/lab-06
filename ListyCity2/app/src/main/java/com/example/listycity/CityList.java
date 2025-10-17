package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds our City type objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city city that is added
     *  This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);

    }
    /**
     * This returns a sorted list of cities
     * @return
     *  Return the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This return whether or not it belongs in the list, when given a city.
     * @param city The city object to check if is in the list or not.
     * @return True or false if the city object is in the list.
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This function deletes a city from the list
     * @param city The city that is being deleted
     */
    public void delete(City city){
        if (!hasCity(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This function returns the number of cities in the list
     * @return the number of cities in the list
     */
    public int countcities(){
        return cities.size();
    }

}
