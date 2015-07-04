package com.anemortalkid.legitimatebot.keyboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;

/**
 * A {@link LegitimateTypeStringDirective} types out a given string
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateTypeStringDirective implements ILegitimateDirective {

    private final String string;
    private final List<LegitimateCommandKeyCombination> keyCombinations;

    public LegitimateTypeStringDirective(String string) {
	this.string = string;
	keyCombinations = LegitimateKeyboardUtilities.getCombinationsForSimpleString(string);
    }

    @Override
    public void runDirective(Robot robot) {
	for (final ILegitimateKeyCombination keyCombination : keyCombinations) {
	    keyCombination.typeWithRobot(robot);
	}
    }

    public static void main(String[] args) {
	final String testString = "abcdefghijklmnopqrstuvwxyz123456790`-=[];',./\\ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+}{\":?><|~\n\t\u005Ct\u005Cn";
	try {
	    final Robot robot = new Robot();
	    final LegitimateTypeStringDirective stringDirective = new LegitimateTypeStringDirective(
		    testString);
	    robot.delay(5000);
	    stringDirective.runDirective(robot);
	} catch (final AWTException e) {
	    e.printStackTrace();
	}
    }

}
