package com.anemortalkid.legitimatebot.directives;

public class DefaultSysoutStatusListener implements
		ILegitimateDirectiveStatusListener {

	@Override
	public void notifyDirectiveStatusChanged(
			LegitimateDirectiveStatus directiveStatus) {

		switch (directiveStatus.getStatusType()) {
		case DELAYING:
			int delayCount = directiveStatus.getDelayCount();
			int delayMax = directiveStatus.getDelayMax();
			System.out.print(delayCount
					+ (delayCount != delayMax ? "->" : "\n"));
			break;
		case REPEATING:
			int repeatCount = directiveStatus.getIterationNumber();
			int repeatMax = directiveStatus.getMaxIterations();
			System.out.println(directiveStatus.getDirectiveName() + "\tIteration: " + repeatCount + "/" + repeatMax);
			break;
		case RUNNING:
		case COMPLETE:
			System.out.println(directiveStatus.getDirectiveName() + "->"
					+ directiveStatus.getStatusType());
			break;
		default:
			throw new UnsupportedOperationException(
					"Unhandled directiveStatusType: "
							+ directiveStatus.getStatusType());
		}
	}
}
