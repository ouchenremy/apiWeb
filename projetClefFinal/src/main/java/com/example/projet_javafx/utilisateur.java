package com.example.projet_javafx;

public class utilisateur {
    private String user;

    private String password;

    public utilisateur(String unUser, String unPassword) {
        this.user = unUser;
        this.password = unPassword;
    }

    public String getUser(){

        return this.user;
    }

    public void setUser(String unUser) {

        this.user = unUser;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String unPassword) {

        this.password = unPassword;
    }

}

