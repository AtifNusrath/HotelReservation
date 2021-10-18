public class Result {

    private String hotelName;
    private int totalRate;
    private int rating;

    @Override
    public String toString() {
        return "Result{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", totalRate=" + totalRate +
                '}';
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(int totalRate) {
        this.totalRate = totalRate;
    }

}
