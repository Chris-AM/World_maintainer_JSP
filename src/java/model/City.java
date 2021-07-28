
package model;


public class City {
    int id;
    String name;
    String countryCode;
    String District;
    int Population;

    public City() {
    }

    public City(int id, String name, String countryCode, String District, int Population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.District = District;
        this.Population = Population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

 
    
}
