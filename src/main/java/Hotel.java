import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

public class Hotel {
    int rate;
    String name;
    private int rating;
    private int totalRate;
    private int weekendRate;
    private int weekdayRate;

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalRate(LocalDate initialDate, LocalDate endDate) {
        return Stream.iterate(initialDate, date -> date.plusDays(1))
                .limit(endDate.getDayOfMonth() - initialDate.getDayOfMonth() + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                        return getWeekendRate();
                    }
                    return getWeekdayRate();
                })
                .reduce((total, next) -> total).get();
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
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
                ", weekendRate=" + weekendRate +
                ", weekdayRate=" + weekdayRate +
                '}';
    }
}
