package com.acme.statusmgr.beans;

/**
 * This abstract class will be extended by all the decorator classes of ServerStatus. It implements
 * the Status interface and therefore has the three variables of id, contentHeader, and statusDesc,
 * as well as their getter methods. The constructor takes a Status object as a parameter and uses
 * it to get all of its variables.
 */
public abstract class ServerStatusDecorator implements Status{
    protected Status status;

    long id;
    String contentHeader;
    String statusDesc;

    public ServerStatusDecorator(Status status){
        this.status = status;

        statusDesc = status.getStatusDesc();
        id = status.getId();
        contentHeader = status.getContentHeader();
    }

    public String getStatusDesc() {return statusDesc;}

    public String getContentHeader(){return contentHeader;}

    public long getId(){return id;}
}
