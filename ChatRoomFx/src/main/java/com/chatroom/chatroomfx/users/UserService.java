package com.chatroom.chatroomfx.users;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chatroom.chatroomfx.database.DatabaseQuery;

public class UserService {
    private DatabaseQuery database;

    public UserService(DatabaseQuery database) throws SQLException, IOException {
        this.database = database;
    }


    public User getUserById(int id) throws SQLException{
        String query ="select * from users where id=?";
            ResultSet result =this.database.executeQuery(query,id);
            return this.ResultSetToUserObject(result);
    }

    public User getUserByUsername(String username) throws SQLException{
        String query ="select * from users where username=?";
            ResultSet result =this.database.executeQuery(query,username);
            return this.ResultSetToUserObject(result);
        
    }

    public void addUser(User user) throws SQLException{
        String query = "insert into users(username , password ,firstname,lastname) values (?,?,?,?)";
        this.database.executeUpdate(query,user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname());
        
    }


    private User ResultSetToUserObject(ResultSet set) throws SQLException{
        User user = new User();
        if(set.next()) {
            user.setId(set.getInt("id"));
            user.setUsername(set.getString("username"));
            user.setPassword(set.getString("password"));
            user.setFirstname(set.getString("firstname"));
            user.setLastname(set.getString("lastname"));
        }
        return user;
    }
}
