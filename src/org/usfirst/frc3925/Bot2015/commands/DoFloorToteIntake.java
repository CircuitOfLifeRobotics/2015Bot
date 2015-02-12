package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  DoFloorToteIntake extends Command {
	
    public DoFloorToteIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setIntakeMotorSpeeds(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.intake.isToteCaptured();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.intake.setIntakeMotorSpeeds(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.setIntakeMotorSpeeds(0);
    }
}
