
package interfaces;

import java.util.List;
import model.City;

public interface CityCRUD {
    
    public List list();
    public City listCity(int id);
    public boolean addCity(City city);
    public boolean listCity(City city);
    public boolean editCity(City city);
    public boolean deleteCity(int id);
    
    
    
}
