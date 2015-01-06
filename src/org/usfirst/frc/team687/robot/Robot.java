
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Joystick left, right;
	Victor frontLt, frontRt, backLt, backRt;
    public void robotInit() {
    	left = new Joystick(1);
    	right = new Joystick(2);
    	frontLt = new Victor(2);
    	frontRt = new Victor(3);
    	backLt = new Victor(4);
    	backRt = new Victor(5);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    
    double forward, rotate, strafe;
    double fl,fr,bl,br;
    public void teleopPeriodic() {
        forward = left.getY();
        strafe = left.getX();
        rotate = right.getX()/2;
        
        fl = threshold(forward + strafe + rotate);
        fr = threshold(-forward + strafe + rotate);
        bl = threshold(forward - strafe + rotate);
        br = threshold(-forward - strafe + rotate);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    public double threshold(double input)	{
    	if(input > 1)	{
    		return 1;
    	}	else if(input < -1)	{
    		return -1;
    	}	else	{
    		return input;
    	}
    }
    
}
