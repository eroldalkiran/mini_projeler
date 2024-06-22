package loginpageapp;

public class LoginPageApp {

    /*

    Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

    menü: kullanıcıya işlem seçimi için menü gösterilir.//switch+do while

    üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
    email ve şifre birer listede tutulur.
    aynı email kabul edilmez.//unique

    giriş(login): email ve şifre girilir.
    email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
    email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

    email validation: boşluk içermemeli
    : @ içermeli
    : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
    : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

    password validation: boşluk içermemeli
    : en az 6 karakter olmalı
    : en az bir tane küçük harf içermeli
    : en az bir tane büyük harf içermeli
    : en az bir tane rakam içermeli
    : en az bir tane sembol içermeli
    */

    public static void main(String[] args) {

        // tum userlarin ozelliklerini bir class


        start();

    }

    public static void start() {

        UserService userService = new UserService();
        int choice;
        do {
            System.out.println("1. Üye Ol");
            System.out.println("2. Giriş Yap");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapınız: ");
            choice = userService.input.nextInt();
            userService.input.nextLine(); // Yeni satır karakterini temizlemek için

            switch (choice) {
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyiniz.");
            }
        } while (choice != 3);
    }
}
