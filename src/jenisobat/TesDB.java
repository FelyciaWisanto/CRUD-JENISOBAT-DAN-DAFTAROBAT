package jenisobat;
import java.sql.*;
import javax.swing.JOptionPane;
public class TesDB {
    Connection tesdb;
    public static Connection TesDB() {
    try {
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection tesdb = DriverManager.getConnection("jdbc:mysql://localhost/aptika", "root", ""); 
        return tesdb;
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
        }
    }    
}
