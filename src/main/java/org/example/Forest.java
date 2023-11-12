package org.example;

public class Forest extends BattelLocation{
    Forest(Player player ) {
        super(player, "Orman", new Vampire(),"FIREWOOD");
    }
}
