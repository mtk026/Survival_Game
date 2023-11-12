package org.example;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    Scanner scan = new Scanner(System.in);

    public void login() {

        System.out.println("MACERA OYUNUNA HOŞ GELDİNİZ");
        System.out.println("OYUNA BAŞLAMADAN ÖNCE İSMİNİZİ GİRİNİZ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start() {
        while (true){
            System.out.println();
            System.out.println("xxxxxxxxxxxxxxxxxx");
            System.out.println("nereye gitmek istiyorsun");
            System.out.println("1. GÜVENLİ EV ---> YARALARI SARMAK VE DİNLENMEK İÇİN BİR YER");
            System.out.println("2. MAĞRA ----> ZOMBİLERLE DOLU BİR ALAN AMA ÖDÜLÜNE DEĞER");
            System.out.println("3. ORMAN----> VAMPİRLER KANINIZI EMMEK İÇİN BEKLİYOR ");
            System.out.println("4. NEHİR ----> İRİ PENÇELİ AYILAR İÇİN ZIRHINIZ PARÇALAMAK HİÇTE ZOR DEĞİL");
            System.out.println("5. DEMİRCİ ----> PARÇALANMIŞ ZIRHLARI VE KIRILMIŞ SİLAHLARI DEĞİŞTİRMEK İÇİN İDEAL BİR YER");
            System.out.println("LÜTFEN BİR SONRAKİ MACERAYI SEÇİNİZ");
            int selLoc = scan.nextInt();
            while (selLoc < 1 || selLoc > 5) {
                System.out.print("lütfen gidebileceğimiz bir yer seçiniz");
                selLoc = scan.nextInt();
            }
            switch(selLoc){
                case 1 : location=new SafeHouse(player);
                    break;
                case 2:
                    location=new Cave(player);
                    break;
                case 3:
                    location=new Forest(player);
                    break;
                case 4:
                    location =new River(player);
                    break;
                case 5:
                    location=new ToolStore(player);
                    break;

            }
            if(location.getName().equals("SafeHouse")) {
                if(player.getInvetory().isFirewood()&&player.getInvetory().isWater()&&player.getInvetory().isFood()){
                System.out.println("Tebrikler Oyunu kazandınız");
                break;
            }

            }
            if(!location.getLocation()){
                System.out.println("OYUN BİTTİ");
             break;
            }

        }


    }


}
