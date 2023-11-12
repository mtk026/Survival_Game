package org.example;

import java.util.Random;

public class Obstacle {
    Random rand =new Random();

    private String name;
    private int damage;
    private int award;
    private int healthy;
    private int maxNumber;

    public Obstacle(String name, int damage, int award, int healthy, int maxNumber) {
        this.setName(name);
        this.setDamage(damage);
        this.setAward(award);
        this.setHealthy(healthy);
        this.setMaxNumber(maxNumber);
    }
public int obstacleCount(){
    return (rand.nextInt(this.maxNumber)+1);
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
