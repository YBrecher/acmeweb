package com.acme.servermgr;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project.
 * Treat this as a 'black box' that gives back indicators like up, running etc for
 * various 'services' that are being managed.
 */
public class ServerManager {

    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
    static public String getCurrentServerStatus() {
        return "up ";  // The server is up
    }

    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally()
    {
        return true;
    }

    /**
     * Get the operational status of this server
     * @return a descriptive string about the servers operational status
     */
    static public String getOperationalStatus(){return "and is operating normally ";}

    /**
     * Get the status of this server's memory
     * @return a descriptive string about the servers memory status
     */
    static public String getMemoryStatus(){return "and its memory is running low ";}

    /**
     * Get the status of this server's extensions
     * @return a descriptive string about the servers extensions
     */
    static public String getExtensionsStatus(){return "and is using these extensions -" +
            " [Hypervisor, Kubernetes, RAID-6] ";}
}
