package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  SetElevatorHeight extends Command {
	
	final double maxEncoderValue = 90001; // IT'S OVER 9000!
	boolean targetReached = false;
	double target;
	double speed;
	
    public SetElevatorHeight(double target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.target = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	speed = (target-Robot.elevator.getEncoder())/maxEncoderValue;
//    	if(target-Robot.elevator.getEncoder() > 0) {
//    		speed = 0.5;
//    	}else {if(target-Robot.elevator.getEncoder() < 0) {
//    			speed = -0.5;
//    		}else {
//    			speed = 0;
//    		}
//    	}
//    	if(speed < 0.05 && speed > 0) {
//    		speed = 0.05;
//    	}
//    	if(speed > -0.05 && speed < 0) {
//    		speed = -0.05;
//    	}
    	speed = -0.3;
    	Robot.elevator.setElevatorSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Math.abs(target-Robot.elevator.getEncoder()) < 1) {
    		targetReached = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(targetReached) {
    		return false;
    	}else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setElevatorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.setElevatorSpeed(0);
    }
}
