package com.anemortalkid.legitimatebot.keyboard;

/**
 * A {@link LegitimateCommandKeyCombination} represents a complex keystroke that
 * requires some modifier keys (SHIFT,ALT,CONTROL,WINDOWS) and regular keys.
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateCommandKeyCombination extends LegitimateKeyCombination {

    private final int[] modifierKeys;

    public LegitimateCommandKeyCombination(int[] modifierKeys, int[] keys) {
	super(keys);
	this.modifierKeys = modifierKeys;
    }

    @Override
    public int[] getModifierKeys() {
	return modifierKeys;
    }
}