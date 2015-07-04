package com.anemortalkid.legitimatebot.keyboard;

import java.awt.Robot;

import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;

public class LegitimateTypeStringDirective implements ILegitimateDirective{

	private String string;

	public LegitimateTypeStringDirective(String string)
	{
		this.string = string;
	}
	
	public void runDirective(Robot robot) {
		// TODO Auto-generated method stub
		
	}
	
}
