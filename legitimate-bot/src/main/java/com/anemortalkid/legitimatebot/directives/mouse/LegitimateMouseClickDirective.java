package com.anemortalkid.legitimatebot.directives.mouse;

import java.awt.Robot;

public class LegitimateMouseClickDirective extends LegitimateMouseMoveDirective {

    protected final int mouseButton;

    /**
     * 
     * @param directiveName
     * @param xPos
     * @param yPos
     * @param mouseButton
     * @see Robot#mousePress(int)
     */
    public LegitimateMouseClickDirective(String directiveName, int xPos, int yPos, int mouseButton) {
	super(directiveName, xPos, yPos);
	this.mouseButton = mouseButton;
    }

    @Override
    public void runDirective(Robot robot) {
	moveMouse(robot);
	clickMouse(robot);
    }

    /**
     * Convenience
     * 
     * @param robot
     */
    protected void clickMouse(Robot robot) {
	robot.mousePress(mouseButton);
	robot.mouseRelease(mouseButton);
    }

}
