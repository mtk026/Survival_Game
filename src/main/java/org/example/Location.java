package org.example;

import java.util.Scanner;

public abstract class Location {
    Scanner scan =new Scanner(System.in);
    protected Player player; //player nesnesinin değerleri daha önce yapmış olduğumuz tercihten dolayı
    // sabit aslında player class ı ile location classı arasında ki
    // tek bağlantı location da player classına ait bir nesne üretilmiş olması.
    protected String name;

    public abstract boolean getLocation();
    Location(Player player){
        this.player=player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
