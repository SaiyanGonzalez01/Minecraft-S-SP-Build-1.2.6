package org.lwjgl.input;

import org.lwjgl.opengl.GL11;

public class Keyboard extends GL11 {

	public static boolean next() {
		return keysNext();
	}

	public static char getEventCharacter() {
		return getEventChar();
	}

}
