package aracSigotaApp;

import java.util.Scanner;

public class AracSigortaApp {
    /*
        Proje: Araç Sigorta Prim Hesaplama
               Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                            -otobüs: 18-30 koltuk veya 31 ve üstü koltuk

               Tarife dönemi:Aralık 2024,Haziran 2024
                  1.dönem :Haziran 2024               2.dönem:Aralık 2024
                  otomobil: 2000                       otomobil: 2500
                  kamyon:   3000                       kamyon:   3500
                  otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
                  motosiklet: 1500                     motosiklet: 1750

                1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.//while-switch
                2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
                3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
                4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
                5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
         */

    public static void main(String[] args) {
        //Uygulamanin baslamasi icin bir method olusturalim
        start();
    }

    public static  void start() {
        //Kullanicidan bilgi alma
        Scanner input = new Scanner(System.in);
        boolean isAgain;
        //3. tekrar tekrar menu gosterilsin

        do{
            System.out.println("--Zorunlu Arac sigorta primi hesaplama---");
            System.out.println("Tarife donemi seciniz ; ");
            System.out.println("1. Haziran 2024 ");
            System.out.println("2. Aralik 2024 ");
            int donem= input.nextInt();

//            int donem ;
//            if (input.hasNextInt()) {//integer deger mi girildi diye kontrol eder
//                donem = input.nextInt();//dogru deger girildiyse atama yapiyor
//            }else{
//                input.nextLine();
//            }
            String donemBilgisi = donem==1?"Haziran 2024":"Aralik 2024";
            //tarife donem bilgisi dogru girilirse isleme devam eden
            // yanlis girilirse basa donduren bir yapi olusturun
            if (donem==1||donem==2){
                //4.Arac objesine ihtiyac var
               Arac arac = new Arac();
                System.out.println("Arac tipini seciniz : ");
                System.out.println("otomobil, kamyon, otobus,motorsiklet");
                arac.type= input.next().toLowerCase();
                arac.primHesaplama(donem);

                //prim==0 ise hatali giriis yapilmistir yeni islem yapsin
                //prim>0 ise hesaplama islemi basarili bir sekilde tamamlanmistir

                if (arac.prim>0){
                    System.out.println("----------------------------");
                    System.out.println("Arac Tipi : "+arac.type);
                    System.out.println("Tarife donemi : "+donemBilgisi);
                    System.out.println("Aracinizin ilgili donem sigorta primi : "+arac.prim);
                    System.out.println("-----------------------------");
                    System.out.println("Yeni islem icin 1, cikis icin 0'i seciniz");
                    int select= input.nextInt();
                    isAgain=select==1?true:false;
                }else {
                    System.out.println("Hesaplama islemi basarisiz, tekrar deneyiniz");
                    System.out.println("Yeni islem icin 1, cikis icin 0'i seciniz");
                    int select= input.nextInt();
                    isAgain=select==1?true:false;
                }

            }else {
                System.out.println("Hatali giriş!!!");
                isAgain=true;
            }




        }while(isAgain);
    }


}
