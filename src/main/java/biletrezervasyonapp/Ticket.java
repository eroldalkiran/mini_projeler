package biletrezervasyonapp;

public class Ticket {
    //fiyat bilgisi  mesafe(km) isim soy isim yolculuk tipi koltuk no

    public double price;
    public double distance;
    public int typeNo;
    public int seatNo;
    public String firstName;
    public String lastName;

    public Ticket( double distance, int typeNo, int seatNo, String firstName, String lastName) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //5- bilet fiyati hesaplama
    public void getTotalPrice(int age ,double distance,int seatNo){
        double total =0;
        switch (this.typeNo){
            case 1:

                total = seatNo%3==0 ? distance*1.2 : distance;
                break;
            case 2:

                total = seatNo%3==0 ? distance*2.4 : distance*2;
                break;
            default:
        }


        if (typeNo == 2) { // Gidiş-Dönüş indirimi
            total *= 0.8;
        }

        if (age < 12) { // Yaş indirimi
            total *= 0.5;
        } else if (age > 65) {
            total *= 0.7;
        }

        this.price = total;

    }


    @Override
    public String toString() {
        return "Ticket{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", seatNo=" + seatNo +
                ", typeNo=" + typeNo +
                ", distance=" + distance +
                ", price=" + price +
                '}';
    }
}
