package org.example;

public class River extends BattelLocation{
    River(Player player) {
        super(player, "River", new Bear(),"WATER");
    }
}
