package zohoRound3.TrainBookingSystem;

public class passenger {


     String name;
     int age;
     String gender;
     String berthPreference;
     String allocatedBerth;
     String ticketId;

    public passenger(String name, int age, String gender, String berthPreference, String allocatedBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allocatedBerth = allocatedBerth;
        this.ticketId = ticketId;
    }

//
//    @Override
//    public String toString() {
//        return "passenger{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", gender='" + gender + '\'' +
//                ", berthPreference='" + berthPreference + '\'' +
//                ", allocatedBerth='" + allocatedBerth + '\'' +
//                ", ticketId='" + ticketId + '\'' +
//                '}';
//    }
}
