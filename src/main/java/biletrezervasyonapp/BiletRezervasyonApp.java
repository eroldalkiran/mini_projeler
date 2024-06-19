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

        Scanner scanner = new Scanner(System.in);
        //bilet rezervazyonu yapabilmek icin
        Bus bus = new Bus("34 TECH 34","TECHPRO","2.PERON");


        //3-bilet bilgilerini ve islemlerini yapmasi icin bilet objesi

         boolean isAgain = false;

        do {
            System.out.println("**********Otobus bileti alma**********");
            System.out.println("lutfen mesafeyi Km olarak giriniz giriniz");
            double distance = scanner.nextDouble();
            System.out.println("Lutfen yolculuk tipini seciniz :\n 1. Tek yon \n 2. Cift yon");
            int typeNo = scanner.nextInt();

            System.out.println("Lutfen yasinizi giriniz : ");
            int age = scanner.nextInt();

            System.out.println("Lutfen koltuk no yu giriniz (1 - 32) " +"\n bos koltuklari asagidaki tabloda gorebilirsiniz : " );
            bus.printSeatStatus();
            int seatNo = scanner.nextInt();

             if (distance<0){
                 System.out.println("Hatali mesafe girisi yaptiniz lutfen tekrar deneyin");
                 continue;
             }
             if(typeNo<1||typeNo>2){
                 System.out.println("Hatali seyahat tipi sectiniz lutfen tekrar deneyin");
                 continue;
             }
             if (seatNo<1||seatNo>32){
                 System.out.println("Hatali koltuk numarasi girdiniz lutfen tekrar deneyin");
                 continue;
             }
             if(age<0){
                 System.out.println("Hatali yas girisi yaptiniz");

                 continue;
             }
             if(bus.seatStatus[seatNo-1]){
                 System.out.println("Seçtiğiniz koltuk dolu. Lütfen başka bir koltuk numarası seçin.");
                 continue;
             }

            scanner.nextLine();
            System.out.println("lutfen adinizi giriniz : ");
            String firstName = scanner.nextLine();

            System.out.println("Lutfen Soyadinizi giriniz");
            String lastName = scanner.nextLine();

            Ticket ticket = new Ticket(distance,typeNo,seatNo,firstName,lastName);

            if(typeNo==2){
                System.out.println("Bilet basariyla oluturulmustur");
                bus.addTicket(ticket,age);
                System.out.println(bus);
                System.out.println("Gidis donus bileti aldiginiz icin %20 indirim uygulanmistir");
                System.out.println(ticket);
            } else if (age<12) {
                System.out.println("Bilet basariyla oluturulmustur");
                bus.addTicket(ticket,age);
                System.out.println(bus);
                System.out.println("12 yasindan kucuklere %50 indirim uygulanmistir ");
                System.out.println(ticket);
            } else if (age>65) {
                System.out.println("Bilet basariyla oluturulmustur");
                bus.addTicket(ticket,age);
                System.out.println(bus);
                System.out.println("65 yasindak buyuklere %30 indirim uygulanmaktadir");
                System.out.println(ticket);
            }else{
                System.out.println("Bilet basariyla oluturulmustur");
                bus.addTicket(ticket,age);
                System.out.println(bus);
                System.out.println(ticket);
            }
            System.out.println("Yeni islem icin 1, cikis icin 0'i seciniz");
            int select= scanner.nextInt();
            isAgain=select==1?true:false;

        }while(isAgain);


    }
}
