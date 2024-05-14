package com.chatroom.chatroomfx.users;

public class User {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;


    public User() {
    }

    public User(int id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public int getId() {
        return this.id;
    }

    public User setId(int id) {
        this.id = id;
        return this;

    }

    public String getUsername() {
        return this.username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;

    }

    public String getPassword() {
        return this.password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;

    }

    public String getLastname() {
        return this.lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;

    }

    public Object[] getUserAttributesAsArray() {
        return new Object[]{id, username, password, firstname, lastname};
    }
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            "}";
    }




}
