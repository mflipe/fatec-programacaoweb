package Utils;

import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUp {
    
    private DbContext dbContext = DbContext.getContext();
    
    public void newUser(User user) {
        
        PreparedStatement statement;
        String sqlCommand = "insert into usuario (nome, login, senha) values (?, ?, ?)";

        ResultSet result;
        
        try {
            statement = dbContext.prepareStatement(
                sqlCommand, 
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            
            int i = 1;
            statement.setString(i++, user.getName());
            statement.setString(i++, user.getLogin());
            statement.setString(i++, user.getPassword());
            
            statement.execute();
            result = statement.getGeneratedKeys();
            
            if(result.next()) {
                user.setCod(result.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
