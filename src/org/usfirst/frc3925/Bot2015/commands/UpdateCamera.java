package org.usfirst.frc3925.Bot2015.commands;

import org.usfirst.frc3925.Bot2015.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateCamera extends Command {

	NIVision.Image frame;
	
    public UpdateCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.camera.getImage(frame);
    	
    	//play with image
    	
    	NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
        DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
    	
    	CameraServer.getInstance().setImage(frame); 
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
