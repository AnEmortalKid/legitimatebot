package com.anemortalkid.legitimatebot.directives;

import java.util.List;

import com.anemortalkid.legitimatebot.LegitimateBot;

/**
 * A {@link LegitimateRoutine} is a list of directives that a
 * {@link LegitimateBot} can run
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateRoutine {

	private List<ILegitimateDirective> directives;
	private String routineName;

	/**
	 * Constructs a LegitimateRoutine
	 * 
	 * @param routineName
	 *            the name of this legitimate routine
	 * @param directives
	 *            the list of legitimate directives that will comprise this
	 *            routine
	 */
	public LegitimateRoutine(String routineName,
			List<ILegitimateDirective> directives) {
		this.routineName = routineName;
		this.directives = directives;
	}

	/**
	 * The name of this routine
	 * 
	 * @return routineName the name of this routine
	 */
	public String getRoutineName() {
		return routineName;
	}

	/**
	 * The list of {@link ILegitimateDirective} that make up this routine
	 * 
	 * @return a list of {@link ILegitimateDirective} that make up this routine
	 */
	public List<ILegitimateDirective> getDirectives() {
		return directives;
	}
}
