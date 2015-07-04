package com.anemortalkid.legitimatebot.directives;

public class LegitimateDirectiveStatus {

    private final String directiveName;

    private final LegitimateDirectiveStatusType statusType;

    public LegitimateDirectiveStatus(String directiveName, LegitimateDirectiveStatusType statusType) {
	super();
	this.directiveName = directiveName;
	this.statusType = statusType;
    }

    public String getDirectiveName() {
	return directiveName;
    }

    public LegitimateDirectiveStatusType getStatusType() {
	return statusType;
    }

}
