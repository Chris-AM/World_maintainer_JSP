
package configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MyConnection {
 
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/world";
    
    protected Connection conn = null;

    public MyConnection() {
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(driver, user, password);
            if(conn != null){
                System.out.println("Connection OK" + conn);
            }
        } catch ( SQLException ex) {
            System.out.println("Connection Error" + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Driver error" + ex.getMessage());
        }
    }
    public Connection connect(){
        return conn;
    }
    
    public void disconnect(){
       
        try {
             System.out.println("Closing DB" + conn);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("MySQL error" + ex);
        }
    }
}