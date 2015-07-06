package com.anemortalkid.legitimatebot.directives.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class LegitimateMouseDoubleClickDirective extends LegitimateMouseMulticlickDirective {

    public LegitimateMouseDoubleClickDirective(String directiveName, int xPos, int yPos, int mouseButton) {
	super(directiveName, xPos, yPos, mouseButton, 2);
    }

    public static void main(String[] args) {
	Robot robot = null;
	try {
	    robot = new Robot();
	    robot.delay(5000);
	    final LegitimateMouseDoubleClickDirective dbl = new LegitimateMouseDoubleClickDirective(
		    "dblClick", 756, 218, InputEvent.BUTTON1_DOWN_MASK);
	    dbl.runDirectiveAndNotify(robot);
	} catch (final AWTException e) {
	    e.printStackTrace();
	}
    }

}
