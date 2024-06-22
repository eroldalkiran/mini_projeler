package biletrezervasyonapp;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    //2-koltuk,plakasi,markasi,peron

    public String numberPlate;//plaka
    public String marka;
    public String peron;
    public List<Integer>seats=new ArrayList<>();//Koltuk No


    public Bus(String numberPlate, String marka, String peron) {
        this.numberPlate = numberPlate;
        this.marka = marka;
        this.peron = peron;
        for (int i = 1; i <33; i++) {//32
            this.seats.add(i);
        }
    }
}
