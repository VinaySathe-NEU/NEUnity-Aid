package Business.DatabaseUtility;

import Business.Ecosystem;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.nio.file.Paths;
import java.io.IOException;


public class DatabaseManager {
    
    private static String FILE_NAME = Paths.get("NEUnity-Aid.db").toAbsolutePath().toString();
    private ObjectMapper mapper = new ObjectMapper();

    public DatabaseManager() {
        createConnection();
    }

    public Connection createConnection() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + FILE_NAME;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void storeEcosystemObject(Ecosystem ecosystem) {
        String json = null;
        try {
            json = mapper.writeValueAsString(ecosystem); // convert object to JSON
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + FILE_NAME)) {
            String sql = "INSERT INTO system_objects(json) VALUES(?)"; // SQL statement
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, json); // set JSON string as parameter
            pstmt.executeUpdate(); // execute SQL statement
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public <T> T retrieveSystemObject (Class<T> type, int id) {
            T result = null;
            String sql = "SELECT json FROM system_objects WHERE id = ?";
    
            try (Connection conn = this.createConnection();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)){
                
                pstmt.setInt(1, id);
                ResultSet rs  = pstmt.executeQuery();
    
                // loop through the result set
                while (rs.next()) {
                    String json = rs.getString("json");
                    result = mapper.readValue(json, type); // convert JSON to object
                }
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
            return result;
        }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }       
    
}