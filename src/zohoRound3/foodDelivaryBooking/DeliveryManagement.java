package zohoRound3.foodDelivaryBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryManagement {
 private   List<DeliveryExecutives> deliveryExecutives;
 private  int noOfDeliveryExecutives;
 private List<Booking> bookings;

    public DeliveryManagement(int numExecutives) {
        deliveryExecutives = new ArrayList<>();
        for (int i = 0; i < numExecutives; i++) {
            deliveryExecutives.add(new DeliveryExecutives());
        }
        bookings = new ArrayList<>();
    }

    public void foodDelivery(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter Restaurant Point: ");
        char restaurant = sc.next().charAt(0);
        System.out.print("Enter Destination Point: ");
        char destination = sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Enter Pickup Time (hh:mm AM/PM): ");
        String time = sc.nextLine();

        int pickUpTime = convertToMinutes(time);
        int minTime = Integer.MAX_VALUE;
        int chosenIndex = -1;

        for (int i = 0; i < deliveryExecutives.size(); i++) {
            int availableTime = deliveryExecutives.get(i).getPickupTime() + deliveryExecutives.get(i).getRelaxationTime();
            if (availableTime <= pickUpTime && availableTime < minTime) {
                minTime = availableTime;
                chosenIndex = i;
            }
        }

        if (chosenIndex == -1) {
            System.out.println("No delivery executive is available at the moment.");
            return;
        }

        DeliveryExecutives chosenExecutive = deliveryExecutives.get(chosenIndex);
        int deliveryCharge = 50;
        int deliveryTime = pickUpTime + 15;
        int relaxation = 10;

        chosenExecutive.setPickupTime(deliveryTime);
        chosenExecutive.setRelaxationTime(relaxation);
        chosenExecutive.addToEarning(deliveryCharge);
        chosenExecutive.addNoTrips();
        chosenExecutive.setRestaurantAndDeliveryLocation(restaurant, destination);

        Booking booking = new Booking("DE" + (chosenIndex + 1), restaurant, destination,
                1, pickUpTime, deliveryTime, deliveryCharge);

        bookings.add(booking);

        System.out.println("\nOrder Assigned Successfully!");
        System.out.println("Executive ID: " + booking.executive);
        System.out.println("Pickup Time: " + convertToHours(booking.pickUpTime));
        System.out.println("Delivery Time: " + convertToHours(booking.deliveryTime));
        System.out.println("Delivery Charge: Rs. " + booking.deliveryCharge);

    }

    private int convertToMinutes(String time) {
        time = time.trim();
        if (time.length() == 7) time = "0" + time;
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        String period = time.substring(6);

        if (period.equalsIgnoreCase("PM") && hour != 12) hour += 12;
        if (period.equalsIgnoreCase("AM") && hour == 12) hour = 0;

        return hour * 60 + minute;
    }

    public String convertToHours(int time) {
        int hour = time / 60;
        int minute = time % 60;
        String period = "AM";

        if (hour >= 12) {
            if (hour > 12) hour -= 12;
            period = "PM";
        }
        if (hour == 0) hour = 12;

        return String.format("%02d:%02d %s", hour, minute, period);
    }

    public void printExecutivesStatus() {
        System.out.println("\nExecutive\tEarnings\tTrips\tAllowance\tTotal");
        for (int i = 0; i < deliveryExecutives.size(); i++) {
            DeliveryExecutives ex = deliveryExecutives.get(i);
            System.out.printf("DE%d\t\tRs.%d\t\t%d\tRs.%d\t\tRs.%d\n",
                    i + 1, ex.getEarning(), ex.getNoOfTrips(),
                    ex.getAllowance(), ex.getTotalEarnings());
        }
    }
}
