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
public class ParkingMeter {
    
    private double timePurchased;
    
    ParkingMeter(double timePurchased)
    {
        this.timePurchased = timePurchased;
    }
    
    public double getTime()//gets the time purchased
    {return timePurchased;}
    
}
