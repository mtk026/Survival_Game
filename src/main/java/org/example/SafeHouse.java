package org.example;

public class SafeHouse extends NormalLocation {
    SafeHouse(Player player) {
        //işlem yapılabilmesi için mutklaka bir oyuncu karakteri belirlenmiş ve gelmiş olmalı
        super(player, "SafeHouse");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getrHealty());//otomatik olarak oyuncununn sağlık değerini en yüksek seviyeye getiriyoruz.

        System.out.println("Sayın    "+player.getcName()+"  "+player.getName()+"   GÜVENLİ EVİ ŞİFACISI SİZİ İYİLEŞTİRDİ");
        return true;
    }
}
