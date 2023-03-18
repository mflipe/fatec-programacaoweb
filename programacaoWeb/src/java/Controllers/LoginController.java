/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;

/**
 *
 * @author Lab03c
 */
public class LoginController {
    
    public User isUserValid(User user) {

        User newUser = new User();
        newUser.setLogin("teste");
        newUser.setName("Nome do User");
        newUser.setPassword("teste");
        
        boolean isValid = user.getLogin().equals(newUser.getLogin()) &&
                          user.getPassword().equals(newUser.getPassword());
        
        if ( isValid ) {
            return newUser;
        }
                
        return null;
    }
    
}
