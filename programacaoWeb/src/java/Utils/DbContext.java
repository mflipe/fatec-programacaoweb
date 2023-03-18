package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbContext {
    
    private static Connection dbContext;
    public static DbContext shared;

    public static Connection getContext() {

        if (shared == null) {
            shared = new DbContext();
            shared.setUp();
        }

        return dbContext;
    }

    private void setUp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://localhost:3306/pweb";
            dbContext = DriverManager.getConnection(jdbc, "fatec", "fatec");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
