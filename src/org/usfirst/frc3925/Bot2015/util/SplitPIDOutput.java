package org.usfirst.frc3925.Bot2015.util;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SplitPIDOutput implements PIDOutput {

	final PIDOutput[] outputs;
	
	public SplitPIDOutput(PIDOutput ... outputs) {
		this.outputs = outputs;
	}
	
	@Override
	public void pidWrite(double output) {
		SmartDashboard.putNumber("last value written to motor", output);
		for (PIDOutput o : outputs) {
			o.pidWrite(output);
		}
	}

}
