package com.anemortalkid.legitimatebot.directives.routine;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import com.anemortalkid.legitimatebot.directives.DefaultSysoutStatusListener;
import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;
import com.anemortalkid.legitimatebot.directives.LegitimateDirectiveStatus;
import com.anemortalkid.legitimatebot.directives.LegitimateDirectiveStatusType;
import com.anemortalkid.legitimatebot.directives.delay.LegitimateDelayDirective;
import com.anemortalkid.legitimatebot.directives.delay.LegitimateGranularDelayDirective;
import com.anemortalkid.legitimatebot.directives.keyboard.LegitimateTypeTextDirective;

/**
 * A {@link LegitimateRepeatableSubroutineDirective} is a
 * {@link LegitimateSubroutineDirective} that will be repeated a number of
 * iterations.
 * 
 * @author JM034719
 *
 */
public class LegitimateRepeatableSubroutineDirective extends
		LegitimateSubroutineDirective {

	private int iterationCount;

	/**
	 * Constructs a {@link LegitimateRepeatableSubroutineDirective}
	 * 
	 * @param directiveName
	 *            the name of the directive
	 * @param directives
	 *            the list of directives for this subroutine
	 * @param iterationCount
	 *            the number of times ot repeat the subroutine
	 */
	public LegitimateRepeatableSubroutineDirective(String directiveName,
			List<ILegitimateDirective> directives, int iterationCount) {
		super(directiveName, directives);
		this.iterationCount = iterationCount;
	}

	@Override
	public void runDirective(Robot robot) {
		addStatusListenersToDirectives();
		LegitimateDirectiveStatus repeatStatus = new LegitimateDirectiveStatus(
				getDirectiveName(), LegitimateDirectiveStatusType.REPEATING);
		repeatStatus.setMaxIterations(iterationCount);
		
		for (int i = 0; i < iterationCount; i++) {
			repeatStatus.setIterationNumber((i + 1));
			notifyListeners(repeatStatus);
			runInnerDirectivesWithNotification(robot);
		}
		
		removeStatusListenersFromDirectives();
	}

	public static void main(String[] args) {
		final LegitimateDelayDirective delay = new LegitimateGranularDelayDirective(
				"delay 5 secs", 5000, 1000);

		final LegitimateTypeTextDirective type1 = new LegitimateTypeTextDirective(
				"type \"A\"", "A");
		final LegitimateTypeTextDirective type2 = new LegitimateTypeTextDirective(
				"type \"B\"", "B");
		final LegitimateTypeTextDirective type3 = new LegitimateTypeTextDirective(
				"type \"C\"", "C");

		final List<ILegitimateDirective> directives = new ArrayList<ILegitimateDirective>();
		directives.add(delay);
		directives.add(type1);
		directives.add(type2);
		directives.add(type3);
		final LegitimateRepeatableSubroutineDirective legitimateSubroutine = new LegitimateRepeatableSubroutineDirective(
				"type \"ABC\"", directives, 5);
		final DefaultSysoutStatusListener dssl = new DefaultSysoutStatusListener();
		legitimateSubroutine.addDirectiveStatusListener(dssl);
		Robot robot = null;
		try {
			robot = new Robot();
			legitimateSubroutine.runDirective(robot);
		} catch (final AWTException e) {
			e.printStackTrace();
		}//
	}

}
