package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rumble extends Command {

	public Rumble() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		
	}    	

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		Joystick joystick = Robot.oi.xbox;
		
		joystick.setRumble(Joystick.RumbleType.kLeftRumble, 1.0f);
		joystick.setRumble(Joystick.RumbleType.kRightRumble, 1.0f);
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
		Joystick joystick = Robot.oi.xbox;

		joystick.setRumble(Joystick.RumbleType.kLeftRumble, 0f);
		joystick.setRumble(Joystick.RumbleType.kRightRumble, 0f);
	}
}
