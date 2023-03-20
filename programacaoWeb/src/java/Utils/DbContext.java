package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbContext {

    public static Connection getContext() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String jdbc = "jdbc:mysql://localhost:3306/pweb?allowPublicKeyRetrieval=true&clientCertificateKeyStoreUrl=file:/Users/mini_01/GlassFish_Server/glassfish/domains/domain1/config/keystore.jks&clientCertificateKeyStorePassword=changeit";
            Connection dbContext = DriverManager.getConnection(jdbc, "root", "123456");
            return dbContext;
        } catch (SQLException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
