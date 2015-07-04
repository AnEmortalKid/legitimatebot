package com.anemortalkid.legitimatebot.directives;

import java.awt.Robot;
import java.util.List;

/**
 * An IDirective is a set of commands a robot must perform
 * 
 * @author JMonterrubio
 */
public interface ILegitimateDirective {

	/**
	 * The name of this directive
	 * 
	 * @return
	 */
	String getDirectiveName();

	/**
	 * Runs the given directive on a robot
	 */
	void runDirective(Robot robot);

	/**
	 * Runs a directive and notifies the listeners that the directive is running
	 * and when directive is complete
	 * 
	 * @param robot
	 *            the robot to run the directive on
	 */
	default void runDirectiveAndNotify(Robot robot) {
		notifyListeners(new LegitimateDirectiveStatus(getDirectiveName(),
				LegitimateDirectiveStatusType.RUNNING));
		runDirective(robot);
		notifyListeners(new LegitimateDirectiveStatus(getDirectiveName(),
				LegitimateDirectiveStatusType.COMPLETE));
	}

	/**
	 * Adds an {@link ILegitimateDirectiveStatusListener} to this
	 * {@link ILegitimateDirective}
	 * 
	 * @param directiveStatusListener
	 *            the listener that should receive notifications from the
	 *            directive
	 */
	void addDirectiveStatusListener(
			ILegitimateDirectiveStatusListener directiveStatusListener);

	/**
	 * Removes the given {@link ILegitimateDirectiveStatusListener} from this
	 * {@link ILegitimateDirective}
	 * 
	 * @param directiveStatusListener
	 *            the listener that should stop listening to this directive
	 */
	void removeDirectiveStatusListener(
			ILegitimateDirectiveStatusListener directiveStatusListener);

	List<ILegitimateDirectiveStatusListener> getStatusListeners();

	default void notifyListeners(LegitimateDirectiveStatus directiveStatus) {
		getStatusListeners().forEach(
				listener -> listener
						.notifyDirectiveStatusChanged(directiveStatus));
	}

}
