package br.edu.ifpb.intermediateservices;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 9090);
        component.getDefaultHost().attach("/SorteioService", new MainApplication());
        component.start();
        
    }
}
