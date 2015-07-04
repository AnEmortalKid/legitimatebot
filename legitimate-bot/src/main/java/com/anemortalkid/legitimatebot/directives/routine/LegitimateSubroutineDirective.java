package com.anemortalkid.legitimatebot.directives.routine;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import com.anemortalkid.legitimatebot.directives.AbstractLegitimateDirective;
import com.anemortalkid.legitimatebot.directives.DefaultSysoutStatusListener;
import com.anemortalkid.legitimatebot.directives.ILegitimateDirective;
import com.anemortalkid.legitimatebot.directives.ILegitimateDirectiveStatusListener;
import com.anemortalkid.legitimatebot.directives.delay.LegitimateDelayDirective;
import com.anemortalkid.legitimatebot.directives.keyboard.LegitimateTypeTextDirective;

public class LegitimateSubroutineDirective extends AbstractLegitimateDirective {

    private final List<ILegitimateDirective> directives;

    public LegitimateSubroutineDirective(String directiveName, List<ILegitimateDirective> directives) {
	super(directiveName);
	this.directives = new ArrayList<ILegitimateDirective>();
	this.directives.addAll(directives);
    }

    @Override
    public void runDirective(Robot robot) {

	for (final ILegitimateDirectiveStatusListener listener : getStatusListeners()) {
	    for (final ILegitimateDirective d : directives) {
		d.addDirectiveStatusListener(listener);
	    }
	}

	directives.forEach(directive -> directive.runDirectiveAndNotify(robot));

	for (final ILegitimateDirectiveStatusListener listener : getStatusListeners()) {
	    for (final ILegitimateDirective d : directives) {
		d.removeDirectiveStatusListener(listener);
	    }
	}
    }

    public static void main(String[] args) {
	final LegitimateDelayDirective delay = new LegitimateDelayDirective("delay 5 secs", 5000);

	final LegitimateTypeTextDirective type1 = new LegitimateTypeTextDirective("type \"A\"", "A");
	final LegitimateTypeTextDirective type2 = new LegitimateTypeTextDirective("type \"B\"", "B");
	final LegitimateTypeTextDirective type3 = new LegitimateTypeTextDirective("type \"C\"", "C");

	final List<ILegitimateDirective> directives = new ArrayList<ILegitimateDirective>();
	directives.add(delay);
	directives.add(type1);
	directives.add(type2);
	directives.add(type3);
	final LegitimateSubroutineDirective legitimateSubroutine = new LegitimateSubroutineDirective(
		"type \"ABC\"", directives);
	final DefaultSysoutStatusListener dssl = new DefaultSysoutStatusListener();
	legitimateSubroutine.addDirectiveStatusListener(dssl);
	Robot robot = null;
	try {
	    robot = new Robot();
	    legitimateSubroutine.runDirective(robot);
	} catch (final AWTException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// ABC
    }

}
