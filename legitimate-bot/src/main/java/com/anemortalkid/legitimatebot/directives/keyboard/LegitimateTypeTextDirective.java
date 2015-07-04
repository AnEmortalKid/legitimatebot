package com.anemortalkid.legitimatebot.directives.keyboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import com.anemortalkid.legitimatebot.directives.AbstractLegitimateDirective;
import com.anemortalkid.legitimatebot.keyboard.ILegitimateKeyCombination;
import com.anemortalkid.legitimatebot.keyboard.LegitimateCommandKeyCombination;
import com.anemortalkid.legitimatebot.keyboard.LegitimateKeyboardUtilities;

/**
 * A {@link LegitimateTypeTextDirective} types out a given string of text
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateTypeTextDirective extends AbstractLegitimateDirective {

    private final String string;
    private final List<LegitimateCommandKeyCombination> keyCombinations;

    public LegitimateTypeTextDirective(String directiveName, String stringToType) {
	super(directiveName);
	this.string = stringToType;
	keyCombinations = LegitimateKeyboardUtilities.getCombinationsForTextString(stringToType);
    }

    @Override
    public void runDirective(Robot robot) {
	for (final ILegitimateKeyCombination keyCombination : keyCombinations) {
	    keyCombination.typeWithRobot(robot);
	}
    }

    @Override
    public String toString() {
	return super.toString() + ", text=\"" + string + "\"";
    }

    public static void main(String[] args) {
	final String testString = "abcdefghijklmnopqrstuvwxyz123456790`-=[];',./\\ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+}{\":?><|~\n\t\u005Ct\u005Cn";
	try {
	    final Robot robot = new Robot();
	    final LegitimateTypeTextDirective stringDirective = new LegitimateTypeTextDirective(
		    "typeTestString", testString);
	    robot.delay(5000);
	    stringDirective.runDirective(robot);
	} catch (final AWTException e) {
	    e.printStackTrace();
	}
    }

}
