package com.anemortalkid.legitimatebot.directives;

/**
 * A {@link LegitimateDirectiveStatusType} indicates what status an
 * {@link ILegitimateDirective} is in
 * 
 * @author JMonterrubio
 *
 */
public enum LegitimateDirectiveStatusType {

	/**
	 * Indicates that the {@link ILegitimateDirective} is running
	 */
	RUNNING,

	/**
     * 
     */
	DELAYING,

	/**
	 * Repeating
	 */
	REPEATING,

	/**
	 * Indicates that the {@link ILegitimateDirective} is done running
	 */
	COMPLETE,

}
