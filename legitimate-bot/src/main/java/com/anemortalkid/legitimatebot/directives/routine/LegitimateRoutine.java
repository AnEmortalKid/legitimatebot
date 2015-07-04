package com.anemortalkid.legitimatebot.directives.routine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.anemortalkid.legitimatebot.LegitimateBot;
import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;

/**
 * A {@link LegitimateRoutine} is a list of directives that a
 * {@link LegitimateBot} can run
 * 
 * @author JMonterrubio
 *
 */
public class LegitimateRoutine {

    private final List<ILegitimateDirective> directives;
    private final String routineName;

    /**
     * Constructs a LegitimateRoutine
     * 
     * @param routineName
     *            the name of this legitimate routine
     * @param directives
     *            the list of legitimate directives that will comprise this
     *            routine
     */
    public LegitimateRoutine(String routineName, List<ILegitimateDirective> directives) {
	this.routineName = routineName;
	this.directives = new ArrayList<ILegitimateDirective>();
	directives.addAll(directives);
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
	return (List<ILegitimateDirective>) Collections.unmodifiableCollection(directives);
    }
}
