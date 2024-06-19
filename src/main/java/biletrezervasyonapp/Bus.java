package biletrezervasyonapp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    //koltuk plaka marka peron

    public String numberPlate;
    public String marka;
    public String peron;
    public List<Integer> seats= new ArrayList<>();
    public boolean[] seatStatus= new boolean[32];

    public Bus(String numberPlate, String marka, String peron) {
        this.numberPlate = numberPlate;
        this.marka = marka;
        this.peron = peron;
        for (int i = 1; i <33 ; i++) {
            this.seats.add(i);
        }
    }

    public void addTicket(Ticket ticket,int age){
        if(isValidSeatNumber(ticket.seatNo)){
            ticket.getTotalPrice(age,ticket.distance,ticket.seatNo);
            seatStatus[ticket.seatNo-1]=true;
        }else{
            System.out.println("Hatali koltuk numarasi girdiniz");
        }
    }
    public boolean isValidSeatNumber(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 32;
    }




    public void printSeatStatus(){
        for (int i = 0; i < seatStatus.length; i++) {
            System.out.println((i+1) +" numarali koltuk : "+(seatStatus[i] == true ? "dolu" :"bos"));
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
