import java.util.*;

class HotelReservation {

    static int count;
    static ArrayList<Hotel> hotels = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void addHotel() {
        Hotel hotel = new Hotel();
        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.next());
        System.out.println("Enter hotel rate: ");
        hotel.setRating(scanner.nextInt());
        hotels.add(hotel);
        System.out.println("Hotel Added");
        count++;
    }

    public static void display() {
        for (Hotel data : hotels)
            System.out.println(data);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        boolean flag = true;
        while (true) {
            System.out.println("Enter option 1.Add hotel\n 2. Display \n 3.Exit\n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }


    }
}

