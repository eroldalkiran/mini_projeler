package biletrezerve;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    public String numberPlate;
    public String marka;
    public String peron;
    public List<Integer> seats = new ArrayList<>();
    public boolean[] seatStatus = new boolean[32];

    public Bus(String numberPlate, String marka, String peron) {
        this.numberPlate = numberPlate;
        this.marka = marka;
        this.peron = peron;
        for (int i = 1; i <= 32; i++) {
            this.seats.add(i);
        }
    }

    public void addTicket(Ticket ticket) {
        if (isValidSeatNumber(ticket.seatNo)) {
            seatStatus[ticket.seatNo - 1] = true;
        } else {
            System.out.println("Hatali koltuk numarasi girdiniz");
        }
    }

    public boolean isValidSeatNumber(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 32;
    }

    public void printSeatStatus() {
        for (int i = 0; i < seatStatus.length; i++) {
            System.out.println((i + 1) + " numarali koltuk : " + (seatStatus[i] ? "dolu" : "bos"));
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                "marka='" + marka + '\'' +
                ", peron='" + peron + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}