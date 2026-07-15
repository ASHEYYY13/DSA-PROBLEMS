package zohoRound3.TaxiBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaxiBookingSystem {
    static List<Taxi> taxis=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);
    static int customerCount=1;

    public static void main(String[] args) {
        System.out.println("Enter the Number of Taxis:");
        int numTaxis=scanner.nextInt();

        initialize(numTaxis);

        while (true){
            System.out.println("\n 1.Book Taxi\n 2.Display Taxi Details\n 3.Exit");
            System.out.println("Enter Your choice");
            int choice=scanner.nextInt();

            switch (choice){
                case 1:
                BookTaxi();
                break;

                case 2:
                    DisplayTaxiDetails();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Test case Bitch open your Eyes");
            }
        }
    }

    private static void DisplayTaxiDetails() {
    for (Taxi taxi:taxis){
        System.out.println("Taxi-"+ taxi.id + " Total Earnings=" +taxi.totalEarnings);
        for (Booking booking:taxi.bookings){
            System.out.println("BookingId="+booking.BookingId);
            System.out.println("customerId="+booking.customerId);
            System.out.println("pickupPoint="+booking.from);
            System.out.println("dropPoint="+booking.to);
            System.out.println("pickupTime="+booking.pickupTime);
            System.out.println("dropTime="+booking.dropTime);
            System.out.println("Amount="+booking.amount);
        }
    }
    }

    private static void BookTaxi() {
        int customerId=customerCount++;
        System.out.println("Enter the your pickupPoint (A-F)");
        char pickupPoint=scanner.next().toUpperCase().charAt(0);
        System.out.println("Enter the your dropPoint (A-F)");
        char dropPoint=scanner.next().toUpperCase().charAt(0);
        System.out.println("Enter the your pickupTime (In hours)");
        int pickupTime=scanner.nextInt();

        Taxi selectedTaxi=null;
        int minimumDistance=Integer.MAX_VALUE;

        for(Taxi taxi:taxis){
            if(taxi.isAvailable(pickupTime)){
                int distance= Math.abs(taxi.currentPoint-pickupPoint);

                if(distance<minimumDistance || (distance==minimumDistance && taxi.totalEarnings<selectedTaxi.totalEarnings)){
                    selectedTaxi=taxi;
                    minimumDistance=distance;
                }
            }
        }
        if (selectedTaxi==null){
            System.out.println("No  Taxis Available");
            return;
        }

        int dropTime=pickupTime+Math.abs(dropPoint-pickupPoint);
        int amount=selectedTaxi.calculateEarning(pickupPoint,dropPoint);
        int bookingId=selectedTaxi.bookings.size()+1;

        Booking booking=new Booking(customerId,bookingId,dropTime,pickupTime,pickupPoint,amount,dropPoint);
        selectedTaxi.addBooking(booking);
        System.out.println("Taxi: "+ selectedTaxi.id+ " is allocated");
    }

    private static void initialize(int numTaxis) {
        for (int i = 1; i <=numTaxis ; i++) {
            taxis.add(new Taxi(i));
        }
    }
}
