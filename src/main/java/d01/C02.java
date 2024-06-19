package d01;

public class C02 {
    public static void main(String[] args) {
  /*
    Tam ad için dilbilgisi kurallarını kontrol etmek için kod yazın
         a) Kodunuz "ali Can", "Ali can", "ali can" için "Baş harflerde hata" yazdırmalıdır
         b) Kodunuz aşağıdaki gibi tek kelimeler için "Adı veya soyadı cevapsız" yazdırmalıdır
         "Ali" veya "Can" veya "ali"
         c) Kodunuz "ALI CAN" gibi tüm formatlar için "Format hatası" yazdırmalıdır
         d) Kodunuz bir veya daha fazla boşluk için "Ad girilmedi" yazdırmalıdır
         " " veya " " gibi karakterler
         e) Kodunuz, adda farklı bir karakter varsa "Geçersiz Ad" yazdırmalıdır
         harflerden ve boşluktan.
         Not: Kısaltmada 1'den fazla hata varsa, ilgili tüm hata mesajları aşağıdaki gibi olmalıdır
         yazdırılır. Örneğin; "ali3" için kodunuz "Baş harflerde hata", "İlk isim
         veya soyadı eksik" ve "Geçersiz Ad"


   */

        String fullName = " ali3";
        String baslangicIlkAd= fullName.substring(0,1);

//        String baslangicSoyad = fullName.split(" ")[1].substring(0,1);

        int spaceIndex = fullName.trim().indexOf(" ");
        String baslangicSoyad = fullName.substring(spaceIndex+1,spaceIndex+2);


        if(spaceIndex==-1){
            System.out.println("ilk isim ve son isimarasinda bosluk yoktur");
        }
        if(!(baslangicIlkAd.charAt(0)>='A'&&baslangicIlkAd.charAt(0)<='Z')||
                !(baslangicSoyad.charAt(0)>='A'&&baslangicSoyad.charAt(0)<='Z') ){
            System.out.println("Baslangic hatasi");
        }

        if(fullName.equals(fullName.toUpperCase())){
            System.out.println("Format hatasi");
        }

        if(fullName.length()>fullName.trim().length()){
            System.out.println("Ad girilmedi");
        }

        if(fullName.trim().replaceAll("\\s","").replaceAll("[a-zA-Z]","").length()>0){
            System.out.println("Geçersiz Ad");
        }








    }
}
