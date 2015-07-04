package com.anemortalkid.legitimatebot.directives.delay;

import java.awt.Robot;

import com.anemortalkid.legitimatebot.directives.AbstractLegitimateDirective;

public class LegitimateDelayDirective extends AbstractLegitimateDirective {

	private final int delayMS;

	public LegitimateDelayDirective(String directiveName, int delayMS) {
		super(directiveName);
		this.delayMS = delayMS;
	}

	public int getDelayMS() {
		return delayMS;
	}

	@Override
	public void runDirective(Robot robot) {
		robot.delay(delayMS);
	}

	@Override
	public String toString() {
		return super.toString() + ", delayMs=" + delayMS;
	}

}
