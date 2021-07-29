
package configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MyConnection {
 
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/world?user=" + user + "&password=" + password;
    
    protected Connection conn = null;

    public MyConnection() {
        System.out.println("this iss the url -> "+ url);
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            if(conn != null){
                System.out.println("Connection OK" + conn);
                System.out.println("this iss the url -> "+ url);
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