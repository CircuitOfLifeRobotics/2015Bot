package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetIntakeMotorSpeed extends Command {
	
	double speed;
	Joystick xbox;
	
    public SetIntakeMotorSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//may crash stuff and cause much strife
    	xbox = Robot.oi.getxbox();
    	speed = xbox.getRawAxis(0);
    	
    	if(speed<0.1) {
    		speed = 0;
    	}
    	
    	Robot.intake.setIntakeMotorSpeeds(speed);
//    	Robot.elevator.setElevatorHeight(speed*9000);
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
