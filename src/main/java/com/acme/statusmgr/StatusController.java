package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.statusmgr.beans.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();



    @RequestMapping("/status")
    public ServerStatus statusRequestHandler(@RequestParam(value="name", defaultValue="Anonymous") String name,
                                             @RequestParam(required = false) List<String> details) {
        System.out.println("***DEBUG INFO***" + details);
        return new ServerStatus(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/status/detailed")
    public Status detailedStatusRequestHandler(@RequestParam(value="name", defaultValue="Anonymous") String name,
                                               @RequestParam List<String> details) {
        System.out.println("***DEBUG INFO***" + details);

        Status status = new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));

        for (int i = 0; i < details.size(); i++){
            switch(details.get(i)){
                case "operations":
                    status = new OperationalDecorator(status);
                    break;
                case "extensions":
                    status = new ExtensionsDecorator(status);
                    break;
                case "memory":
                    status = new MemoryDecorator(status);
                    break;
            }
        }

        return status;
    }

}
