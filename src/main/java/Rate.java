public class Rate {
    private int weekendRate;
    private int weekdayRate;

    public Rate(int weekendRate, int weekdayRate) {
        this.weekendRate = weekendRate;
        this.weekdayRate = weekdayRate;
    }

    public Rate() {

    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }
}
