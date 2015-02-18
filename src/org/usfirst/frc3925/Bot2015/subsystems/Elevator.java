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
    SpeedController leftElevatorMotor = RobotMap.elevatorLeftElevatorMotor;
    SpeedController rightElevatorMotor = RobotMap.elevatorRightElevatorMotor;
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
    	Joystick joystick = Robot.oi.getxbox();
    	double maxHeight = 1000;
    	double minHeight = 0;
    	
    	if(joystick.getRawButton(3)) {
    		maxHeight = Robot.elevator.getEncoder();
    	} if(joystick.getRawButton(4)) {
    		minHeight = Robot.elevator.getEncoder();
    	}
    	
    	//set limits
		if(Robot.elevator.getEncoder() > maxHeight && speed < 0) {
			//speed = 0;
			//joystick.setRumble(Joystick.RumbleType.kLeftRumble, 1.0f);
		}else { if(Robot.elevator.getEncoder() < minHeight && speed > 0) {
			speed = 0;
			joystick.setRumble(Joystick.RumbleType.kRightRumble, 1.0f);
		}else {
			joystick.setRumble(Joystick.RumbleType.kLeftRumble, 0.0f);
			joystick.setRumble(Joystick.RumbleType.kRightRumble, 0.0f);
		}}
    	
    	leftElevatorMotor.set(speed);
    	rightElevatorMotor.set(speed);
    }
    
    public void setElevatorHeight(double target) {
    	final double maxEncoderValue = 9001; // IT'S OVER 9000!
    	final double range = 10;
    	boolean targetReached = false;
    	double start = Robot.elevator.getEncoder();
    	
    	Robot.elevator.setElevatorSpeed((target-start)/maxEncoderValue);
    	while(Math.abs(target-Robot.elevator.getEncoder()) >= range) {}
    	Robot.elevator.setElevatorSpeed(0);
    }
    
    public void liftStack() {
    	Robot.elevator.liftStack();
    }
}

