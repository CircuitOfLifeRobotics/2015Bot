package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RawDrive extends Command {

    public RawDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }                                                                
                                                                     
    // Called just before this Command runs the first time           
    protected void initialize() {                                    
    }                                                                
                                                                     
    // Called repeatedly when this Command is scheduled to run       
    protected void execute() {                                       
    	Joystick joystick = Robot.oi.getxbox();                      
    	                                                             
		//Dem varbles                                                
		double leftMotorSpeed, rightMotorSpeed;
		double intakeSpeed, fwdIntake, bckwdIntake;
		
		//driveTrain stuff
			//triggers = fwd + bckwd, right stick = left + right
				//double moveValue = joystick.getRawAxis(3) - joystick.getRawAxis(2);
				//double rotateValue = joystick.getRawAxis(4);
			
			//left stick = fwd + bckwd, right stick = left + right
				double moveValue = joystick.getRawAxis(1);
				double rotateValue = joystick.getRawAxis(4);
			
			//Implements a deadzone
			if (moveValue*moveValue + rotateValue*rotateValue < .08) {
				moveValue = 0;
				rotateValue = 0;
			}
			
			//Calculates motor powers for arcade drive
			if(moveValue > 0.0){
				if(rotateValue > 0.0){
					leftMotorSpeed = moveValue - rotateValue;
					rightMotorSpeed = Math.max(moveValue, rotateValue);
				}else {
					rightMotorSpeed = moveValue + rotateValue;
					leftMotorSpeed = Math.max(moveValue, -rotateValue);
				}
			}else {
				if(rotateValue > 0.0){
					rightMotorSpeed = moveValue + rotateValue;
					leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				}else {
					leftMotorSpeed = moveValue - rotateValue;
					rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
				}
			}
			// "setRawMotorSpeeds" = w/o PID, "setMotorSpeeds" = with PID
			//Robot.driveTrain.enable();
			Robot.driveTrain.setRawMotorSpeeds(leftMotorSpeed, rightMotorSpeed);
		
		//intake stuff
			if(joystick.getRawButton(5)) {
				fwdIntake = 1;
			}else {
				fwdIntake = 0;
			} if(joystick.getRawButton(6)) {
				bckwdIntake = 1;
			}else {
				bckwdIntake = 0;
			}
			intakeSpeed = fwdIntake - bckwdIntake;
			Robot.intake.setIntakeMotorSpeeds(intakeSpeed);
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
