package biletrezervasyonapp;

import java.util.Arrays;
import java.util.Scanner;

public class BiletRezervasyonApp {
    /*
 project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

         1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
         2- Kullanıcıdan     mesafe (KM),
         yolcu yaşı ,
         yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         ve koltuk no bilgileri alınır.
         NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
         Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
         Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

         3-Fiyat hesaplama kuralları:
         -Mesafe başına ücret:
         Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
         -Tekli Koltuk ücreti:
         Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
         -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
         sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
         i)-Çift Yön indirimi:
         "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
         ii)-Yaş indirimi:
         Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
         Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.
         */
    public static void main(String[] args) {
        //1- bilet rezervasyonu yapabilmek icin
        Bus bus1=new Bus("34 TECH 34","TECHPRO","2. Peron");
        //3- bilet bilgilerini ve işlemleri yapmasi icin bilet objesine ihtiyacimiz var
        Ticket ticket=new Ticket();
        //7- uygulamayi baslatan bir method
        start(bus1,ticket);
    }

    private static void start(Bus bus1, Ticket ticket) {
        Scanner input=new Scanner(System.in);
        String select;
        do {
            //8- kullanicidan bilgileri alalım
            System.out.println("--Bilet rezervasyon uygulamasina hosgeldiniz--");
            System.out.println("Lutfen gidilicek mesafe bilgisini KM olarak giriniz");
            double distance=input.nextDouble();

            System.out.println("Lutfen yasinizi giriniz");
            int age= input.nextInt();

            System.out.println("Lutfen yolculuk tipini seciniz");
            System.out.println("1. Tek Yön");
            System.out.println("2. Gidiş-Dönüş");
            int type= input.nextInt();

            System.out.println("Lutfen Koltuk No seciniz : ");
            System.out.println("Tekli Koltuk ücreti %20 daha fazladir");
            System.out.println(bus1.seats);
            int seat= input.nextInt();
            //secilen koltuk no listede var mi,rezerve edilmiş mi?
            boolean isReserved=!bus1.seats.contains(seat);//rezerve edilmiş mi?
            if (isReserved){
                System.out.println("Secilen koltuk rezerve edilmiştir");
            }
            //girilen degerler gecerli mi?
            if (age>0&&distance>0&&(type==1||type==2)&&!isReserved){
                //girilen degerli gecerli ise koltugu listeden kaldırmak
                bus1.seats.remove(seat);

                //bilet olusturalım
                ticket.distance=distance;
                ticket.seatNo=seat;
                ticket.typeNo=type;
                ticket.getTotalPrice(age);//price degeri hesaplayıp atama işlemi
                //bileti yazdiralim
                ticket.printTicket(bus1);
            }else {
                System.err.println("Hatalı Veri Girdiniz!!!");
            }
            System.out.println("Yeni islem icin herhangi bir degere,cıkıs icin q'ya basınız");
            select= input.next().toLowerCase();

        }while (!select.equals("q"));
        System.out.println("iyi günler dileriz ve tekrar bekleriz <3");
    }


}
