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
public class ParkedCar {
    
    private String make;
    private String model;
    private String color;
    private String licenceNumber;
    private double minutesParked;
    
    ParkedCar(String make, String model, String licenceNumber, double minutes)
    {
        this.make = make;
        this.model = model;
        this.licenceNumber = licenceNumber;
        this.minutesParked = minutes;
    }
    ParkedCar(String make, String model, String color, String licenceNumber, double minutes)
    {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenceNumber = licenceNumber;
        this.minutesParked = minutes;
    }
    
    public String getMake() // gets the make of the car
    {return make;}
    public String getModel()// gets the model of the car
    {return model;}
    public String getColor()// gets the color of the car
    {return color;}
    public String getLicence()//gets the licence plate of the car
    {return licenceNumber;}
    public double getMinutes()//gets the minutes the car has been parked
    {return minutesParked;}
       
    
}
