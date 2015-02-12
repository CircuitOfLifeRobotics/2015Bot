package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class  LiftStack extends Command {
	
	final double maxEncoderValue = 9001;
	
    public LiftStack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setElevatorSpeed(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.elevator.getEncoder();>=2000) {
    		Robot.elevator.setLatches(true);
    		Robot.elevator.setElevatorSpeed(-0.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
