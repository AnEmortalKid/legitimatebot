package com.anemortalkid.legitimatebot.directives;

public class DefaultSysoutStatusListener implements ILegitimateDirectiveStatusListener {

    @Override
    public void notifyDirectiveStatusChanged(LegitimateDirectiveStatus directiveStatus) {
	System.out.println(directiveStatus.getDirectiveName() + "->"
		+ directiveStatus.getStatusType());
    }

}
