package com.acme.statusmgr.beans;

/**
 * This is an interface which will be implemented by ServerStatus and all of its decorators.
 * It includes the three variable components of id, contentHeader, and statusDesc, as well as
 * their getters.
 */
public interface Status {
    long id = 0;
    String contentHeader = null;
    String statusDesc = null;

    long getId();
    String getContentHeader();
    String getStatusDesc();
}
