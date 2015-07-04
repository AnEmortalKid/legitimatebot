package com.anemortalkid.legitimatebot.directives.delay;

import java.awt.Robot;

import com.anemortalkid.legitimatebot.directives.LegitimateDirectiveStatus;
import com.anemortalkid.legitimatebot.directives.LegitimateDirectiveStatusType;

public class LegitimateGranularDelayDirective extends LegitimateDelayDirective {

	private int delayInterval;

	public LegitimateGranularDelayDirective(String directiveName, int delayMS,
			int delayInterval) {
		super(directiveName, delayMS);
		this.delayInterval = delayInterval;
	}

	@Override
	public void runDirective(Robot robot) {
		LegitimateDirectiveStatus lds = new LegitimateDirectiveStatus(
				getDirectiveName(), LegitimateDirectiveStatusType.DELAYING);
		lds.setDelayMax(getDelayMS() / delayInterval);
		for (int i = 0; i < getDelayMS(); i += delayInterval) {
			robot.delay(delayInterval);
			lds.setDelayCount((i + delayInterval) / delayInterval);
			notifyListeners(lds);
		}
	}
}
