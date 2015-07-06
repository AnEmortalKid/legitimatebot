package com.anemortalkid.legitimatebot.directives.mouse;

import java.awt.Robot;

public class LegitimateMouseMulticlickDirective extends LegitimateMouseClickDirective {

    private final int clickCount;

    public LegitimateMouseMulticlickDirective(String directiveName, int xPos, int yPos, int mouseButton, int clickCount) {
	super(directiveName, xPos, yPos, mouseButton);

	if (clickCount < 1) {
	    throw new IllegalArgumentException("clickCount must be positive");
	}

	this.clickCount = clickCount;
    }

    @Override
    public void runDirective(Robot robot) {
	moveMouse(robot);
	for (int i = 0; i < clickCount; i++) {
	    clickMouse(robot);
	}
    }

}
