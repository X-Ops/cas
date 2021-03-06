package org.apereo.cas.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apereo.cas.authentication.principal.Principal;

import java.io.Serializable;
import java.util.Map;

/**
 * The release policy that decides how attributes are to be released for a given service.
 * Each policy has the ability to apply an optional filter.
 *
 * @author Misagh Moayyed
 * @since 4.1.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
public interface RegisteredServiceAttributeReleasePolicy extends Serializable {

    /**
     * Is authorized to release credential password?
     *
     * @return true/false
     */
    boolean isAuthorizedToReleaseCredentialPassword();

    /**
     * Is authorized to release proxy granting ticket?
     *
     * @return true/false
     */
    boolean isAuthorizedToReleaseProxyGrantingTicket();

    /**
     * Sets the attribute filter.
     *
     * @param filter the new attribute filter
     */
    void setAttributeFilter(RegisteredServiceAttributeFilter filter);

    /**
     * Gets the attributes, having applied the filter.
     *
     * @param p the principal that contains the resolved attributes
     * @return the attributes
     */
    Map<String, Object> getAttributes(Principal p);
}
