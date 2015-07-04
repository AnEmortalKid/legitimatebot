package com.anemortalkid.legitimatebot.directives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractLegitimateDirective implements
		ILegitimateDirective {

	private final String directiveName;
	private final List<ILegitimateDirectiveStatusListener> statusListeners;

	public AbstractLegitimateDirective(String directiveName) {
		this.directiveName = directiveName;
		statusListeners = new ArrayList<ILegitimateDirectiveStatusListener>();
	}

	@Override
	public String getDirectiveName() {
		return directiveName;
	}

	@Override
	public void addDirectiveStatusListener(
			ILegitimateDirectiveStatusListener directiveStatusListener) {
		statusListeners.add(directiveStatusListener);
	}

	@Override
	public void removeDirectiveStatusListener(
			ILegitimateDirectiveStatusListener directiveStatusListener) {
		statusListeners.remove(directiveStatusListener);
	}

	@Override
	public List<ILegitimateDirectiveStatusListener> getStatusListeners() {
		return Collections.unmodifiableList(statusListeners);
	}

	@Override
	public String toString() {
		return "directiveName=" + directiveName;
	}

}
