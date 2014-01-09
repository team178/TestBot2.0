/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Enforers
 */
public class Drivetrain {
    Joystick driveStick = new Joystick(1);
    Victor motorLeftFront = new Victor(1);
    Victor motorLeftBack = new Victor(2);
    Victor motorRightFront = new Victor(3);
    Victor motorRightBack = new Victor(4);
    public Drivetrain() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    public void Drive(){
        double xValue = driveStick.getX();
        double yValue = driveStick.getY();
        double twistValue = driveStick.getTwist();
        motorLeftFront.set(twistValue + yValue - xValue);
        motorRightFront.set(twistValue + yValue + xValue);
        motorLeftBack.set(twistValue - yValue - xValue);
        motorRightBack.set(twistValue - yValue + xValue);
    }
}
