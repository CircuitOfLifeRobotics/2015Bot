	package org.usfirst.frc3925.Bot2015.commands;
	
	import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
	
	public class UpdateElevator extends Command {
		final double DELAY = 0.1;
		final double ACCELERATION = 0; //TODO: FIND ACTUAL VALUE
		final double MAX_SPEED = 0; //TODO: FIND ACTUAL VALUE
		
		double heightInput = Robot.oi.getxbox().getRawAxis(2);
		Thread elevatorThread;
		double totalDelay = 0;
		double target = 0;
		
		
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
					double lastPos = Robot.elevator.getElevatorHeight();
					double nextRunTime = Timer.getFPGATimestamp() + DELAY;
					
					while(true) {
						// get current speed
						double currentPos = Robot.elevator.getElevatorHeight();
						double currentSpeed = (currentPos - lastPos) / DELAY;
						
						// get error from target
						double error = currentPos - target;
						
						// get target speed
						double targetPos;
						if (error < (currentSpeed*currentSpeed / (ACCELERATION + ACCELERATION))) {
							// We need to slow down
							// velWeShouldBeGoing = sqrt(error / 2a)
							// nextPos = currentPos + (velWeShouldBeGoing * t - .5*ACC*T*T) //doesn't change anything
							double modeledSpeed = Math.sqrt(error / (ACCELERATION + ACCELERATION));
							targetPos = currentPos + (modeledSpeed + .5 * ACCELERATION * DELAY) * DELAY;
						} else {
							// We need to go max speed
							double deltaSpeed = Math.min(MAX_SPEED - currentSpeed, ACCELERATION * DELAY);
							
							targetPos = (currentSpeed + .5 * deltaSpeed) * DELAY;
						}
						
						// set PID
						Robot.elevator.setElevatorSetPoint(targetPos);
						
						lastPos = currentPos;
						
						// do delay
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
	    	heightInput = Robot.oi.getxbox().getRawAxis(2);
	    	target = heightInput * Robot.elevator.MAXHEIGHT;
	    	
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
