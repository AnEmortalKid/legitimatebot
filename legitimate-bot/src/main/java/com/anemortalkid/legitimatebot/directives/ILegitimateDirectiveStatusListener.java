package com.anemortalkid.legitimatebot.directives;

/**
 * An {@link ILegitimateDirectiveStatusListener} listens to a directive and
 * receives notifications when the directive status changes
 * 
 * @author JMonterrubio
 *
 */
public interface ILegitimateDirectiveStatusListener {

    /**
     * Notifies this {@link ILegitimateDirectiveStatusListener} of the status of
     * the {@link ILegitimateDirective} that this listener is listening to
     * 
     * @param directiveStatus
     *            the directive status of the directive that this listener is
     *            listening to
     */
    void notifyDirectiveStatusChanged(LegitimateDirectiveStatus directiveStatus);

}
