package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * This is a decorator class which takes a Status object as a parameter (this could be a
 * ServerStatus object or it could be a ServerStatusDecorator object) and it adds on to the
 * statusDesc variable. The addition comes from the ServerManager's getOperationalStatus() method
 * which returns the string "and is operating normally".
 */
public class OperationalDecorator extends ServerStatusDecorator{

    public OperationalDecorator(Status status){
      super(status);

        statusDesc += ServerManager.getOperationalStatus();
    }
}
