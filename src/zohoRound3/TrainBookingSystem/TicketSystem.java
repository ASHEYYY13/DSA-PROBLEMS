package zohoRound3.TrainBookingSystem;

import java.util.*;

public class TicketSystem {
    private final List<String> availableBerths=new ArrayList<>(Arrays.asList("L","U","M"));
    private final Queue<passenger> racQueue=new LinkedList<>();
    private final Queue<passenger> waitingList=new LinkedList<>();
    private final List<passenger> confirmedPassenger=new ArrayList<>();
    private int ticketCounter=1;

    public void bookTicket(String name,int age,String gender,String berthPreference){
        String  ticketId="T" + ticketCounter++;
        passenger pass;
        if(!availableBerths.isEmpty()){
            String allocatedBerth=allocateBerth(age,gender,berthPreference);
            pass=new passenger(name,age,gender,berthPreference,allocatedBerth,ticketId);
            confirmedPassenger.add(pass);
            availableBerths.remove(allocatedBerth);
            System.out.println("Ticket confirmed: "+pass);
        }

        else if(racQueue.size()<1){
            pass=new passenger(name,age,gender,berthPreference,"RAC",ticketId);
            racQueue.add(pass);
            System.out.println("TICKET IN RAC:"+pass);
        }
        else if(waitingList.size()<1){
            pass=new passenger(name,age,gender,berthPreference,"WAITING LIST",ticketId);
            waitingList.add(pass);
            System.out.println("TICKET IN WAITING LIST:"+pass);
        }
        else {
            System.out.println("No Ticket Available");
        }
    }

    private String allocateBerth(int age, String gender, String berthPreference) {
        if(age>60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L")){
            return "L";
        }
        if (availableBerths.contains(berthPreference)){
          return berthPreference;
        }

        return availableBerths.get(0);
    }
    public  void cancelTicket(String ticketId){
        Optional<passenger> passengerOptional=confirmedPassenger.stream().
                filter(p->p.ticketId.equals(ticketId))
                .findFirst();
        if(passengerOptional.isPresent()){
            passenger pass=passengerOptional.get();
            confirmedPassenger.remove(pass);
            availableBerths.add(pass.allocatedBerth);
            if (!racQueue.isEmpty()){
                passenger racPass=racQueue.poll();
                String allocatedBerth=allocateBerth(racPass.age, racPass.gender,racPass.berthPreference);
                racPass.allocatedBerth=allocatedBerth;
                availableBerths.remove(allocatedBerth);
                System.out.println("RAC moved to confirmed:"+racPass);
            }
            if (!racQueue.isEmpty()){
                passenger waitingPassenger=waitingList.poll();
                racQueue.add(waitingPassenger);
                waitingPassenger.allocatedBerth="RAC";
                System.out.println("Waiting  moved to RAC:"+waitingPassenger);
            }
            System.out.println("Ticket cancelled for :"+ticketId);
        }

        else {
            System.out.println("No ticked found with this id:"+ticketId);
        }
    }

    public void printBookedTickets(){
        if(confirmedPassenger.isEmpty()){
            System.out.println("No confirmed Tickets");
        }
      else {
            System.out.println("Confirmed Tickets");
            for (passenger pass:confirmedPassenger){
                System.out.println(pass);
            }
        }
    }

    public void printAvailableTickets(){
        System.out.println("Available Berths:"+availableBerths.size());
        System.out.println("Available RAC tickets:"+(1-racQueue.size()));
        System.out.println("Available waiting tickets:"+(1-waitingList.size()));
    }


    public void viewRacTickets(){
        if(confirmedPassenger.isEmpty()){
            System.out.println("NO RAC Tickets");
        }
        else {
            System.out.println("RAC Tickets");
            for (passenger pass:racQueue){
                System.out.println(pass);
            }
        }
    }


    public void viewWaitingListTickets(){
        if(confirmedPassenger.isEmpty()){
            System.out.println("NO WaitingList Tickets");
        }
        else {
            System.out.println("Waiting List Tickets");
            for (passenger pass:waitingList){
                System.out.println(pass);
            }
        }
    }
}
