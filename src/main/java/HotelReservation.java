import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class HotelReservation {
    static int count;
    static ArrayList<Hotel> hotels = new ArrayList<>();
    private static final DateTimeFormatter DATE_RANGE_FORMAT = DateTimeFormatter.ofPattern("ddMMMyyyy");
    static Scanner scanner = new Scanner(System.in);
    private static Hotel lakewood;
    private static Hotel bridgewood;
    private static Hotel ridgewood;

    public static void addHotel() {
        HotelReservation hotelReservation = new HotelReservation();

        HashMap<Customer, Rate> customerTypeRateMap = new HashMap<>();
        customerTypeRateMap.put(Customer.REGULAR, new Rate(110, 90));
        customerTypeRateMap.put(Customer.REWARD, new Rate(80, 80));
        lakewood = new Hotel("Lakewood", 3, customerTypeRateMap);

        customerTypeRateMap = new HashMap<>();
        customerTypeRateMap.put(Customer.REGULAR, new Rate(160, 40));
        customerTypeRateMap.put(Customer.REWARD, new Rate(110, 50));
        bridgewood = new Hotel("Bridgewood", 4, customerTypeRateMap);

        customerTypeRateMap = new HashMap<>();
        customerTypeRateMap.put(Customer.REGULAR, new Rate(220, 150));
        customerTypeRateMap.put(Customer.REWARD, new Rate(100, 40));
        ridgewood = new Hotel("Ridgewood", 5, customerTypeRateMap);
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        System.out.println("Hotels added");
        count++;
    }

    public static void display() {
        for (Hotel data : hotels)
            System.out.println(data);
    }

    public static List<Result> findCheapestHotel(Customer customerType, String initialDateRange, String endDateRange) {
        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

        List<Result> results = hotels.stream()
                .map(hotel -> {
                    Result result = new Result();
                    result.setHotelName(hotel.getName());
                    result.setTotalRate(hotel.getTotalRate(customerType, initialDate, endDate));
                    return result;
                })
                .sorted(Comparator.comparing(Result::getTotalRate))
                .collect(Collectors.toList());

        return results.stream().filter(result -> result.getTotalRate() == results.get(0).getTotalRate())
                .collect(Collectors.toList());
    }

    public static List<Result> findCheapestBestRatedHotel(Customer customerType, String initialDateRange, String endDateRange) {
        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

        List<Result> results = hotels.stream()
                .map(hotel -> {
                    Result result = new Result();
                    result.setHotelName(hotel.getName());
                    result.setTotalRate(hotel.getTotalRate(customerType, initialDate, endDate));
                    result.setRating(hotel.getRating());
                    return result;
                })
                .sorted(Comparator.comparing(Result::getTotalRate).thenComparing(Result::getRating, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return results.stream()
                .filter(result ->
                        result.getTotalRate() == results.get(0).getTotalRate()
                                && result.getRating() == results.get(0).getRating())
                .collect(Collectors.toList());
    }

    public static List<Result> findBestRatedHotel(Customer customerType, String initialDateRange, String endDateRange) {
        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

        List<Result> results = hotels.stream()
                .map(hotel -> {
                    Result result = new Result();
                    result.setHotelName(hotel.getName());
                    result.setTotalRate(hotel.getTotalRate(customerType, initialDate, endDate));
                    result.setRating(hotel.getRating());
                    return result;
                })
                .sorted(Comparator.comparing(Result::getRating, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return results.stream()
                .filter(result -> result.getRating() == results.get(0).getRating())
                .collect(Collectors.toList());
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        boolean flag = true;
        while (true) {
            System.out.println("Select option\n 1. Add hotel\n 2. Display\n 3. Cheapest rate \n " +
                    "4. Cheapest rated hotel\n 5. Best rated hotel\n 6. Reward Customer\n 7. Cheapest rated hotel for reward customer\n" +
                    "8. Exit\n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                case 6:
                    addHotel();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println(findCheapestHotel(Customer.REGULAR, "10Sep2020", "11Sep2020"));
                    break;
                case 4:
                    System.out.println(findCheapestBestRatedHotel(Customer.REGULAR, "10Sep2020", "11Sep2020"));
                    break;
                case 5:
                    System.out.println(findBestRatedHotel(Customer.REGULAR, "10Sep2020", "11Sep2020"));
                    break;
                case 7:
                    System.out.println(findCheapestBestRatedHotel(Customer.REWARD, "10Sep2020", "11Sep2020"));
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }


    }
}

