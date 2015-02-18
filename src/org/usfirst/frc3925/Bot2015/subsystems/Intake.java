package org.usfirst.frc3925.Bot2015.subsystems;

import org.usfirst.frc3925.Bot2015.Robot;
import org.usfirst.frc3925.Bot2015.RobotMap;
import org.usfirst.frc3925.Bot2015.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;


/**
 *
 */
public class Intake extends Subsystem {
	
    SpeedController leftIntakeMotor = RobotMap.intakeleftIntakeMotor;
    SpeedController rightIntakeMotor = RobotMap.intakerightIntakeMotor;
    public DigitalInput toteCapturedSwitch = RobotMap.intaketoteCapturedSwitch;
    SpeedController bottomIntakeMotor = RobotMap.intakebottomIntakeMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setIntakeMotorSpeeds(double speed) {
    	//leftIntakeMotor.set(speed);
    	//rightIntakeMotor.set(-speed);
    	bottomIntakeMotor.set(speed);
    }
    
    public boolean isToteCaptured() {
    	return toteCapturedSwitch.get();
    }
}

