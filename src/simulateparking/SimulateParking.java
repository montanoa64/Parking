/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulateparking;

/**
 *
 * @author montanoa64
 */
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
class TicketComparator implements Comparator//abstract class to sort the array of tickets
{
    @Override
    public int compare(Object t, Object t1)
    {
        ParkingTicket n1 = (ParkingTicket)t;
        ParkingTicket n2 = (ParkingTicket)t1;
        if(n1.getFine()>n2.getFine())
            return 0;
        else
            return -1;
    }


}
public class SimulateParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       ArrayList listCar =  new ArrayList();
       ArrayList listMeter = new ArrayList();
       ArrayList listTicket = new ArrayList();
       PoliceOfficer cop = new PoliceOfficer("Stan Smith",32432);
       Scanner scanner = null;
       int numberOfCars = 0;
       double totalFine = 0;
        
       try//looks for the car.txt file
       {
            scanner = new Scanner(new File ("test/car.txt"));
       }
       catch(FileNotFoundException e)
       {
           System.out.println("could not find file");
       }
       
       while(scanner.hasNext())//scan for the file for the information of the car
       {
           String make = scanner.next();
           String model = scanner.next();
           String licence = scanner.next();
           int min = scanner.nextInt();
           int min2 = scanner.nextInt();
           listCar.add(new ParkedCar(make,model,licence,min));
           listMeter.add(new ParkingMeter(min2));
           
       }
       ArrayList carTicket = new ArrayList();//created a new array to keep all the cars that have a ticket
       for (int counter = 0; counter < listCar.size(); counter++)
       {
           //PoliceOffice object compares if minutes parked are greater than minutes purchased
           listTicket.add(cop.patroll((ParkedCar)listCar.get(counter), (ParkingMeter)listMeter.get(counter), cop));
           ParkingTicket n = (ParkingTicket)listTicket.get(counter);
           if(n != null)//if the car has a parking ticket
           {
               numberOfCars += 1;//increased the number of cars with tickets
               
               
               carTicket.add(n);//add the ticket to the array
               n.setFine();//set the fine
           }
        }  
       Collections.sort(carTicket,new TicketComparator());//sorts the array of tickets according to the fine
       for(int i = 0; i < carTicket.size();i++)
       {
           ParkingTicket n = (ParkingTicket) carTicket.get(i);
           n.report();//prints report
           totalFine += n.getFine();//increased the total fine
       }
       
       System.out.println("Total number of cars with Tickets: "+numberOfCars);
       System.out.printf("Total Fine of the day: $%.2f%n",totalFine);

    }
    
}
