package daoModel;

import configurations.MyConnection;
import interfaces.CityCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.City;

public class CityDAO implements CityCRUD {

    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    City city = new City();

    @Override
    public List list() {
        ArrayList<City> listCity = new ArrayList<>();
        String sql = "select * from city";

        try {
            connection = myConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("ID"));
                city.setName(resultSet.getString("Name"));
                city.setCountryCode(resultSet.getString("CountryCode"));
                city.setDistrict(resultSet.getString("District"));
                city.setPopulation(resultSet.getInt("Population"));
                listCity.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            myConnection.disconnect();
        }

        return listCity;
    }

    @Override
    public City listCity(int id) {
        String sql = "select * from city where ID = " + id;

        try {
            connection = myConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                city.setId(resultSet.getInt("ID"));
                city.setName(resultSet.getString("Name"));
                city.setCountryCode(resultSet.getString("CountryCode"));
                city.setDistrict(resultSet.getString("District"));
                city.setPopulation(resultSet.getInt("Population"));
                
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            myConnection.disconnect();
        }

        return city;
    }

    @Override
    public boolean addCity(City city) {
        String sql = "insert into city (Name, CountryCode, District, Population) values ('"
                + city.getName() + "','"
                + city.getCountryCode() + "','"
                + city.getDistrict() + "',"
                + city.getPopulation() + ")";
        System.out.println("this this the QUERY -> " + sql);
        try {
            connection = myConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL ERROR " + e.getMessage());
        } finally{
            myConnection.disconnect();
        }
        return false;
    }

    @Override
    public boolean listCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editCity(City city) {
       String sql = "update city set Name = '" + city.getName() 
                + "', CountryCode = '" + city.getCountryCode() 
                + "', District = '" + city.getDistrict() 
                + "', population = " + city.getPopulation()
                + " where ID = " + city.getId();
        System.out.println("this this the QUERY -> " + sql);
        try {
            connection = myConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL ERROR " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteCity(int id) {
       String sql = "delete from city where id = " +  id;
       System.out.println("this this the QUERY -> " + sql);
       try {
            connection = myConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL ERROR " + e.getMessage());
        } 
        return false;
    }

}
