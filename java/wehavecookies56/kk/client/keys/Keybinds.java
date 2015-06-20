package wehavecookies56.kk.client.keys;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

public enum Keybinds {

	OPENMENU("key.kingdomkeys.openmenu", Keyboard.KEY_M);
	
	private final KeyBinding keybinding;
	
	private Keybinds(String name, int defaultKey){
		keybinding = new KeyBinding(name, defaultKey, "key.categories.kingdomkeys");
	}
	
	public KeyBinding getKeybind(){
		return keybinding;
	}
	
	public boolean isPressed(){
		return keybinding.isPressed();
	}
	
}