/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;
import java.util.ArrayList;

public class UserHandler {

    private ArrayList<User> users;

    public UserHandler() { users = new ArrayList<>();
    }
    public void registerUser(String username,String password) {

        users.add( new User(username,password));
    }
    public User loginUser(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}