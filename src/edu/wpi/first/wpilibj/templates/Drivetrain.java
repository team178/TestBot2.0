/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Enforers
 */
public class Drivetrain {
    Joystick driveStick, kidStick;
    Victor /*leftFront,*/ rightFront, leftBack, rightBack;
    Victor encoderMotor;
    Talon leftFront;
    double speedLimit = 0.75;

    public Drivetrain() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        leftFront = new Talon(6);
        rightFront = new Victor(4);
        leftBack = new Victor(1);
        rightBack = new Victor(3);
        this.encoderMotor = new Victor(7);

        this.driveStick = new Joystick(1);
        this.kidStick = new Joystick(2);
    }   

    public void drive(){
        double xValue = driveStick.getX();
        double yValue = driveStick.getY();
        double twistValue = .8*driveStick.getTwist();
            leftFront.set( -speedLimit * ( yValue + xValue - twistValue ) );
            rightFront.set( speedLimit * ( yValue - xValue + twistValue ) );
            leftBack.set( -speedLimit * ( yValue - xValue - twistValue ) );
            rightBack.set( speedLimit * ( yValue + xValue + twistValue ) );
            encoderMotor.set(driveStick.getY());
    }
    public void kiddyDrive(){
        double xValue = driveStick.getX();
        double yValue = driveStick.getY();
        double twistValue = .8*driveStick.getTwist();
        double kidX = kidStick.getX() * .3;
        double kidY = kidStick.getY() * .3;
        double kidTwist = kidStick.getTwist() * .4;
        if(driveStick.getTrigger()){
            leftFront.set( -speedLimit * ( yValue + xValue - twistValue ) );
            rightFront.set( speedLimit * ( yValue - xValue + twistValue ) );
            leftBack.set( -speedLimit * ( yValue - xValue - twistValue ) );
            rightBack.set( speedLimit * ( yValue + xValue + twistValue ) );
            //encoderMotor.set(driveStick.getY());
        }else{
            leftFront.set( -speedLimit * ( kidY + kidX - kidTwist ) );
            rightFront.set( speedLimit * ( kidY - kidX + kidTwist ) );
            leftBack.set( -speedLimit * ( kidY - kidX - kidTwist ) );
            rightBack.set( speedLimit * ( kidY + kidX + kidTwist ) );
        }
    }
}