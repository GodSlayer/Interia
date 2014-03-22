package interia.module.modules;

import org.lwjgl.input.Keyboard;

import interia.Interia;
import interia.module.Category;
import interia.module.InteriaModule;

public class Step extends InteriaModule{

	public Step() {
		super("Step", Category.PLAYER);
		this.setKeyBind(Keyboard.KEY_NONE);
	}
	
	@Override
	public void onEnable(){
		mc.thePlayer.stepHeight = 1.0f;
	}
	
	@Override
	public void onDisable(){
		mc.thePlayer.stepHeight = 0.5f;
	}

}
