package se.diversify.multivaders.strategy;

import se.diversify.multivaders.event.KeyEvent;

import static se.diversify.multivaders.event.KeyEvent.*;
import static se.diversify.multivaders.event.KeyEvent.ClickType.*;

public class BasedOnPreviousStrategy extends AbstractStrategy {

    private KeyEvent oldEvent;

    @Override
    public void process(KeyEvent newEvent) {
        KeyEvent toReturn = null;
        if (oldEvent.getClickType() == down) {
            if (oldEvent.getFunction() == newEvent.getFunction() && newEvent.getClickType() == up) {
                toReturn = newEvent;
            }
        } else {
            if (newEvent.getClickType() == down) {
                toReturn = newEvent;
            }
        }
        decisionMaker.sendResponse(toReturn);
    }
}
