package com.anemortalkid.legitimatebot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;
import com.anemortalkid.legitimatebot.directives.routine.LegitimateRoutine;

public class LegitimateBot {

    private Robot robot;
    private final LegitimateRoutine routine;

    public LegitimateBot(LegitimateRoutine routine) {
	this.routine = routine;
    }

    public void performRoutine() {
	for (final ILegitimateDirective directive : routine.getDirectives()) {
	    directive.runDirectiveAndNotify(robot);
	}
    }

    public static void main(String[] args) {
	try {
	    final Robot robot = new Robot();
	    robot.delay(2000);
	    /**
	     * <pre>
	     * It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, or PARAGRAPH_SEPARATOR) 
	     * but is not also a non-breaking space ('\u005Cu00A0', '\u005Cu2007', '\u005Cu202F'). 
	     * It is '\u005Ct', U+0009 HORIZONTAL TABULATION. 
	     * It is '\u005Cn', U+000A LINE FEED. 
	     * It is '\u005Cu000B', U+000B VERTICAL TABULATION. 
	     * It is '\u005Cf', U+000C FORM FEED. 
	     * It is '\u005Cr', U+000D CARRIAGE RETURN. 
	     * It is '\u005Cu001C', U+001C FILE SEPARATOR. 
	     * It is '\u005Cu001D', U+001D GROUP SEPARATOR. 
	     * It is '\u005Cu001E', U+001E RECORD SEPARATOR. 
	     * It is '\u005Cu001F', U+001F UNIT SEPARATOR.
	     * </pre>
	     */

	    type(robot, KeyEvent.getExtendedKeyCodeForChar('\u005Ct'));
	    type(robot, KeyEvent.getExtendedKeyCodeForChar('\u005Cn'));
	    type(robot, KeyEvent.getExtendedKeyCodeForChar('\n'));
	    type(robot, KeyEvent.getExtendedKeyCodeForChar('\t'));
	    type(robot, KeyEvent.getExtendedKeyCodeForChar(' '));

	    // Set<Entry<Character, CommandKeyCombination>> entrySet =
	    // KeyMappings[]
	    // .getSpecialKeys().entrySet();
	    // for (Entry<Character, CommandKeyCombination> entry : entrySet) {
	    // System.out.println("Typing '" + entry.getKey() + "'");
	    // CommandKeyCombination ckc = entry.getValue();
	    // CommandKeyCombination.typeKeyCombination(robot, ckc);
	    // }
	} catch (final AWTException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	}
    }

    private static void type(Robot robot, int extendedKeyCodeForChar) {
	System.out.println("Typing: '" + (char) extendedKeyCodeForChar + "'");
	robot.keyPress(extendedKeyCodeForChar);
	robot.keyRelease(extendedKeyCodeForChar);
    }

}
