package zohoRound3.TaxiBookingSystem;

public class Booking {
    int customerId;
    int BookingId;
    int pickupTime;
    int dropTime;
    int amount;
    char from;
    char to;

    public Booking(int customerId, int bookingId, int dropTime, int pickupTime, char from, int amount, char to) {
        this.customerId = customerId;
        BookingId = bookingId;
        this.dropTime = dropTime;
        this.pickupTime = pickupTime;
        this.from = from;
        this.amount = amount;
        this.to = to;
    }
}
