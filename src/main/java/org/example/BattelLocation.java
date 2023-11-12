package org.example;

public abstract class BattelLocation extends Location {
    protected Obstacle obstacle;
    protected String award;


    BattelLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obsCoun = obstacle.obstacleCount();
        System.out.println("ŞU AN " + this.getName() + " korkunç " + obsCoun + " adet " + obstacle.getName() + "  bulunmaktadır.");
        System.out.println("<S>avaş veya <K>aç");
        String selCase = scan.nextLine();

        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCoun)) {
                System.out.println(this.getName() + " Tüm Düşmaanları temizlediniz");
                if (this.award.equals("FOOD") && player.getInvetory().isFood() == false) {
                    System.out.println(this.award + " Kazandınız");
                    player.getInvetory().setFood(true);
                } else if (this.award.equals("WATER") && player.getInvetory().isWater() == false) {
                    System.out.println(this.award + " Kazandınız");
                    player.getInvetory().setWater(true);
                } else if (this.award.equals("FIREWOOD") && player.getInvetory().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız");
                    player.getInvetory().setFirewood(true);
                }
                return true;

            }
            else if(player.getHealthy()<=0){
                System.out.println("öldünüz");
                return false;
            }


        }
        return true;
    }

    public boolean combat(int obsCoun) {
        for (int i = 0; i < obsCoun; i++) {
            int defObsHealth = obstacle.getHealthy();
            playerStats();
            enemyStats();

            while (player.getHealthy() > 0 && obstacle.getHealthy() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selCase =scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Siz Vurdunuz");
                    obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                    System.out.println("                ");
                    System.out.println(obstacle.getName() + " canı  " + obstacle.getHealthy());
                    System.out.println("--------------------------------");
                    if (obstacle.getHealthy() >= 0) {
                        System.out.println("canavar size vurdu");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInvetory().getArmor()));
                        System.out.println("          ");
                        System.out.println("oyuncu canı" + player.getHealthy());
                        System.out.println("-----------------------------*-");
                    }
                    } else {
                    break;
                }
            }


            if ((obstacle.getHealthy() <= 0) && (player.getHealthy() > 0)) {
                System.out.println("düşmanı yendiniz");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("güncel paranız" + player.getMoney());
                obstacle.setHealthy(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-----xxxxxx-------");

        }
        return true;
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri\n");
        System.out.println("can:  " + player.getHealthy());
        System.out.println("HASAR:  " + player.getTotalDamage());
        System.out.println("para: " + player.getMoney());
        if (player.getInvetory().getDamage() > 0) {
            System.out.println("Silah: " + player.getInvetory().getwName());
        }
        if (player.getInvetory().getArmor() > 0) {
            System.out.println("Zırh:  " + player.getInvetory().getaName());
        }
    }

    public void enemyStats() {
        System.out.println(obstacle.getName() + " değerleri \n");
        System.out.println("can: " + obstacle.getHealthy());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ödül: " + obstacle.getAward() * obstacle.obstacleCount());
    }

}
