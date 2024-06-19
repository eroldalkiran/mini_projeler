package biletrezerve;

import java.util.Scanner;

public class BiletRezervasyonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bus bus = new Bus("34 TECH 34", "TECHPRO", "2.PERON");
        boolean isAgain = false;

        do {
            System.out.println("**********Otobus bileti alma**********");
            System.out.print("Lutfen mesafeyi Km olarak giriniz: ");
            double distance = scanner.nextDouble();
            System.out.print("Lutfen yolculuk tipini seciniz:\n1. Tek yon\n2. Cift yon\nSeciminiz: ");
            int typeNo = scanner.nextInt();
            System.out.print("Lutfen yasinizi giriniz: ");
            int age = scanner.nextInt();
            System.out.print("Lutfen koltuk noyu giriniz (1 - 32):\nBos koltuklari asagidaki tabloda gorebilirsiniz:\n");
            bus.printSeatStatus();
            int seatNo = scanner.nextInt();

            if (!isValidInput(distance, typeNo, age, seatNo) || bus.seatStatus[seatNo - 1]) {
                System.out.println("Hatali veri girdiniz veya koltuk dolu. Lutfen tekrar deneyin.");
                continue;
            }

            scanner.nextLine();
            System.out.print("Lutfen adinizi giriniz: ");
            String firstName = scanner.nextLine();
            System.out.print("Lutfen soyadinizi giriniz: ");
            String lastName = scanner.nextLine();

            Ticket ticket = new Ticket(distance, typeNo, seatNo, firstName, lastName);
            ticket.getTotalPrice(age,distance,seatNo);
            bus.addTicket(ticket);

            System.out.println("Bilet basariyla olusturuldu:");
            System.out.println(bus);
            System.out.println(ticket);

            System.out.print("Yeni islem icin 1, cikis icin 0'i seciniz: ");
            isAgain = scanner.nextInt() == 1;

        } while (isAgain);

        scanner.close();
    }

    private static boolean isValidInput(double distance, int typeNo, int age, int seatNo) {
        return distance > 0 && (typeNo == 1 || typeNo == 2) && age > 0 && seatNo >= 1 && seatNo <= 32;
    }
}
