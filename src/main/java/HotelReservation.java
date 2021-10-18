import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class HotelReservation {

    static int count;
    static ArrayList<Hotel> hotels = new ArrayList<>();
    private static final DateTimeFormatter DATE_RANGE_FORMAT = DateTimeFormatter.ofPattern("ddMMMyyyy");


    static Scanner scanner = new Scanner(System.in);

    public static void addHotel() {
        Hotel hotel = new Hotel();
        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.next());
        System.out.println("Enter hotel weekday rate: ");
        hotel.setWeekdayRate(scanner.nextInt());
        System.out.println("Enter hotel weekend rate: ");
        hotel.setWeekendRate(scanner.nextInt());
        System.out.println("Enter hotel rating: ");
        hotel.setRating(scanner.nextInt());
        hotels.add(hotel);
        System.out.println("Hotel Added");
        count++;
    }

    public static void display() {
        for (Hotel data : hotels)
            System.out.println(data);
    }

    public static List<Result> findCheapestHotel(String initialDateRange, String endDateRange) {
        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

        List<Result> results = hotels.stream()
                .map(hotel -> {
                    Result result = new Result();
                    result.setHotelName(hotel.getName());
                    result.setTotalRate(hotel.getTotalRate(initialDate, endDate));
                    return result;
                })
                .sorted(Comparator.comparing(Result::getTotalRate))
                .collect(Collectors.toList());

        return results.stream().filter(result -> result.getTotalRate() == results.get(0).getTotalRate())
                .collect(Collectors.toList());
    }

    public static List<Result> findCheapestBestRatedHotel(String initialDateRange, String endDateRange) {
        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

        List<Result> results = hotels.stream()
                .map(hotel -> {
                    Result result = new Result();
                    result.setHotelName(hotel.getName());
                    result.setTotalRate(hotel.getTotalRate(initialDate, endDate));
                    result.setRating(hotel.getRating());
                    return result;
                })
                .sorted(Comparator.comparing(Result::getTotalRate).thenComparing(Result::getRating,
                        Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return results.stream()
                .filter(result ->
                        result.getTotalRate() == results.get(0).getTotalRate()
                                && result.getRating() == results.get(0).getRating())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        boolean flag = true;
        while (true) {
            System.out.println("Select option\n 1. Add hotel\n 2. Display\n 3. Cheapest rate \n 4. Cheapest rated hotel\n 5. Exit\n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println(findCheapestHotel("10Sep2020", "11Sep2020"));
                    break;
                case 4:
                    System.out.println(findCheapestBestRatedHotel("10Sep2020", "11Sep2020"));
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }


    }
}

