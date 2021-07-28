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
        String sql = "SELECT * FROM city";
        
        try {
          connection = myConnection.connect();
          preparedStatement = connection.prepareStatement(sql);
          resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
              City city = new City();
              city.setId(resultSet.getInt("ID"));
              city.setName(resultSet.getString("Name"));
              city.setCountryCode(resultSet.getString("CountryCode"));
              city.setDistrict(resultSet.getString("District"));
              city.setPopulation(resultSet.getInt("Population"));
              listCity.add(city);
          }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return null;
    }

    @Override
    public City listCity(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCity(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
