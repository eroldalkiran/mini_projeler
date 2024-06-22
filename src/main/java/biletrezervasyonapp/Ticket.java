package biletrezervasyonapp;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    //4-fiyat bilgisi,mesefa(km),yolculuk tipi,koltuk no

    public double price;
    public double distance;
    public int typeNo;
    public int seatNo;

    //5-bilet fiyatini hesaplama
    //3-Fiyat hesaplama kuralları:
    //        -Mesafe başına ücret:
    //Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
    //    -Tekli Koltuk ücreti:
    //Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
    //        -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
    //sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
    //i)-Çift Yön indirimi:
    //        "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
    //ii)-Yaş indirimi:
    //Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
    //Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.
    public void getTotalPrice(int age){
        double total=0;//biz toplam tutar uzerinden degisikler yapıcaz ve en son olan degeri price'a aticaz
        switch (this.typeNo){//tercihen cunku ilerleyen kısımda bir daha if kullanicam ve nested if yerine switch if kullanmak daha mantıklı
            case 1://tek yon
                if (seatNo%3==0){
                    total=distance*1.2;
                }else {
                    total=distance*1;
                }
                System.out.println("Toplam tutar : "+total);
                break;
            case 2://gidis donus
                total=seatNo%3==0? distance*2.4 : distance*2;
                System.out.println("Toplam tutar : "+total);
                //cift yon indirimi
                total=total*0.8;//80
                System.out.println("Cift yon indirimli tutar : "+total);
                break;
        }//son tutardan yas indirimi
        if (age<12){
            total=total/2;
            System.out.println("12 yas alti indirimli total tutar : "+total);
        }else if (age>65){
            total=total*0.7;
            System.out.println("65 yas ustu indirimli total tutar : "+total);
        }
        this.price=total;
    }

    //6- bileti yazdiralim
    public void printTicket(Bus otobus){
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("  hh:mm a\ndd.MM.yyyy");
        System.out.println("****************************************");
        System.out.println("--Bilet Detayi--");
        System.out.println("Otobüs Plakasi : "+otobus.numberPlate);
        System.out.println("Otobüs Firmasi : "+otobus.marka);
        System.out.println("Hangi Peron    : "+otobus.peron);
        System.out.println("Mesafe         : "+this.distance);
        System.out.println("Yolculuk tipi  : "+(this.typeNo==1?"Tek Yön":"Gidiş-Dönüş"));
        System.out.println("Koltuk No      : "+this.seatNo);
        System.out.println("Toplam Tutar   : "+this.price);
        System.out.println("Keyifli yolculuklar dileriz.................");
        System.out.println(dtf.format(dateTime));
        System.out.println("****************************************");

    }


}
