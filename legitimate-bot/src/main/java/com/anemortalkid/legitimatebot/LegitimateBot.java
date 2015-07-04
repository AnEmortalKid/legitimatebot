package com.anemortalkid.legitimatebot;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;
import com.anemortalkid.legitimatebot.directives.LegitimateRoutine;
import com.anemortalkid.legitimatebot.keyboard.LegitimateCommandKeyCombination;
import com.anemortalkid.legitimatebot.keyboard.LegitimateKeyMappings;

public class LegitimateBot {

	private Robot robot;
	private LegitimateRoutine routine;

	public LegitimateBot(LegitimateRoutine routine) {
		this.routine = routine;
	}

	public void performRoutine() {
		for (ILegitimateDirective directive : routine.getDirectives())
			directive.runDirective(robot);
	}

	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			robot.delay(2000);
			type(robot, KeyEvent.getExtendedKeyCodeForChar('['));
			type(robot, KeyEvent.getExtendedKeyCodeForChar(']'));
			type(robot, KeyEvent.getExtendedKeyCodeForChar('~'));
			type(robot, KeyEvent.getExtendedKeyCodeForChar('|'));
			// Set<Entry<Character, CommandKeyCombination>> entrySet =
			// KeyMappings[]
			// .getSpecialKeys().entrySet();
			// for (Entry<Character, CommandKeyCombination> entry : entrySet) {
			// System.out.println("Typing '" + entry.getKey() + "'");
			// CommandKeyCombination ckc = entry.getValue();
			// CommandKeyCombination.typeKeyCombination(robot, ckc);
			// }
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void type(Robot robot, int extendedKeyCodeForChar) {
		robot.keyPress(extendedKeyCodeForChar);
		robot.keyRelease(extendedKeyCodeForChar);
	}

}
