/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import Utils.SignUp;

/**
 *
 * @author Lab03c
 */
public class LoginController {

    private SignUp _singUpService = new SignUp();

    public User isUserValid(User user) {

        User newUser = _singUpService.getUser(user.getLogin());
        
        boolean isValid = user.getLogin().equals(newUser.getLogin()) &&
                          user.getPassword().equals(newUser.getPassword());
        
        if ( isValid ) {
            return newUser;
        }
                
        return null;
    }
    
}
