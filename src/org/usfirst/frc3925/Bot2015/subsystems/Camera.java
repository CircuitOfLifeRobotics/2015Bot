package org.usfirst.frc3925.Bot2015.subsystems;

import org.usfirst.frc3925.Bot2015.RobotMap;
import org.usfirst.frc3925.Bot2015.commands.UpdateCamera;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 */
public class Camera extends Subsystem {
    
    private AxisCamera axisCamera = RobotMap.cameraAxisCamera;

    public void initDefaultCommand() {
//        setDefaultCommand(new UpdateCamera());
    }
    
    public void getImage(NIVision.Image frame) {
    	axisCamera.getImage(frame);
    }
}

