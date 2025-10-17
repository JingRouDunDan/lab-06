package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton","Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList(); // List starts with Edmonton
        City cityToDelete = mockCity();

        // Check if the city is in the list
        assertEquals(1, cityList.countcities());
        assertTrue(cityList.hasCity(cityToDelete));

        // Delete the city
        cityList.delete(cityToDelete);

        // Check if the city is deleted and the count has decrease by 1
        assertEquals(0, cityList.countcities());
        assertFalse(cityList.hasCity(cityToDelete));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList(); // List contains Edmonton
        City city_ = new City("Vancouver", "British Columbia");

        // Delete a city that isn't in the list should throw the exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city_);
        });
    }


    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        // Initially, the list should have 1 city
        assertEquals(1, cityList.countcities());

        // Add a new city and check the count again
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countcities());
    }


}
