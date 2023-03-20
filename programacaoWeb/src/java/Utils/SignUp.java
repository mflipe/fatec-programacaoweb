package Utils;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUp {

    public SignUp() {
    }

    private final Connection dbContext = DbContext.getContext();

    /**
     *
     * @param user
     */
    public void createUser(User user) {
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

            if (result.next()) {
                user.setCod(result.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser(String login) {
        User user = null;
        PreparedStatement st;
        ResultSet res;

        String sqlCommand = "select cod, nome, login, senha from usuario where login = ? ";

        int i = 1;
        try {
            Connection dbContext = DbContext.getContext();
            st = dbContext.prepareStatement(sqlCommand);
            st.setString(i, login);
            res = st.executeQuery();
            if (res.next()) {
                user = new User();
                user.setCod(res.getInt("cod"));
                user.setName(res.getString("nome"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);

        }
        return user;
    }

}
