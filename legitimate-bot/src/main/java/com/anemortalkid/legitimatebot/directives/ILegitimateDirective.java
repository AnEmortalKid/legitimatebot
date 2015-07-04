package com.anemortalkid.legitimatebot.directives;

import java.awt.Robot;

/**
 * An IDirective is a set of commands a robot must perform
 * 
 * @author JMonterrubio
 */
public interface ILegitimateDirective {

	/**
	 * Runs the given directive on a robot
	 */
	void runDirective(Robot robot);

}
