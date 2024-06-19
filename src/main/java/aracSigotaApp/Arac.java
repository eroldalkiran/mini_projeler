package aracSigotaApp;

import java.util.Scanner;

public class Arac {

    //aracla ilgili variablaler

    public String type;
    public int prim;
    //prim hesaplama

    public void primHesaplama(int donem){
        //tipine gore hesaplama yapacagiz

        switch (this.type){
            case "otomobil":
                this.prim=donem==1?2000:2500;
                break;
            case "kamyon":
                this.prim=donem==1?3000:3500;
                break;
            case "otobus":
                primHesaplamaOtobus(donem);
                break;
            case "motorsiklet":
                this.prim=donem==1?1500:1750;
                break;
            default:
                System.out.println("Hatali giris!!!");
                this.prim=0;
                break;
        }
    }

    public void primHesaplamaOtobus(int donem) {
        Scanner input = new Scanner(System.in);
        System.out.println("Otobus tipini seciniz : ");
        System.out.println("1. 18-30 arasi koltuk sayisi");
        System.out.println("1. 31 veya ustu");
        int otobusTipi=input.nextInt();
        switch (otobusTipi){
            case 1:
                this.prim=donem==1?4000:4500;
                break;
            case 2:
                this.prim= donem==1? 5000:5500;
                break;
            default:
                System.out.println("Hatali giris");
                this.prim =0;
                break;
        }
    }
}
