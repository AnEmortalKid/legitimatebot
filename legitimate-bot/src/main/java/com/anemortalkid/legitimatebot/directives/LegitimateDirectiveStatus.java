package com.anemortalkid.legitimatebot.directives;

public class LegitimateDirectiveStatus {

	private final String directiveName;

	private final LegitimateDirectiveStatusType statusType;

	private int delayCount;
	private int delayMax;
	private int iterationNumber;
	private int maxIterations;

	public LegitimateDirectiveStatus(String directiveName,
			LegitimateDirectiveStatusType statusType) {
		this.directiveName = directiveName;
		this.statusType = statusType;
	}

	public String getDirectiveName() {
		return directiveName;
	}

	public LegitimateDirectiveStatusType getStatusType() {
		return statusType;
	}

	public int getDelayCount() {
		return delayCount;
	}

	public int getDelayMax() {
		return delayMax;
	}

	public void setDelayCount(int delayCount) {
		this.delayCount = delayCount;
	}

	public void setDelayMax(int delayMax) {
		this.delayMax = delayMax;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	public void setIterationNumber(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

}
