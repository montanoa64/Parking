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
public class ParkingTicket {
    
    private ParkedCar car;
    private final double base;
    private final double rate;
    private double fine =0;
    private double minutes;
    private PoliceOfficer police;
    private ParkingMeter meter;
    
    ParkingTicket()
    {   this.rate = 10;
        this.base = 25;
    }
    ParkingTicket(ParkedCar car, PoliceOfficer police, ParkingMeter meter)
    {
        this.rate = 10;
        this.base = 25;
        this.car = new ParkedCar(car.getMake(),car.getModel(),car.getColor(),car.getLicence(),car.getMinutes());
        this.police = new PoliceOfficer(police.getName(), police.getBadge());
        this.meter = new ParkingMeter(meter.getTime());
        
    }
    ParkingTicket(ParkedCar car, ParkingMeter meter)
    {
        this.rate = 10;
        this.base = 25;
        this.car = new ParkedCar(car.getMake(),car.getModel(),car.getColor(),car.getLicence(),car.getMinutes());
        this.meter = new ParkingMeter(meter.getTime());
        
    }
    
    public void report()// the ticket report the officer makes if car is illegally parked
    {
        System.out.println("Make: "+ car.getMake());
        System.out.println("Model : "+ car.getModel());
        //System.out.println("Color : "+ car.getColor());
        System.out.println("Licence Number : "+ car.getLicence());
        System.out.println("Police Name : "+ police.getName());
        System.out.println("Police Badge : "+ police.getBadge());
        System.out.printf("fine: $%.2f", fine);
        System.out.print("\n\n");
    }
    public void setFine()//sets the fine of the car
    {
        if(fine == 0)
        {
        minutes = car.getMinutes() - meter.getTime();//get the difference between minutes purchased and minutes parked
        if(minutes < 60)//if the car has been illegaly parked for less than an hour
        {
            fine += (minutes/60) * base;
        }
        else//the car has been parked illegaly for an hour or more
        {
            fine += base + ((minutes-60)/60) *rate;
        }
        }
        
        
    }
    
    
    public double getFine()//returns the fine
    {return fine;}
}

