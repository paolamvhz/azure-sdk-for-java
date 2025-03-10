// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for ExpandEnum.
 */
public final class ExpandEnum extends ExpandableStringEnum<ExpandEnum> {
    /**
     * Static value links for ExpandEnum.
     */
    public static final ExpandEnum LINKS = fromString("links");

    /**
     * Static value metadata for ExpandEnum.
     */
    public static final ExpandEnum METADATA = fromString("metadata");

    /**
     * Creates a new instance of ExpandEnum value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ExpandEnum() {
    }

    /**
     * Creates or finds a ExpandEnum from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ExpandEnum.
     */
    public static ExpandEnum fromString(String name) {
        return fromString(name, ExpandEnum.class);
    }

    /**
     * Gets known ExpandEnum values.
     * 
     * @return known ExpandEnum values.
     */
    public static Collection<ExpandEnum> values() {
        return values(ExpandEnum.class);
    }
}
