/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Enforers
 */
public class Shooter {
    Solenoid low; 
    Solenoid medium;
    Solenoid high;
    Joystick auxStick;
        
    public Shooter(){
        low = new Solenoid(1);
        medium = new Solenoid(2);
        high = new Solenoid(3);
        auxStick = new Joystick(2);
        
    }
    public void shootThreeStage(){
        if(auxStick.getRawButton(2)){
            low.set(true);
            //TIMER
            medium.set(true);
            //TIMER
            high.set(true);
            //TIMER
            low.set(false);
            medium.set(false);
            high.set(false);
        }
    }
    
    public void shootTwoStage(){
        
    }
}
