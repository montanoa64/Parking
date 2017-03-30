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
public class PoliceOfficer {
    
    String name;
    int badge;
    
    PoliceOfficer(String name, int badge)
    {
        this.name = name;
        this.badge = badge;
    }
    public String getName()//returns name of officer
    {return name;}
    
    public int getBadge()//returns badge of office
    {return badge;}
    
    public ParkingTicket patroll(ParkedCar car, ParkingMeter meter, PoliceOfficer cop)
    {
      
        if(car.getMinutes() > meter.getTime())//checks if car has been parked longer than minutes purchased
        {
            ParkingTicket ticket = new ParkingTicket(car,cop,meter);//creates new parkingticker object with the info
            return ticket;//returns the parkingticket object
        }
        return null;//returns null if the car has NOT been parked longer than minutes purchased
    }
    
}
