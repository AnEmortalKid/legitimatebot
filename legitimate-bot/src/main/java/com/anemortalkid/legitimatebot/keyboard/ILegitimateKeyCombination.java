package com.anemortalkid.legitimatebot.keyboard;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * An {@link ILegitimateKeyCombination} represents a combination of keys that
 * must be pressed in a particular sequence
 * 
 * @author JMonterrubio
 *
 */
public interface ILegitimateKeyCombination {

    public static int[] SHIFT_MODIFIER = new int[KeyEvent.VK_SHIFT];
    public static int[] CONTROL_MODIFIER = new int[KeyEvent.VK_CONTROL];
    public static int[] ALT_MODIFIER = new int[KeyEvent.VK_ALT];
    public static int[] ALTG_MODIFIER = new int[KeyEvent.VK_ALT_GRAPH];
    public static int[] WINDOWS_MODIFIER = new int[KeyEvent.VK_WINDOWS];

    /**
     * The keys to press as part of this {@link ILegitimateKeyCombination}
     * 
     * @return an array of key codes for the keys to press
     */
    int[] getKeys();

    /**
     * The modifiers to hold while pressing this
     * {@link ILegitimateKeyCombination}
     * 
     * @return an array of modifiers (SHIFT,ALT,CONTROL,WINDOWS)
     */
    default int[] getModifierKeys() {
	return null;
    }

    /**
     * Determines whether the modifierKeys are empty or not
     * 
     * @return <code>true</code> if the modifierKeys are null or empty,
     *         <code>false</code> otherwise
     */
    default boolean modifierKeysEmpty() {
	return getModifierKeys() == null || getModifierKeys().length == 0;
    }

    /**
     * Determines whether the keys are empty or not
     * 
     * @return <code>true</code> if the keys are null or empty,
     *         <code>false</code> otherwise
     */

    default boolean keysEmpty() {
	return getKeys() == null || getKeys().length == 0;
    }

    /**
     * Convinces the robot to type out this {@link ILegitimateKeyCombination}
     * 
     * @param robot
     *            the robot to persuade into typing out our
     *            {@link ILegitimateKeyCombination}
     */
    default void typeWithRobot(Robot robot) {

	// hold down moderinos
	if (!modifierKeysEmpty()) {
	    for (final int modifierKey : getModifierKeys()) {
		robot.keyPress(modifierKey);
	    }
	}

	// type out the other keys
	if (!keysEmpty()) {
	    for (final int key : getKeys()) {
		robot.keyPress(key);
		robot.keyRelease(key);
	    }
	}

	// release the moderinos
	if (!modifierKeysEmpty()) {
	    for (final int modifierKey : getModifierKeys()) {
		robot.keyRelease(modifierKey);
	    }

	}
    }

    /**
     * Returns a String version of the modifier keys that are associated with
     * this {@link ILegitimateKeyCombination}
     * 
     * @return a String version of the modifier keys
     */
    default String modifierKeysToString() {
	if (getModifierKeys() == null || getModifierKeys().length == 0) {
	    return "NO_MODIFIER_KEYS";
	}

	final StringBuilder bob = new StringBuilder();

	for (final int key : getModifierKeys()) {
	    String pretty = null;

	    switch (key) {
	    case KeyEvent.VK_SHIFT:
		pretty = "SHIFT";
		break;
	    case KeyEvent.VK_ALT:
	    case KeyEvent.VK_ALT_GRAPH:
		pretty = "ALT";
		break;
	    case KeyEvent.VK_CONTROL:
		pretty = "CONTROL";
		break;
	    case KeyEvent.VK_WINDOWS:
		pretty = "WINDOWS";
		break;
	    }

	    bob.append(pretty + ",");
	}
	bob.delete(bob.length() - 1, bob.length());
	return bob.toString();
    }
}
