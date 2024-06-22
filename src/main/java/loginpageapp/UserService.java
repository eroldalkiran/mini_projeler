package loginpageapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    Scanner input = new Scanner(System.in);
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();

    public void register() {
        System.out.println("Lutfen ad soyad giriniz");
        String name = input.nextLine();

        String email;
        boolean isValid;
        do {
            System.out.println("Lutfen email adresinizi giriniz");
            email = input.nextLine();
            isValid = validateEmail(email);

            if (emails.contains(email)){
                System.out.println("Bu mail zaten kayitli lutfen baska bir email adresi giriniz" );
                isValid = false;
            }
        } while (!isValid);


        String password;
        boolean pswIsValid;
        do {
            System.out.println("Lutfenn sifrenizi giriiniz");
            password =input.nextLine();
            pswIsValid=validatePsw(password);
            if (!pswIsValid){
                System.out.println("Lutfen kriterlere uygun bir sifre giriniz");
            }

        }while(!pswIsValid);

        User user =new User(password,name,email);
        emails.add(user.getEmail());
        passwords.add(user.getPassword());
        System.out.println("Tebrikler, kayıt işlemi başarıyla gerceklesti");
        System.out.println("Email ve sifreniz ile sisteme giris yapabilirsiniz");

    }

    public void login(){

        boolean isValidLogin;
        do {

            System.out.println("Lutfen sistemde kayitli olan email adresinizi giriniz");
            String email = input.nextLine();

            System.out.println("lutfen sifrenizi giriniz");
            String password = input.nextLine();

            isValidLogin = validateLogin(email,password);

        }while(!isValidLogin);


    }


    private boolean validatePsw(String psw) {
    // password validation: boşluk içermemeli
        //    : en az 6 karakter olmalı
        //    : en az bir tane küçük harf içermeli
        //    : en az bir tane büyük harf içermeli
        //    : en az bir tane rakam içermeli
        //    : en az bir tane sembol içermeli

        boolean isValid;

        boolean lengthCheck = psw.length()>=6;
        boolean lowerCharCheck = psw.replaceAll("[^a-z]","").length()>=1;
        boolean upperCharCheck =psw.replaceAll("[^A-Z]","").length()>=1;
        boolean digitCheck = psw.replaceAll("[^0-9]","").length()>=1;
        boolean symbolCheck = psw.replaceAll("[^\\p{Punct}]","").length()>=1;

        if (!lengthCheck){
            System.out.println("en az 6 karakter olmalı");
            isValid =false;
        }
        if (!lowerCharCheck){
            System.out.println("en az bir tane küçük harf içermeli");
            isValid =false;
        }
        if (!upperCharCheck){
            System.out.println("en az bir tane büyük harf içermeli");
            isValid =false;
        }
        if (!digitCheck){
            System.out.println("en az bir tane büyük harf içermeli");
            isValid =false;
        }
        if (!symbolCheck){
            System.out.println("en az bir tane büyük harf içermeli");
            isValid =false;
        }
        isValid=lengthCheck&&lowerCharCheck&&upperCharCheck&&digitCheck&&symbolCheck;
        if (!isValid) {
            System.out.println("Gecersiz email, tekrar deneyiniz");

        }
       return isValid;
    }

    private boolean validateEmail(String email) {

        // : @ içermeli
        //    : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
        //    : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

        boolean isValid;

        boolean space = email.contains(" ");
        boolean containsAt = email.contains("@");
        if (space) {
            System.out.println("Email bosluk karekteri icermez");
            isValid = false;
        } else if (!containsAt) {
            System.out.println("Email @ sembolunu icermelidir");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];
            int notValidCharLength = firstPart.replaceAll("[a-zA-Z0-9-._]", "").length();
            boolean checkFirst = notValidCharLength == 0;
            boolean checkSecond = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");
            if (!checkFirst) {
                System.out.println("Email harf, rakam ve -._ karekterleri disinda bir yada birden fazla karekter icermemeli");
            } else if (!checkSecond) {
                System.out.println("Email gmail.com, hotmail.com veya yahoo.com ile bitmalidir");
            }
            isValid = checkFirst && checkSecond;
            if (!isValid) {
                System.out.println("Gecersiz email, tekrar deneyiniz");

            }



        }
        return isValid;

    }


    private boolean validateLogin(String email, String password){

          boolean isvalid;

        if (!emails.contains(email)) {
            System.out.println("Yanlis veya kayitli olmayan bir email girdiniz");
        }
        if (!(passwords.get(emails.indexOf(email)).equals(password))) {
            System.out.println("Yanlis bir sifre girdiniz");
        }

        isvalid=emails.contains(email)&&(passwords.get(emails.indexOf(email)).equals(password));

        System.out.println("Sisteme giris yaptiniz");
        return isvalid;
    }


}