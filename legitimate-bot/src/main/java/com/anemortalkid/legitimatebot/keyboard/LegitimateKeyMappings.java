package com.anemortalkid.legitimatebot.keyboard;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class LegitimateKeyMappings {

	private static Map<Character, LegitimateCommandKeyCombination> specialKeys = new HashMap<Character, LegitimateCommandKeyCombination>();

	private static int[] holdShift = new int[] { KeyEvent.VK_SLASH };

	// Store the mappings that do not work automagically
	static {
		/**
		 * ~!@#$%^&*()_+{}:"<>?|
		 */
		specialKeys.put('!', getCombination(holdShift, KeyEvent.VK_1));
		specialKeys.put('@', getCombination(holdShift, KeyEvent.VK_2));
		specialKeys.put('#', getCombination(holdShift, KeyEvent.VK_3));
		specialKeys.put('$', getCombination(holdShift, KeyEvent.VK_4));
		specialKeys.put('%', getCombination(holdShift, KeyEvent.VK_5));
		specialKeys.put('^', getCombination(holdShift, KeyEvent.VK_6));
		specialKeys.put('&', getCombination(holdShift, KeyEvent.VK_7));
		specialKeys.put('*', getCombination(holdShift, KeyEvent.VK_8));
		specialKeys.put('(', getCombination(holdShift, KeyEvent.VK_9));
		specialKeys.put(')', getCombination(holdShift, KeyEvent.VK_0));
		
		
		specialKeys.put('_', getCombination(holdShift, KeyEvent.VK_MINUS));
		specialKeys.put('+', getCombination(holdShift, KeyEvent.VK_EQUALS));
		
		specialKeys.put('{', getCombination(holdShift, KeyEvent.VK_BRACELEFT));
		specialKeys.put('}', getCombination(holdShift, KeyEvent.VK_BRACERIGHT));
		
		specialKeys.put(':', getCombination(holdShift, KeyEvent.VK_SEMICOLON));
		specialKeys.put('"', getCombination(holdShift, KeyEvent.VK_QUOTE));
		
		specialKeys.put('<', getCombination(holdShift, KeyEvent.VK_COMMA));
		specialKeys.put('>', getCombination(holdShift, KeyEvent.VK_PERIOD));
		specialKeys.put('?', getCombination(holdShift, KeyEvent.VK_SLASH));
	}
	
	public static Map<Character, LegitimateCommandKeyCombination> getSpecialKeys() {
		return specialKeys;
	}

	public static boolean requiresCommandKeyCmbination(Character character) {
		if(KeyEvent.getExtendedKeyCodeForChar(character) == KeyEvent.VK_UNDEFINED)
			return true;

		if (isUpperCase(character))
			return true;
		
		if (specialKeys.containsKey(character))
			return true;

		return false;
	}

	public static LegitimateCommandKeyCombination getCombinationForCharacter(
			Character character) {

		if (isUpperCase(character)) {
			return getCombination(holdShift,
					KeyEvent.getExtendedKeyCodeForChar(character));
		}

		return null;
	}

	private static LegitimateCommandKeyCombination getCombination(int[] modifiers,
			int... keys) {
		return new LegitimateCommandKeyCombination(modifiers, keys);
	}

	private static boolean isUpperCase(Character character) {
		return Character.isUpperCase((int) character);
	}
	
	private static boolean isSpecialCharacter(Character character)
	{
		return specialKeys.containsKey(character);
	}
	
	private static int getKeyCode(Character character) {
		return KeyEvent.getExtendedKeyCodeForChar(character);
	}
	
	public static void main(String[] args) {
		String testString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+}{\":?><|~";
		for(Character c : testString.toCharArray())
		{
			System.out.println("Char='"+ c +"' requiresMod="+requiresCommandKeyCmbination(c)+" isUppercase:" + isUpperCase(c) + " isSpecialCharacter:" + isSpecialCharacter(c));
		}
//		System.out.println("<="+KeyEvent.getExtendedKeyCodeForChar('<'));
//		System.out.println(">="+KeyEvent.getExtendedKeyCodeForChar('>'));
//		System.out.println("[="+KeyEvent.getExtendedKeyCodeForChar('['));
//		System.out.println("]="+KeyEvent.getExtendedKeyCodeForChar(']'));
	}
}
