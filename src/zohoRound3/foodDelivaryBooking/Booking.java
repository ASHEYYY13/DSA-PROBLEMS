package zohoRound3.foodDelivaryBooking;

public class Booking {

    String executive;
    char restaurant;
    char destinationPoint;
    int orders;
    int pickUpTime;
    int deliveryTime;
    int deliveryCharge;

    public Booking(String executive, char restaurant, char destinationPoint, int orders, int pickUpTime, int deliveryTime, int deliveryCharge) {
        this.executive = executive;
        this.restaurant = restaurant;
        this.destinationPoint = destinationPoint;
        this.orders = orders;
        this.pickUpTime = pickUpTime;
        this.deliveryTime = deliveryTime;
        this.deliveryCharge = deliveryCharge;
    }
}
