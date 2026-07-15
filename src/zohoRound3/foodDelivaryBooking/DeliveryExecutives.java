package zohoRound3.foodDelivaryBooking;

public class DeliveryExecutives {
   private int earning=0;
   private int totalEarnings=0;
   private int allowance=0;
   private int noOfTrips=0;
   private char restaurantLocation='S';
   private char deliveryLocation='$';
   private int pickupTime=0;
   private int relaxationTime=0;



    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getRelaxationTime() {
        return relaxationTime;
    }

    public void setRelaxationTime(int relaxationTime) {
        this.relaxationTime = relaxationTime;
    }

   public  void addToEarning(int fare){
        this.earning+=fare;
   }

    public int getEarning() {
        return earning;
    }

    public int getNoOfTrips() {
        return noOfTrips;
    }

    public void addNoTrips(){
        this.noOfTrips+=1;
    }

    int getAllowance(){
        allowance=10*noOfTrips;
        return allowance;
    }

    int getTotalEarnings(){
        totalEarnings=allowance+earning;
        return totalEarnings;
    }



    void setRestaurantAndDeliveryLocation(char restaurantLocation,char deliveryLocation){
        this.restaurantLocation=restaurantLocation;
        this.deliveryLocation=deliveryLocation;
    }


    public char getRestaurantLocation() {
        return restaurantLocation;
    }

    public char getDeliveryLocation() {
        return deliveryLocation;
    }
}
