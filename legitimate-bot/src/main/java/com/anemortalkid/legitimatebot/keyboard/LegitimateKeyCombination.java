package com.anemortalkid.legitimatebot.keyboard;

/**
 * A {@link LegitimateKeyCombination} is a simple combination of keys that do
 * not require modifier keys
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateKeyCombination implements ILegitimateKeyCombination {

    private final int[] keys;

    /**
     * Constructs a {@link LegitimateKeyCombination} with the given keys
     * 
     * @param keys
     *            the array of keys for this {@link LegitimateKeyCombination}
     */
    public LegitimateKeyCombination(int... keys) {
	this.keys = keys;
    }

    @Override
    public int[] getKeys() {
	return keys;
    }

    @Override
    public int[] getModifierKeys() {
	return null;
    }

    @Override
    public String toString() {
	final StringBuilder bob = new StringBuilder();
	bob.append("keyModifiers=[" + modifierKeysToString() + "]" + ", ");
	bob.append("keys=");

	if (getKeys() == null || getKeys().length == 0) {
	    bob.append("NO_KEYS");
	    return bob.toString();
	}

	for (final int i : getKeys()) {
	    bob.append((char) i);
	}

	return bob.toString();
    }
}
