package org.usfirst.frc3925.Bot2015.util;

import edu.wpi.first.wpilibj.PIDOutput;

public class SplitPIDOutput implements PIDOutput {

	final PIDOutput[] outputs;
	
	public SplitPIDOutput(PIDOutput ... outputs) {
		this.outputs = outputs;
	}
	
	@Override
	public void pidWrite(double output) {
		for (PIDOutput o : outputs) {
			o.pidWrite(output);
		}
	}

}
