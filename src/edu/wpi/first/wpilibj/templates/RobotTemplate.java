/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Watchdog;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
        Watchdog watchdog;
        Joystick driveStick;
        Victor motorLeftFront;
        Victor motorLeftBack;
        Victor motorRightFront;
        Victor motorRightBack;
        Drivetrain drivetrain;        
        
        
    public void robotInit() {
                driveStick = new Joystick(1);
                motorLeftFront = new Victor(9);
                motorLeftBack = new Victor(10);
                motorRightFront = new Victor(7);
                motorRightBack = new Victor(8);
                drivetrain = new Drivetrain();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
                drivetrain.Drive();
                
                watchdog.feed();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }

    
}