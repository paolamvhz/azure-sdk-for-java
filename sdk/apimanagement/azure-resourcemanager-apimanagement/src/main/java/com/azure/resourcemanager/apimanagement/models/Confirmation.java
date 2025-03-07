// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Determines the type of confirmation e-mail that will be sent to the newly created user.
 */
public final class Confirmation extends ExpandableStringEnum<Confirmation> {
    /**
     * Static value signup for Confirmation.
     */
    public static final Confirmation SIGNUP = fromString("signup");

    /**
     * Static value invite for Confirmation.
     */
    public static final Confirmation INVITE = fromString("invite");

    /**
     * Creates a new instance of Confirmation value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Confirmation() {
    }

    /**
     * Creates or finds a Confirmation from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding Confirmation.
     */
    public static Confirmation fromString(String name) {
        return fromString(name, Confirmation.class);
    }

    /**
     * Gets known Confirmation values.
     * 
     * @return known Confirmation values.
     */
    public static Collection<Confirmation> values() {
        return values(Confirmation.class);
    }
}
