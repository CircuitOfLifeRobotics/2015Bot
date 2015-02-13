package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  SetElevatorHeight extends Command {
	
	final double maxEncoderValue = 9001; // IT'S OVER 9000!
	boolean targetReached = false;
	double target;
	
    public SetElevatorHeight(double target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.target = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double start = Robot.elevator.getEncoder();
    	Robot.elevator.setElevatorSpeed((target-Robot.elevator.getEncoder())/maxEncoderValue);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(Math.abs(target-Robot.elevator.getEncoder()) < 10) {
//    		targetReached = true;
//    		Robot.elevator.setElevatorSpeed((target-Robot.elevator.getEncoder())/maxEncoderValue);
//    	}
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
