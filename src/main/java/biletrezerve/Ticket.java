package biletrezerve;

public class Ticket {
    public double price;
    public double distance;
    public int typeNo;
    public int seatNo;
    public String firstName;
    public String lastName;

    public Ticket(double distance, int typeNo, int seatNo, String firstName, String lastName) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void getTotalPrice(int age ,double distance,int seatNo){
        double total =0;

        switch (typeNo) {
            case 1: // Tek yön
                total = (seatNo % 3 == 0) ? distance * 1.2 : distance;
                break;
            case 2: // Gidiş-Dönüş
                total = (seatNo % 3 == 0) ? distance * 2.4 : distance * 2;
                total *= 0.8; // Gidiş-Dönüş indirimi
                break;
            default:
                System.out.println("Gecersiz yolculuk tipi");
                return;
        }

        if (age < 12) { // Çocuk indirimi
            total *= 0.5;
        } else if (age > 65) { // Yaşlı indirimi
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
