package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  EjectStack extends Command {
	
	final double toteHeight = 2000;
	boolean totesReached = false;
	int timer = 0;
	int timerLimit = 10000;
	boolean timerLimitReached = false;
	
    public EjectStack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!totesReached && Math.abs(toteHeight-Robot.elevator.getElevatorHeight()) < 10) {
    	}else{
    		if(totesReached) {
    			if(Robot.intake.isToteCaptured()) {
    				Robot.intake.setIntakeMotorSpeeds(-1);
    			}else {
    				timer++;
    			}
    		}
    	}
    	
    	if(timer >= timerLimit) {
    		timerLimitReached = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timerLimitReached;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setIntakeMotorSpeeds(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
