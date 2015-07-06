package com.anemortalkid.legitimatebot.directives.mouse;

import java.awt.Robot;

import com.anemortalkid.legitimatebot.directives.AbstractLegitimateDirective;

public class LegitimateMouseMoveDirective extends AbstractLegitimateDirective {

    protected final int xPos;
    protected final int yPos;

    public LegitimateMouseMoveDirective(String directiveName, int xPos, int yPos) {
	super(directiveName);
	this.xPos = xPos;
	this.yPos = yPos;
    }

    @Override
    public void runDirective(Robot robot) {
	moveMouse(robot);
    }

    public int getxPos() {
	return xPos;
    }

    public int getyPos() {
	return yPos;
    }

    /**
     * Convenience
     * 
     * @param robot
     */
    protected void moveMouse(Robot robot) {
	robot.mouseMove(xPos, yPos);
	// give robot a quick break to finish
	robot.delay(10);
    }

}
