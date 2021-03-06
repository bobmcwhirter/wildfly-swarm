package org.wildfly.swarm.webservices.runtime;

import javax.inject.Inject;
import javax.inject.Named;

import org.wildfly.swarm.container.Interface;
import org.wildfly.swarm.spi.api.Customizer;
import org.wildfly.swarm.spi.api.SocketBindingGroup;
import org.wildfly.swarm.spi.runtime.annotations.Post;
import org.wildfly.swarm.webservices.WebServicesFraction;

/**
 * @author Bob McWhirter
 */
@Post
public class WSDLHostCustomizer implements Customizer {

    @Inject
    Interface iface;

    @Inject
    WebServicesFraction fraction;

    @Override
    public void customize() {
        if ( fraction.wsdlHost()  == null ) {
            fraction.wsdlHost( this.iface.getExpression() );
        }
    }
}
