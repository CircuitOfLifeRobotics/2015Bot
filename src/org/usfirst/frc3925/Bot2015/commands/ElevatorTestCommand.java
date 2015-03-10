package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorTestCommand extends Command {
	
	final double MAX_HEIGHT = 5;
	
    public ElevatorTestCommand() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double elevatorHeight = Robot.oi.xbox.getRawAxis(2);
    	elevatorHeight = elevatorHeight * 5;
    	if(elevatorHeight > 5 || elevatorHeight < 0) {
    	}else {
    		Robot.elevator.setElevatorSetPoint(elevatorHeight);
    	}
    	
    	SmartDashboard.putNumber("ElevatorHeight", elevatorHeight);
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
