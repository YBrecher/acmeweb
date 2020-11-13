package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * This is a decorator class which takes a Status object as a parameter (this could be a
 * ServerStatus object or it could be a ServerStatusDecorator object) and it adds on to the
 * statusDesc variable. The addition comes from the ServerManager's getExtensionsStatus() method
 * which returns the string "and is using these extensions - [Hypervisor, Kubernetes, RAID-6]".
 */
public class ExtensionsDecorator extends ServerStatusDecorator {

    public ExtensionsDecorator(Status status) {
        super(status);

        statusDesc += ServerManager.getExtensionsStatus();
    }
}
