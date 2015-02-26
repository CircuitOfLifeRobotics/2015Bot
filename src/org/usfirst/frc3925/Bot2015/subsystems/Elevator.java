package org.usfirst.frc3925.Bot2015.subsystems;

import org.usfirst.frc3925.Bot2015.RobotMap;
import org.usfirst.frc3925.Bot2015.commands.UpdateElevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    Encoder elevatorEncoder = RobotMap.elevatorelevatorEncoder;
    SpeedController leftElevatorMotor = RobotMap.elevatorLeftElevatorMotor;
    SpeedController rightElevatorMotor = RobotMap.elevatorRightElevatorMotor;
    PIDController elevatorPIDController = RobotMap.elevatorelevatorPIDController;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
    	setDefaultCommand(new UpdateElevator());
    }
    
    public double getElevatorHeight() {
    	return elevatorEncoder.getDistance();
    }
    
    public void setElevatorSpeed(double speed) {
    	leftElevatorMotor.set(speed);
    	rightElevatorMotor.set(speed);
    }
    
    public void setElevatorSetPoint(double setPoint) {
    	elevatorPIDController.enable();
    	elevatorPIDController.setSetpoint(setPoint);
    }
    
}

