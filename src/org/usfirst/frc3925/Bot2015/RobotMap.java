package org.usfirst.frc3925.Bot2015;
    
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	static final int
		//Motor ports
		LEFT_DRIVE_TALON_PORT = 0,
		RIGHT_DRIVE_TALON_PORT = 1,
		LIFT_TALON_PORT_RIGHT = 2,
		LIFT_TALON_PORT_LEFT = 3,
		LEFT_WHEEL_TALON_PORT = 4,
		RIGHT_WHEEL_TALON_PORT = 5,
		ROLLERS_TALON_PORT = 6,
		
		//Digital ports
		LEFT_DRIVE_ENCODER_PORT_1 = 0,
		LEFT_DRIVE_ENCODER_PORT_2 = 1,
		RIGHT_DRIVE_ENCODER_PORT_1 = 2,
		RIGHT_DRIVE_ENCODER_PORT_2 = 3,
		LIFT_ENCODER_PORT_1 = 4,
		LIFT_ENCODER_PORT_2 = 5,
		TOTE_CAPTURED_MICROSWITCH_PORT = 9,
		
		//Solenoid ports
		DRIVE_SHIFT_SOLENOID_PORT_1 = 0,
		DRIVE_SHIFT_SOLENOID_PORT_2 = 1,
		LATCHES_SOLENOID_PORT_1 = 2,
		LATCHES_SOLENOID_PORT_2 = 3;
	
    public static Victor driveTrainrightFront;
    public static Victor driveTrainleftFront;
    public static DoubleSolenoid driveTraindriveShiftSolenoid;
    public static Encoder driveTrainleftDriveEncoder;
    public static Encoder driveTrainrightDriveEncoder;
    
    public static Encoder elevatorelevatorEncoder;
    public static SpeedController elevatorLeftElevatorMotor;
    public static SpeedController elevatorRightElevatorMotor;
    public static PIDController elevatorelevatorPIDController;
    
    public static Compressor generalPneumaticscompressor;
    public static SpeedController forkLiftforkliftLiftMotor;
    public static Encoder forkLiftforkliftLiftEncoder;
    public static PIDController forkLiftforkliftPIDController;
    public static SpeedController intakeleftIntakeMotor;
    public static SpeedController intakerightIntakeMotor;
    public static DigitalInput intaketoteCapturedSwitch;
    public static SpeedController intakebottomIntakeMotor;
    public static DoubleSolenoid latcheslatchReleaseSolenoid;
    
    public static AxisCamera cameraAxisCamera;


    public static void init() {
        driveTrainrightFront = new Victor(RIGHT_DRIVE_TALON_PORT);
        LiveWindow.addActuator("DriveTrain", "rightFront", (Victor) driveTrainrightFront);
        
        driveTrainleftFront = new Victor(LEFT_DRIVE_TALON_PORT);
        LiveWindow.addActuator("DriveTrain", "leftFront", (Victor) driveTrainleftFront);
        
        driveTraindriveShiftSolenoid = new DoubleSolenoid(1, DRIVE_SHIFT_SOLENOID_PORT_1, DRIVE_SHIFT_SOLENOID_PORT_2);   
        LiveWindow.addActuator("DriveTrain", "driveShiftSolenoid", driveTraindriveShiftSolenoid);
        
        driveTrainleftDriveEncoder = new Encoder(LEFT_DRIVE_ENCODER_PORT_1, LEFT_DRIVE_ENCODER_PORT_2, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "leftDriveEncoder", driveTrainleftDriveEncoder);
        driveTrainleftDriveEncoder.setDistancePerPulse(0.013089969);//was 0.09817477
        driveTrainleftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        driveTrainrightDriveEncoder = new Encoder(RIGHT_DRIVE_ENCODER_PORT_1, RIGHT_DRIVE_ENCODER_PORT_2, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "rightDriveEncoder", driveTrainrightDriveEncoder);
        driveTrainrightDriveEncoder.setDistancePerPulse(0.013089969);//was 0.09817477
        driveTrainrightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        elevatorelevatorEncoder = new Encoder(LIFT_ENCODER_PORT_1, LIFT_ENCODER_PORT_2, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "elevatorEncoder", elevatorelevatorEncoder);
        elevatorelevatorEncoder.setDistancePerPulse(1.0);
        elevatorelevatorEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        elevatorLeftElevatorMotor = new Talon(LIFT_TALON_PORT_LEFT);
        LiveWindow.addActuator("Elevator", "leftElevatorMotor", (Talon) elevatorLeftElevatorMotor);
        elevatorRightElevatorMotor = new Talon(LIFT_TALON_PORT_RIGHT);
        LiveWindow.addActuator("Elevator", "rightElevatorMotor", (Talon) elevatorRightElevatorMotor);
        
        elevatorelevatorPIDController = new PIDController(1.0, 0.0, 0.0, 0.0, elevatorelevatorEncoder, elevatorLeftElevatorMotor, 0.02);
        LiveWindow.addActuator("Elevator", "elevatorPIDController", elevatorelevatorPIDController);
        elevatorelevatorPIDController.setContinuous(false); elevatorelevatorPIDController.setAbsoluteTolerance(0.2); 
        elevatorelevatorPIDController.setOutputRange(-1.0, 1.0);        

        generalPneumaticscompressor = new Compressor(1);
        	
        
        forkLiftforkliftLiftMotor = new Talon(8);
        LiveWindow.addActuator("ForkLift", "forkliftLiftMotor", (Talon) forkLiftforkliftLiftMotor);
        
        forkLiftforkliftLiftEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("ForkLift", "forkliftLiftEncoder", forkLiftforkliftLiftEncoder);
        forkLiftforkliftLiftEncoder.setDistancePerPulse(1.0);
        forkLiftforkliftLiftEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        forkLiftforkliftPIDController = new PIDController(1.0, 0.0, 0.0, 0.0, forkLiftforkliftLiftEncoder, forkLiftforkliftLiftMotor, 0.02);
        LiveWindow.addActuator("ForkLift", "forkliftPIDController", forkLiftforkliftPIDController);
        forkLiftforkliftPIDController.setContinuous(false); forkLiftforkliftPIDController.setAbsoluteTolerance(0.2); 
        forkLiftforkliftPIDController.setOutputRange(-1.0, 1.0);
        
//		This line has/had problems  ||
//									||
//								   _||_
//								   \  /
//									\/
        intakeleftIntakeMotor = new Talon(LEFT_WHEEL_TALON_PORT);
        LiveWindow.addActuator("Intake", "leftIntakeMotor", (Talon) intakeleftIntakeMotor);
        
        intakerightIntakeMotor = new Talon(RIGHT_WHEEL_TALON_PORT);
        LiveWindow.addActuator("Intake", "rightIntakeMotor", (Talon) intakerightIntakeMotor);
        
        intaketoteCapturedSwitch = new DigitalInput(TOTE_CAPTURED_MICROSWITCH_PORT);
        LiveWindow.addSensor("Intake", "toteCapturedSwitch", intaketoteCapturedSwitch);
        
        intakebottomIntakeMotor = new Talon(ROLLERS_TALON_PORT);
        LiveWindow.addActuator("Intake", "bottomIntakeMotor", (Talon) intakebottomIntakeMotor);
        
        latcheslatchReleaseSolenoid = new DoubleSolenoid(1, LATCHES_SOLENOID_PORT_1, LATCHES_SOLENOID_PORT_2);
        LiveWindow.addActuator("Latches", "latchReleaseSolenoid", latcheslatchReleaseSolenoid);
        
        cameraAxisCamera = new AxisCamera("10.39.25.11");
        

    }
}
