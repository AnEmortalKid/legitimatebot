package com.anemortalkid.legitimatebot.keyboard;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class LegitimateKeyMappings {

    public static final int[] SHIFT_MODIFIER = new int[] { KeyEvent.VK_SHIFT };

    private static Map<Character, LegitimateCommandKeyCombination> specialKeys = new HashMap<Character, LegitimateCommandKeyCombination>();

    // Store the mappings that do not work automagically
    static {
	specialKeys.put('!', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_1));
	specialKeys.put('@', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_2));
	specialKeys.put('#', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_3));
	specialKeys.put('$', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_4));
	specialKeys.put('%', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_5));
	specialKeys.put('^', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_6));
	specialKeys.put('&', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_7));
	specialKeys.put('*', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_8));
	specialKeys.put('(', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_9));
	specialKeys.put(')', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_0));

	specialKeys.put('_', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_MINUS));
	specialKeys.put('+', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_EQUALS));

	specialKeys.put(':', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_SEMICOLON));
	specialKeys.put('"', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_QUOTE));

	specialKeys.put('<', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_COMMA));
	specialKeys.put('>', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_PERIOD));
	specialKeys.put('?', getCommandKeyCombination(SHIFT_MODIFIER, KeyEvent.VK_SLASH));

	specialKeys.put('{', getCommandKeyCombination(SHIFT_MODIFIER, getKeyCode('[')));
	specialKeys.put('}', getCommandKeyCombination(SHIFT_MODIFIER, getKeyCode(']')));
	specialKeys.put('|', getCommandKeyCombination(SHIFT_MODIFIER, getKeyCode('\\')));
	specialKeys.put('~', getCommandKeyCombination(SHIFT_MODIFIER, getKeyCode('`')));
    }

    /**
     * Convenience method just so we don't have super long things in the map
     */
    private static LegitimateCommandKeyCombination getCommandKeyCombination(int[] keyModifiers,
	    int... keys) {
	return LegitimateKeyboardUtilities.getCommandKeyCombination(keyModifiers, keys);
    }

    public static boolean isUpperCase(Character character) {
	return Character.isUpperCase((int) character);
    }

    public static boolean isSpecialCharacter(Character character) {
	return specialKeys.containsKey(character);
    }

    public static LegitimateCommandKeyCombination getSpecialCharacterCombination(Character character) {
	return specialKeys.get(character);
    }

    public static int getKeyCode(Character character) {
	return KeyEvent.getExtendedKeyCodeForChar(character);
    }

}
