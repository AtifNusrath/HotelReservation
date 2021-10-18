import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Hotel {
    private int rating;
    private String name;
    private Map<Customer, Rate> rate;

    public Hotel(String name, int rating, HashMap<Customer, Rate> rate) {
        this.name = name;
        this.rating = rating;
        this.rate = rate;
    }

    public Hotel() {

    }


    public int getTotalRate(Customer customerType, LocalDate initialDate, LocalDate endDate) {
        return Stream.iterate(initialDate, date -> date.plusDays(1))
                .limit(endDate.getDayOfMonth() - initialDate.getDayOfMonth() + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                        return this.rate.get(customerType).getWeekendRate();
                    return this.rate.get(customerType).getWeekdayRate();
                })
                .reduce((total, next) -> total + next).get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Customer, Rate> getRate() {
        return rate;
    }

    public void setRate(HashMap<Customer, Rate> rate) {
        this.rate = rate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
