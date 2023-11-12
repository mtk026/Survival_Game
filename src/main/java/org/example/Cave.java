package org.example;

public class Cave extends BattelLocation{
    Cave(Player player) {
        super(player, "Cave", new Zombie(),"FOOD");
    }
}
