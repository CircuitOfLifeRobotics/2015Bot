package org.usfirst.frc3925.Bot2015.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoggedPIDSource implements PIDSource {

	private final PIDSource source;
	private final String key;
	
	public LoggedPIDSource(String key, PIDSource source) {
		this.source = source;
		this.key = key;
	}

	@Override
	public double pidGet() {
		double val = source.pidGet();
		SmartDashboard.putNumber(key, val);
		return val;
	}

}
