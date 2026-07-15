package zohoRound3.foodDelivaryBooking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        DeliveryManagement deliveryManagement=new DeliveryManagement(2);


        while (true){
            System.out.println("\nChoose from the following options : ");
            System.out.println("\n 1. Handle Delivery\n2. Print Delivery Details\n3. Print Executive Details\n 4.Exit");
            System.out.println("Enter your choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                 deliveryManagement.foodDelivery();
                  break;

                case 2:
                deliveryManagement.printExecutivesStatus();
                    break;

                case 3:

                  break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
