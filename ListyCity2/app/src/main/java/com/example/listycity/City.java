package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }


    String getCityName() {
        return this.city;
    }
    String getProvinceName () {
        return this.province;
    }

    /**
     * This method compares cities based on city name field
     * @param o the object to be compared.
     * @return -1 if the caller is greater than the city name field of called object
     *
     */
    @Override
    public int compareTo(Object o){
        City city = (City) o; //typecasting
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     *This functions tells the system when 2 city object is equal
     * @param o the objects that are being  compared with
     * @return if the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        City city_1 = (City) o;
        return Objects.equals(city, city_1.city) &&
                Objects.equals(province, city_1.province);
    }

    /**
     * This function generates a unique id to determine if two objects has the same id value.
     * @return id for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}