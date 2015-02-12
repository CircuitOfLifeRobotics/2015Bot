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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController driveTrainrightRear;
    public static SpeedController driveTrainrightFront;
    public static SpeedController driveTrainleftFront;
    public static DoubleSolenoid driveTraindriveShiftSolenoid;
    public static Encoder driveTrainleftDriveEncoder;
    public static Encoder driveTrainrightDriveEncoder;
    public static SpeedController driveTrainleftRear;
    
    public static Encoder elevatorelevatorEncoder;
    public static SpeedController elevatorelevatorMotor;
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
//        driveTrainrightRear = new Talon(0);
//        LiveWindow.addActuator("DriveTrain", "rightRear", (Talon) driveTrainrightRear);
        
        driveTrainrightFront = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "rightFront", (Talon) driveTrainrightFront);
        
        driveTrainleftFront = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "leftFront", (Talon) driveTrainleftFront);
        
//        driveTrainleftRear = new Talon(3);
//        LiveWindow.addActuator("DriveTrain", "leftRear", (Talon) driveTrainleftRear);

        driveTraindriveShiftSolenoid = new DoubleSolenoid(1, 0, 1);      
        LiveWindow.addActuator("DriveTrain", "driveShiftSolenoid", driveTraindriveShiftSolenoid);
        
        driveTrainleftDriveEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "leftDriveEncoder", driveTrainleftDriveEncoder);
        driveTrainleftDriveEncoder.setDistancePerPulse(0.013089969);//was 0.09817477
        driveTrainleftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        driveTrainrightDriveEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "rightDriveEncoder", driveTrainrightDriveEncoder);
        driveTrainrightDriveEncoder.setDistancePerPulse(0.013089969);//was 0.09817477
        driveTrainrightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        elevatorelevatorEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "elevatorEncoder", elevatorelevatorEncoder);
        elevatorelevatorEncoder.setDistancePerPulse(1.0);
        elevatorelevatorEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        elevatorelevatorMotor = new Talon(4);
        LiveWindow.addActuator("Elevator", "elevatorMotor", (Talon) elevatorelevatorMotor);
        
        elevatorelevatorPIDController = new PIDController(1.0, 0.0, 0.0, 0.0, elevatorelevatorEncoder, elevatorelevatorMotor, 0.02);
        LiveWindow.addActuator("Elevator", "elevatorPIDController", elevatorelevatorPIDController);
        elevatorelevatorPIDController.setContinuous(false); elevatorelevatorPIDController.setAbsoluteTolerance(0.2); 
        elevatorelevatorPIDController.setOutputRange(-1.0, 1.0);        

        generalPneumaticscompressor = new Compressor(1);
        
        
        forkLiftforkliftLiftMotor = new Talon(5);
        LiveWindow.addActuator("ForkLift", "forkliftLiftMotor", (Talon) forkLiftforkliftLiftMotor);
        
        forkLiftforkliftLiftEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("ForkLift", "forkliftLiftEncoder", forkLiftforkliftLiftEncoder);
        forkLiftforkliftLiftEncoder.setDistancePerPulse(1.0);
        forkLiftforkliftLiftEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        forkLiftforkliftPIDController = new PIDController(1.0, 0.0, 0.0, 0.0, forkLiftforkliftLiftEncoder, forkLiftforkliftLiftMotor, 0.02);
        LiveWindow.addActuator("ForkLift", "forkliftPIDController", forkLiftforkliftPIDController);
        forkLiftforkliftPIDController.setContinuous(false); forkLiftforkliftPIDController.setAbsoluteTolerance(0.2); 
        forkLiftforkliftPIDController.setOutputRange(-1.0, 1.0);        

        intakeleftIntakeMotor = new Talon(0);
        LiveWindow.addActuator("Intake", "leftIntakeMotor", (Talon) intakeleftIntakeMotor);
        
        intakerightIntakeMotor = new Talon(1);
        LiveWindow.addActuator("Intake", "rightIntakeMotor", (Talon) intakerightIntakeMotor);
        
        intaketoteCapturedSwitch = new DigitalInput(8);
        LiveWindow.addSensor("Intake", "toteCapturedSwitch", intaketoteCapturedSwitch);
        
        intakebottomIntakeMotor = new Talon(2);
        LiveWindow.addActuator("Intake", "bottomIntakeMotor", (Talon) intakebottomIntakeMotor);
        
        latcheslatchReleaseSolenoid = new DoubleSolenoid(1, 3, 4);
        LiveWindow.addActuator("Latches", "latchReleaseSolenoid", latcheslatchReleaseSolenoid);
        
        cameraAxisCamera = new AxisCamera("10.39.25.11");
        

    }
}
