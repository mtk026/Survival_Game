package org.example;


import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private String cName;
    private int rHealty;

    private Inventory inventory;


    public Player(String name) {
        this.setName(name);
        this.inventory = new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlayer("Samuray", 5, 21, 15);//character abstract classı altında yeni sınıflar oluşturulacak
                break;
            case 2:
                initPlayer("Okçu", 7, 18, 20);
                break;
            case 3:
                initPlayer("Şovalye", 8, 24, 5);
                break;
            default:
                initPlayer("Samuray", 5, 21, 15);
                break;
        }
        System.out.println("karakter seçildi  " + "\tADI=" + getcName() +
                "\tHASAR=" + getDamage() + "\tSAĞLIK=" + getHealthy() + "\tPARA=" + getMoney());
    }

    public int chaMenu() {
        System.out.println("LüTFEN KARAKTER SEÇİNİZ");
        System.out.println("1 - SAVAŞÇI SAMURAY\t HASAR : 5\t SAĞLIK: 21\t PARA: 15");
        System.out.println("2 - SAVAŞÇI OKÇU\t HASAR : 7\t SAĞLIK: 18 \tPARA: 20");
        System.out.println("3 - SAVAŞÇI ŞOVALYE\t HASAR : 8\t SAĞLIK: 24\tPARA: 5");

            int chaID = scan.nextInt();

            while (chaID < 1 || chaID > 3) {
                System.out.println("lütfen geçerli bir seçim yapınız");
                chaID = scan.nextInt();
            }

            return chaID;
            //try exception atancak
     }
        public int getTotalDamage(){return this.getDamage()+this.getInvetory().getDamage();}

//selectCha da seçilen karakter bilgileri burada karaktere atanıyor. yada hangi karakteri kullanacaksak onun değerlerini işlemek için alıyoruz.
        public void initPlayer (String cName,int dmg, int hlthy, int mny){
            setcName(cName);
            setDamage(dmg);
            setHealthy(hlthy);
            setMoney(mny);
            setrHealty(hlthy);//başlangıç sağlık değeri giriyoruz. ve sabitliyotuz.

        }

        public int getDamage () {
            return damage;
        }

        public void setDamage ( int damage){
            this.damage = damage;
        }

        public int getHealthy () {
            return healthy;
        }

        public void setHealthy ( int healthy){
            this.healthy = healthy;
        }

        public int getMoney () {
            return money;
        }

        public void setMoney ( int money){
            this.money = money;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getcName () {
            return cName;
        }

        public void setcName (String cName){
            this.cName = cName;
        }

        public Inventory getInvetory () {
            return inventory;
        }

        public void setInvetory (Inventory invetory){
            this.inventory = invetory;
        }

        public int getrHealty () {
            return rHealty;
        }

        public void setrHealty ( int rHealty){
            this.rHealty = rHealty;
        }
    }

