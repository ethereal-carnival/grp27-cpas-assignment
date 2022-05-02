package com.bitswilp.cpad.businessconstants;

public enum HMSAction {
    GET_STATISTICS("stats");

    private final String actionName;

    HMSAction(String actionName) {
        this.actionName = actionName;
    }
}
