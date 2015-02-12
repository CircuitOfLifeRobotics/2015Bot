package org.usfirst.frc3925.Bot2015.subsystems;

import org.usfirst.frc3925.Bot2015.Robot;
import org.usfirst.frc3925.Bot2015.RobotMap;
import org.usfirst.frc3925.Bot2015.commands.*;
import org.usfirst.frc3925.Bot2015.util.LoggedPIDSource;
import org.usfirst.frc3925.Bot2015.util.SplitPIDOutput;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    Encoder elevatorEncoder = RobotMap.elevatorelevatorEncoder;
    SpeedController elevatorMotor = RobotMap.elevatorelevatorMotor;
//    PIDController elevatorPIDController = RobotMap.elevatorelevatorPIDController;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setLatches(boolean value) {
    	Robot.latches.setLatchesEngaged(value);
    }
    
    public double getEncoder() {
    	return elevatorEncoder.getDistance();
    }
    
    public void setElevatorSpeed(double speed) {
    	elevatorMotor.set(speed);
    }
}

