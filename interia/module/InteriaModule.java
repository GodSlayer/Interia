package interia.module;

import interia.lib.module.Module;

public class InteriaModule extends Module
{
	private String theName;
	private Category theCategory;
	
	private int theKeyBind;
	
	private boolean isToggled;
	
	public InteriaModule(String theName, Category theCategory)
	{
		this.theName = theName;
		this.theCategory = theCategory;
	}
	
	public String getName()
	{
		return this.theName;
	}
	
	public Category getCategory()
	{
		return this.theCategory;
	}
	
	public int getKeyBind()
	{
		return this.theKeyBind;
	}
	
	public boolean isToggled()
	{
		return this.isToggled;
	}
	
	public void setKeyBind(int newKey)
	{
		this.theKeyBind = newKey;
	}
	
	public void setToggled(boolean shouldToggle)
	{
		this.onToggle();
		if(shouldToggle)
		{
			this.onEnable();
			this.isToggled = true;
		}else
		{
			this.onDisable();
			this.isToggled = false;
		}
	}
	
	public void toggleModule()
	{
		this.setToggled(!this.isToggled);
	}
	
	public void onToggle(){}
	
	public void onEnable(){}
	
	public void onDisable(){}
}
