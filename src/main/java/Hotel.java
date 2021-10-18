import java.time.LocalDate;
import java.time.Period;

public class Hotel {
    int rate;
    String name;
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

        totalRate = rate * 2;
        return totalRate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", weekendRate=" + weekendRate +
                ", weekdayRate=" + weekdayRate +
                '}';
    }
}
