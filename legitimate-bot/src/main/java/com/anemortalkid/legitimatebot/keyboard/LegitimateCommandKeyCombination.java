package com.anemortalkid.legitimatebot.keyboard;

import java.awt.Robot;

public class LegitimateCommandKeyCombination {

	private int[] keyCombinations;
	private int[] modifierKeys;

	public LegitimateCommandKeyCombination(int[] modifierKeys, int[] keyCombinations) {
		this.modifierKeys = modifierKeys;
		this.keyCombinations = keyCombinations;
	}

	public int[] getModifierKeys() {
		return modifierKeys;
	}

	public int[] getKeyCombinations() {
		return keyCombinations;
	}

	public static void typeKeyCombination(Robot robot,
			LegitimateCommandKeyCombination commandKeyCombination) {

		// hold modifiers down
		for (int modifierKey : commandKeyCombination.getModifierKeys()) {
			robot.keyPress(modifierKey);
		}

		for (int keyCode : commandKeyCombination.getKeyCombinations()) {
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		}

		for (int modifierKey : commandKeyCombination.getModifierKeys()) {
			robot.keyRelease(modifierKey);
		}
	}
}