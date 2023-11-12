package org.example;

import java.util.Scanner;
public class ToolStore extends NormalLocation {
    Scanner scan = new Scanner(System.in);

    ToolStore(Player player) {
        super(player,"Demirci");

    }

    @Override
    public boolean getLocation() {
        System.out.println("PARA: " + player.getMoney());
        System.out.println("1. SİLAHLAR");
        System.out.println("2. ZIRHLAR");
        System.out.println("3. ÇIKIŞ");
        System.out.print("SEÇİMİNİZ");
        int selTOOL = scan.nextInt();
        int selItemID;
        switch (selTOOL) {
            case 1:
                selItemID = weaponMenu();
                buyWeapoon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
                break;

        }
        return true;
    }
    public int armorMenu(){
        System.out.println("1 Hafif ZIRH\t   price : 15- Healthy : 1");
        System.out.println("2 ORTA ZIRH\t   price : 25- Healthy : 3");
        System.out.println("3 AĞIR ZIRH\t   price : 40- Healthy : 5");
        System.out.println("4 ÇIKIŞ");
        System.out.println("silah seçiniz");
        int selArmorID = scan.nextInt();
        return selArmorID;

    }
    public void buyArmor(int itemID){
        int avoid = 0;
        int price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "HAFİF ZIRH";
                price = 15;
            break;
            case 2:
                avoid = 3;
                aName = "ORTA ZIRH";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "AĞIR ZIRH";
                price = 40;
                break;
            case 4:
                System.out.println("çıkış yapılıyor");
                break;
            default:
                System.out.println("geçersiz işlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price ) {
               player.getInvetory().setArmor(avoid);
               player.getInvetory().setaName(aName);
                player.setMoney((player.getMoney() - price));
                System.out.println(aName + "    satın aldınız, Engellenen Hasar: "+player.getInvetory().getArmor());
                System.out.println("kalan paranız  : " + player.getMoney());
            } else {
                System.out.println("yeteresiz bakiye");
            }

        }


    }



    public int weaponMenu() {
        System.out.println("1 Tabanca\t   price : 25- Damage : 2");
        System.out.println("2 Kılıç\t   price : 35- Damage : 3");
        System.out.println("3 Tüfek\t   price : 45- Damage : 7");
        System.out.println("4 ÇIKIŞ");
        System.out.println("silah seçiniz");
        int selItemID = scan.nextInt();
        return selItemID;
    }

    public void buyWeapoon(int itemID) {

        int damage = 0;
        int price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Tabance";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "KILIÇ";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "TÜFEK";
                price = 45;
                break;
            case 4:
                System.out.println("çıkış yapılıyor");
                break;
            default:
                System.out.println("geçersiz işlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price ) {
                player.getInvetory().setDamage(damage);
                player.getInvetory().setwName(wName);
                player.setMoney((player.getMoney() - price));
                System.out.println(wName + "    satın aldınız önceki hasar   " + player.getDamage() + "    yeni hasar " +
                        player.getTotalDamage());
                System.out.println("kalan paranız  : " + player.getMoney());
            } else {
                System.out.println("yeteresiz bakiye");
            }

        }
    }
}

