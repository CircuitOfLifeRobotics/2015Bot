package org.usfirst.frc3925.Bot2015;

import org.usfirst.frc3925.Bot2015.commands.DefaultDrive;
import org.usfirst.frc3925.Bot2015.commands.DoFloorToteIntake;
import org.usfirst.frc3925.Bot2015.commands.DoHumanToteIntake;
import org.usfirst.frc3925.Bot2015.commands.EjectStack;
import org.usfirst.frc3925.Bot2015.commands.EngageLatch;
import org.usfirst.frc3925.Bot2015.commands.LiftStack;
import org.usfirst.frc3925.Bot2015.commands.RawDrive;
import org.usfirst.frc3925.Bot2015.commands.ReleaseLatch;
import org.usfirst.frc3925.Bot2015.commands.Rumble;
import org.usfirst.frc3925.Bot2015.commands.SetElevatorHeight;
import org.usfirst.frc3925.Bot2015.commands.SetIntakeMotorSpeed;
import org.usfirst.frc3925.Bot2015.commands.ShiftToHighGear;
import org.usfirst.frc3925.Bot2015.commands.ShiftToLowGear;
import org.usfirst.frc3925.Bot2015.subsystems.Intake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    public Joystick xbox;
    public Joystick launchpad;
    
    private JoystickButton shiftUp, shiftDown, rumbleBtn, elevatorUp, elevatorDown, intakeMotors, elevatorSet;

    public OI() {
    	int elevatorHeight = 0;
    	boolean btnReleased = true;
    	boolean driveShiftState = false;
    	
        launchpad = new Joystick(1);
        
        xbox = new Joystick(0);
        
        if(!driveShiftState && btnReleased) {
        	shiftUp = new JoystickButton(xbox, 1);
        	shiftUp.whenPressed(new ShiftToHighGear());
        	driveShiftState = false;
        	btnReleased = false;
        }else {if(driveShiftState && btnReleased) {
        	shiftDown = new JoystickButton(xbox, 1);
        	shiftDown.whenPressed(new ShiftToLowGear());
        	driveShiftState = true;
        	btnReleased = false;
        	}else {
        		btnReleased = true;
        	}
        }
	    
        rumbleBtn = new JoystickButton(xbox, 2);
        rumbleBtn.whileHeld(new Rumble());
        
//        intakeMotors = new JoystickButton(xbox, 5);
//        intakeMotors.whileHeld(new SetIntakeMotorSpeed());
        
//        elevatorUp = new JoystickButton(xbox, 2);
//        elevatorUp.whenPressed(new (0100));
//        
//        elevatorDown = new JoystickButton(xbox, 3);
//        elevatorDown.whenPressed(new SetElevatorHeight(0));
        
        SmartDashboard.putData("SetElevatorHeight", new SetElevatorHeight(0d));

        SmartDashboard.putData("DefaultDrive", new DefaultDrive());

        SmartDashboard.putData("DoFloorToteIntake", new DoFloorToteIntake());

        SmartDashboard.putData("DoHumanToteIntake", new DoHumanToteIntake());

        SmartDashboard.putData("LiftStack", new LiftStack());

        SmartDashboard.putData("EjectStack", new EjectStack());

        SmartDashboard.putData("ReleaseLatch", new ReleaseLatch());

        SmartDashboard.putData("EngageLatch", new EngageLatch());

        SmartDashboard.putData("ShiftToHighGear", new ShiftToHighGear());

        SmartDashboard.putData("ShiftToLowGear", new ShiftToLowGear());
        
        SmartDashboard.putData("RawDrive", new RawDrive());

    }
    
    public Joystick getxbox() {
        return xbox;
    }

    public Joystick getlaunchpad() {
        return launchpad;
    }

}

