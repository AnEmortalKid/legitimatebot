package com.anemortalkid.legitimatebot.keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Not sure what the point of classes like these are now that we have static
 * methods in interfaces... This class seems silly now.
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateKeyboardUtilities {

    static LegitimateCommandKeyCombination getCombinationForCharacter(Character character) {

	final int extendedKeyCodeForChar = KeyEvent.getExtendedKeyCodeForChar(character);

	if (LegitimateKeyMappings.isSpecialCharacter(character)) {
	    return LegitimateKeyMappings.getSpecialCharacterCombination(character);
	}

	if (extendedKeyCodeForChar != KeyEvent.VK_UNDEFINED) {
	    final int[] modifier = LegitimateKeyMappings.isUpperCase(character) ? LegitimateKeyMappings.SHIFT_MODIFIER
		    : new int[0];
	    return getCommandKeyCombination(modifier, extendedKeyCodeForChar);
	}

	return null;
    }

    static LegitimateCommandKeyCombination getCommandKeyCombination(int[] modifiers, int... keys) {
	return new LegitimateCommandKeyCombination(modifiers, keys);
    }

    static List<LegitimateCommandKeyCombination> getCombinationsForSimpleString(String string) {
	final List<LegitimateCommandKeyCombination> combinations = new ArrayList<LegitimateCommandKeyCombination>();

	for (final Character c : string.toCharArray()) {
	    combinations.add(getCombinationForCharacter(c));
	}

	final List<LegitimateCommandKeyCombination> mergedList = new ArrayList<LegitimateCommandKeyCombination>();
	LegitimateCommandKeyCombination merged = null;
	LegitimateCommandKeyCombination nextCombination = null;
	int lookaheadIndex = 0;
	for (int i = 0; i < combinations.size(); i++) {

	    if (merged == null) {
		merged = combinations.get(i);
		lookaheadIndex = 1;
	    }

	    nextCombination = combinations.get(lookaheadIndex);
	    while (canMerge(merged, nextCombination)) {
		merged = merge(merged, nextCombination);
		lookaheadIndex++;
		if (lookaheadIndex >= combinations.size()) {
		    mergedList.add(merged);
		    return mergedList;
		}
		nextCombination = combinations.get(lookaheadIndex);
	    }
	    mergedList.add(merged);
	    merged = nextCombination;
	    lookaheadIndex++;
	}

	return mergedList;
    }

    static boolean canMerge(LegitimateCommandKeyCombination kc1, LegitimateCommandKeyCombination kc2) {
	if (kc1 == null || kc2 == null) {
	    return false;
	}
	return Arrays.equals(kc1.getModifierKeys(), kc2.getModifierKeys());
    }

    static LegitimateCommandKeyCombination merge(LegitimateCommandKeyCombination kc1,
	    LegitimateCommandKeyCombination kc2) {

	final int kc1Length = kc1.getKeys().length;
	final int[] keys = new int[kc1Length + kc2.getKeys().length];
	for (int i = 0; i < keys.length; i++) {
	    if (i < kc1Length) {
		keys[i] = kc1.getKeys()[i];
	    } else {
		keys[i] = kc2.getKeys()[i - kc1Length];
	    }
	}

	return new LegitimateCommandKeyCombination(kc1.getModifierKeys(), keys);
    }

}
