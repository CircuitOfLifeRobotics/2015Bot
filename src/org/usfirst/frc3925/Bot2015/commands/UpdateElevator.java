package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateElevator extends Command {
	
	Thread elevatorThread;
	double totalDelay = 0;
	double DELAY = 0.1;
	
    public UpdateElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevatorThread = new Thread(new Runnable() {

			@Override
			public void run() {
				double nextRunTime = Timer.getFPGATimestamp() + DELAY;
				
				while(true) {
					//code
					double currentTime = Timer.getFPGATimestamp();
					// if we have surpassed our allotted time
					if(currentTime > nextRunTime) {
						nextRunTime = currentTime + DELAY;
					} else {
						Timer.delay(nextRunTime - currentTime);
						nextRunTime += DELAY;
					}
				}
			}
    		
    	});
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
